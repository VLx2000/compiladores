package br.ufscar.dc.compiladores;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.LAParser.Tipo_basico_identContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LASemantico extends LABaseVisitor<Void> {

    Escopos escoposAninhados = new Escopos();
    TabelaDeSimbolos tabela;

    public TipoLA verificaTipoBasico(String strTipoVar) {
        // System.out.println("opa2");
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
        return tipoVar;
    }

    public Void declaradaDuasVezes(TabelaDeSimbolos escopoAtual, String nomeVar, 
                                    TipoLA tipoVar, Token start) {
        if (escopoAtual.existe(nomeVar)) {
            LASemanticoUtils.adicionarErroSemantico(start, nomeVar
                    + " declarada duas vezes num mesmo escopo");
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
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.variavel() != null) {
            for (LAParser.IdentificadorContext id : ctx.variavel().identificador()) {
                declaradaDuasVezes(escopoAtual, 
                                    id.getText(), 
                                    verificaTipoBasico(ctx.variavel().getText()),
                                    id.getStart());
            }
            if (ctx.tipo() != null) {
                declaradaDuasVezes(escopoAtual, 
                                    ctx.IDENT().getText(), 
                                    verificaTipoBasico(ctx.tipo_basico().getText()),
                                    ctx.getStart());
            }
            return null;
        }

        if (ctx.tipo() != null || (ctx.valor_constante() != null && ctx.tipo_basico() != null)) {
            declaradaDuasVezes(escopoAtual, 
                                    ctx.IDENT().getText(), 
                                    verificaTipoBasico(ctx.tipo_basico().getText()),
                                    ctx.getStart());
        }

        return null;
    }

    @Override
    public Void visitTipo_basico_ident(Tipo_basico_identContext ctx) {
        System.out.println("opa");
        if (ctx.IDENT() != null) {
            for (TabelaDeSimbolos escopoAtual : escoposAninhados.percorrerEscoposAninhados()) {
                if (!escopoAtual.existe(ctx.IDENT().getText())) {
                    LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), 
                    "tipo " + ctx.IDENT().getText() + " nao declarado");
                }
            }
        }
        return null;
    }

    @Override
    public Void visitIdentificador(IdentificadorContext ctx) {
        // System.out.println("aqui");
        for (TabelaDeSimbolos escopoAtual : escoposAninhados.percorrerEscoposAninhados()) {
            if (!escopoAtual.existe(ctx.IDENT().get(0).getText())) {// n sei pq aqui tem q ser get 0
                LASemanticoUtils.adicionarErroSemantico(ctx.start, 
                "identificador " + ctx.IDENT().get(0).getText() + " nao declarado");
            }
        }
        return null;
    }
}
