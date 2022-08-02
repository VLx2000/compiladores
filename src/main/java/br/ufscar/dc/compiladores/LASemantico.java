package br.ufscar.dc.compiladores;

import org.antlr.v4.runtime.Token;
import org.stringtemplate.v4.STGroupDir;

import br.ufscar.dc.compiladores.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.LAParser.Tipo_basico_identContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LASemantico extends LABaseVisitor<Void> {

    Escopos escoposAninhados = new Escopos();
    TabelaDeSimbolos tabela;

    public Void visitTipo_basico(LAParser.Tipo_basicoContext ctx) {

        System.out.println("TIPO BASICO\n");
        String strTipoVar = ctx.getText();
        System.out.println("opa2" + strTipoVar);

        TipoLA tipoVar = TipoLA.INVALIDO;
        switch (strTipoVar) {
            case "inteiro":
                tipoVar = TipoLA.INTEIRO;
                break;
            case "real":
                tipoVar = TipoLA.REAL;
                break;
            case "literal":
                tipoVar = TipoLA.LITERAL;
                break;
            case "logico":
                tipoVar = TipoLA.LOGICO;
                break;
            default:
                // Nunca irá acontecer, pois o analisador sintático
                // não permite
                break;
        }
        if(tipoVar == TipoLA.INVALIDO){
            LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), 
            "tipo " + strTipoVar + " nao declarado");
            System.out.println("tipo " + strTipoVar + " nao declarado");
        }
        return null;
    }

    public Void declaradaDuasVezes(TabelaDeSimbolos escopoAtual, String nomeVar, 
                                    TipoLA tipoVar, Token start) {
        if (escopoAtual.existe(nomeVar)) {
            LASemanticoUtils.adicionarErroSemantico(start,
                "identificador " + nomeVar + " ja declarado anteriormente");
        } else {
            escopoAtual.adicionar(nomeVar, tipoVar);
        }
        return null;
    }

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracoes(LAParser.DeclaracoesContext ctx){
        for(LAParser.Decl_local_globalContext dec : ctx.decl_local_global()){
            visitDecl_local_global(dec);
        }
        return null;
    }

    @Override
    public Void visitDecl_local_global(LAParser.Decl_local_globalContext ctx){
        System.out.println("LOCALGLOBAL\n");
        visitDeclaracao_local(ctx.declaracao_local());
        return null;
    }
    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.variavel() != null) {
            System.out.println("LOCAL\n");
            visitVariavel(ctx.variavel());
            // for (LAParser.IdentificadorContext id : ctx.variavel().identificador()) {
            //     declaradaDuasVezes(escopoAtual, 
            //                         id.getText(), 
            //                         verificaTipoBasico(ctx.tipo()),
            //                         id.getStart());
            //}
        }
        return null;
    }

    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx){
        System.out.println("VARIAVEL\n");
        visitTipo(ctx.tipo());
        for(LAParser.IdentificadorContext id : ctx.identificador()){
            visitIdentificador(id);
        }
        return null;
    }

    @Override
    public Void visitTipo(LAParser.TipoContext ctx){
        System.out.println("TIPO\n");
        if(ctx.registro() != null){
            visitRegistro(ctx.registro());
        }else if(ctx.tipo_estendido() != null){
            visitTipo_estendido(ctx.tipo_estendido());
        }
        return null;
    }

    @Override
    public Void visitTipo_estendido(LAParser.Tipo_estendidoContext ctx) {
        System.out.println("TIPO ESTENDIDO\n");
        visitTipo_basico_ident(ctx.tipo_basico_ident());
        return null;
    };

    @Override
    public Void visitTipo_basico_ident(Tipo_basico_identContext ctx) {
        System.out.println("Tipo BASICO IDENT\n");
        if(ctx.tipo_basico() != null){
            visitTipo_basico(ctx.tipo_basico());
        }else{
            LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), 
            "tipo " + ctx.getText() + " nao declarado");
            System.out.println("tipo " + ctx.getText() + " nao declarado");
        }
        // if (ctx.IDENT() != null) {
        //     System.out.println("IDENT\n");
        //     TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        //     if (!escopoAtual.existe(ctx.IDENT().getText())) {
        //         LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), 
        //         "tipo " + ctx.IDENT().getText() + " nao declarado");
        //     }
        // }
        return null;
    }

    @Override
    public Void visitIdentificador(IdentificadorContext ctx) {
        System.out.println("IDENTFICADOR\n");
        for (TabelaDeSimbolos escopoAtual : escoposAninhados.percorrerEscoposAninhados()) {
            if (!escopoAtual.existe(ctx.IDENT().get(0).getText())) {// n sei pq aqui tem q ser get 0
                LASemanticoUtils.adicionarErroSemantico(ctx.start, 
                "identificador " + ctx.IDENT().get(0).getText() + " ja declarado anteriormente");
            }
        }
        return null;
    }
}