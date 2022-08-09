package br.ufscar.dc.compiladores;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.LAParser.CmdAtribuicaoContext;
import br.ufscar.dc.compiladores.LAParser.CmdContext;
import br.ufscar.dc.compiladores.LAParser.CmdEscrevaContext;
import br.ufscar.dc.compiladores.LAParser.CmdFacaContext;
import br.ufscar.dc.compiladores.LAParser.CmdLeiaContext;
import br.ufscar.dc.compiladores.LAParser.CmdSeContext;
import br.ufscar.dc.compiladores.LAParser.Declaracao_localContext;
import br.ufscar.dc.compiladores.LAParser.ExpressaoContext;
import br.ufscar.dc.compiladores.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.LAParser.Tipo_basico_identContext;
import br.ufscar.dc.compiladores.LAParser.VariavelContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LASemantico extends LABaseVisitor<Void> {

    Escopos escoposAninhados = new Escopos();
    TabelaDeSimbolos tabela;


    public TipoLA verificaTipoBasico(String strTipoVar) {

        //System.out.println("TIPO BASICO\n");

        TipoLA tipoVar = TipoLA.INVALIDO;
        switch (strTipoVar) {
            case "inteiro":
                tipoVar = TipoLA.INTEIRO;
                break;
            case "^inteiro":
                tipoVar = TipoLA.INTEIRO;
                break;
            case "real":
                tipoVar = TipoLA.REAL;
                break;
            case "^real":
                tipoVar = TipoLA.REAL;
                break;
            case "literal":
                tipoVar = TipoLA.LITERAL;
                break;
            case "^literal":
                tipoVar = TipoLA.LITERAL;
                break;
            case "logico":
                tipoVar = TipoLA.LOGICO;
                break;
            case "^logico":
                tipoVar = TipoLA.LOGICO;
                break;
            case "registro":
                tipoVar = TipoLA.REGISTRO;
            default:
                // Nunca irá acontecer, pois o analisador sintático
                // não permite
                break;
        }

        return tipoVar;
    }

    public Void VerificaDeclaradaDuasVezes(TabelaDeSimbolos escopoAtual, String nomeVar, 
                                    TipoLA tipoVar, Token start) {
        if (escopoAtual.existe(nomeVar)) {
            LASemanticoUtils.adicionarErroSemantico(start,
                "identificador " + nomeVar + " ja declarado anteriormente");
                //System.out.println("DUAS VEZES " + nomeVar+"\n");
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
        //System.out.println("Declaracoes");
        for(LAParser.Decl_local_globalContext dec : ctx.decl_local_global()){
            visitDecl_local_global(dec);
        }
        return null;
    }

    @Override
    public Void visitDecl_local_global(LAParser.Decl_local_globalContext ctx){
        //System.out.println("LOCALGLOBAL\n");
        visitDeclaracao_local(ctx.declaracao_local());
        return null;
    }
    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        if (ctx.variavel() != null) {
            //System.out.println("LOCAL\n");
            visitVariavel(ctx.variavel());
        }
        return null;
    }


    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx){
        //System.out.println("VARIAVEL\n");
        TipoLA tipoVar = null;
        System.out.println(ctx.getText());
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();

        if(ctx.tipo().registro()!=null){
            tipoVar = TipoLA.REGISTRO;
            
            for(LAParser.IdentificadorContext id : ctx.identificador()){
                for(var ident: id.IDENT()){
                    for(VariavelContext vari : ctx.tipo().registro().variavel()){
                        TipoLA tipoSubVar = verificaTipoBasico(vari.tipo().getText());
                        for(IdentificadorContext id2 : vari.identificador()){
                            for(var ident2: id2.IDENT()){
                                String nomevar = ident.getText() +"."+ident2.getText();
                                VerificaDeclaradaDuasVezes(escopoAtual, nomevar, tipoSubVar, id2.getStart());
                            }
                        }
                    }
                    //VerificaDeclaradaDuasVezes(escopoAtual, ident.getText(), tipoVar, id.getStart());
                }
            }

        }else{
            tipoVar = verificaTipoBasico(ctx.tipo().getText());
        }

            
        visitTipo(ctx.tipo());
        

    
        for(LAParser.IdentificadorContext id : ctx.identificador()){
            for(var ident: id.IDENT()){
                System.out.println(ident.getText() + "," + tipoVar);
                VerificaDeclaradaDuasVezes(escopoAtual, ident.getText(), tipoVar, id.getStart());
            }

        }
        return null;
    }

    @Override
    public Void visitTipo(LAParser.TipoContext ctx){
        if(ctx.registro() != null){
            visitRegistro(ctx.registro());
        }else if(ctx.tipo_estendido() != null){
            visitTipo_estendido(ctx.tipo_estendido());
        }
        return null;
    }
    @Override 
    public Void visitRegistro(LAParser.RegistroContext ctx){
        System.out.println("VISITREGISTRO\n");
        System.out.println(ctx.getText());
        for (VariavelContext var : ctx.variavel()){
        
            visitVariavel(var);
        }
        return null;
    }

    @Override
    public Void visitTipo_estendido(LAParser.Tipo_estendidoContext ctx) {
        //System.out.println("TIPO ESTENDIDO\n");
        visitTipo_basico_ident(ctx.tipo_basico_ident());
        return null;
    };

    @Override
    public Void visitTipo_basico_ident(Tipo_basico_identContext ctx) {
        //System.out.println("Tipo BASICO IDENT\n");
        if(ctx.tipo_basico() == null){
            LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), 
            "tipo " + ctx.getText() + " nao declarado");
            //System.out.println("tipo " + ctx.getText() + " nao declarado");
        }
        return null;
    }

    @Override
    public Void visitIdentificador(IdentificadorContext ctx) {
        //System.out.println("IDENTFICADOR\n");
        //System.out.println(escopo.existe("sobrenome"));
        for (TabelaDeSimbolos escopoAtual : escoposAninhados.percorrerEscoposAninhados()) {
            
            for(var ident: ctx.IDENT()){
                if (!escopoAtual.existe(ident.getText())) {// n sei pq aqui tem q ser get 0

                    LASemanticoUtils.adicionarErroSemantico(ctx.start, 
                    "identificador " + ident.getText() + " nao declarado");
                }
            }
        }
        return null;
    }

    @Override
    public Void visitCorpo(LAParser.CorpoContext ctx){
        //System.out.println("CORPO\n");
        for(Declaracao_localContext dl: ctx.declaracao_local()){
            visitDeclaracao_local(dl);
        }

        for(CmdContext cmd : ctx.cmd()){
            visitCmd(cmd);
        }
        return null;
    }

    @Override
    public Void visitCmd(CmdContext ctx){
        if(ctx.cmdLeia()!= null){
            visitCmdLeia(ctx.cmdLeia());
        }
        if(ctx.cmdEscreva()!= null){
            visitCmdEscreva(ctx.cmdEscreva());
        }
        if(ctx.cmdSe()!= null){
            visitCmdSe(ctx.cmdSe());
        }
        if(ctx.cmdCaso()!= null){
            visitCmdCaso(ctx.cmdCaso());
        }
        if(ctx.cmdPara()!= null){
            visitCmdPara(ctx.cmdPara());
        }
        if(ctx.cmdEnquanto()!= null){
            visitCmdEnquanto(ctx.cmdEnquanto());
        }
        if(ctx.cmdFaca()!= null){
            visitCmdFaca(ctx.cmdFaca());
        }
        if(ctx.cmdAtribuicao()!= null){
            visitCmdAtribuicao(ctx.cmdAtribuicao());
        }
        if(ctx.cmdChamada()!= null){
            visitCmdRetorne(ctx.cmdRetorne());
        }
        return null;
    }

    @Override
    public Void visitCmdLeia(CmdLeiaContext ctx){
        //System.out.println("LEIA\n");
        for(IdentificadorContext id:ctx.identificador()){
            visitIdentificador(id);
        }
        return null;
    }

    @Override
    public Void visitCmdEscreva(CmdEscrevaContext ctx){
        for(ExpressaoContext exp : ctx.expressao()){
            visitExpressao(exp);
        }
        return null;
    }
    @Override
    public Void visitCmdFaca(CmdFacaContext ctx){
        for(CmdContext cmd : ctx.cmd()){
            visitCmd(cmd);
        }
        visitExpressao(ctx.expressao());
        return null;
    }

    @Override
    public Void visitCmdSe(CmdSeContext ctx){
        visitExpressao(ctx.expressao());
        for(CmdContext cmd : ctx.cmd()){
            visitCmd(cmd);
        }
        return null;
    }
    

    @Override
    public Void visitCmdAtribuicao(CmdAtribuicaoContext ctx){
        //System.out.println("\n\nATRIBUICAO" + ctx.start);
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();

        TipoLA tipoid = LASemanticoUtils.verificarTipo(tabela, ctx.identificador());
        //System.out.println(tipoid);

        TipoLA tipoexp = LASemanticoUtils.verificarTipo(tabela, ctx.expressao());
        if(tipoexp != TipoLA.INVALIDO){
            if (!tabela.existe(ctx.identificador().getText())) {
                LASemanticoUtils.adicionarErroSemantico(ctx.start, "identificador " + ctx.identificador().getText() + " nao declarado");
            } else if (tipoexp != tipoid && !((tipoid == TipoLA.REAL && tipoexp ==TipoLA.INTEIRO)||  (tipoid == TipoLA.INTEIRO && tipoexp ==TipoLA.REAL))) {
                if(ctx.getText().charAt(0) =='^'){
                    LASemanticoUtils.adicionarErroSemantico(ctx.start, "atribuicao nao compativel para ^" + ctx.identificador().getText());
                }else{
                    LASemanticoUtils.adicionarErroSemantico(ctx.start, "atribuicao nao compativel para " + ctx.identificador().getText());
                }

            }
        } else {
            LASemanticoUtils.adicionarErroSemantico(ctx.start, "atribuicao nao compativel para " + ctx.identificador().getText());
        }
        //System.out.println(tipoexp);
        return null;
    }
}