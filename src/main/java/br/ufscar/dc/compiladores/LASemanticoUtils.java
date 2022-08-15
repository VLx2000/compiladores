package br.ufscar.dc.compiladores;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.LAParser.Parcela_unarioContext;
import br.ufscar.dc.compiladores.LAParser.Parcela_nao_unarioContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LASemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    public static TipoLA verificarIncompativel(TabelaDeSimbolos.TipoLA aux, Token start, String text, TabelaDeSimbolos.TipoLA ret) {
        if (ret == null) {
            ret = aux;
        } else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO) {
            if ((ret == TipoLA.INTEIRO && aux ==TipoLA.REAL) || ret == TipoLA.REAL && aux ==TipoLA.INTEIRO ) {
                ret = TabelaDeSimbolos.TipoLA.REAL;
            } else {
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
            
        }
        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Exp_aritmeticaContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        //System.out.println("VERIFICA EXP AR\n");
        for (var te : ctx.termo()) {
            ret = verificarIncompativel(verificarTipo(tabela, te), ctx.start, ctx.getText(), ret);
        }

        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.TermoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        //System.out.println("VERIFICA Termo\n");
        for (var fa : ctx.fator()) {
            ret = verificarIncompativel(verificarTipo(tabela, fa), ctx.start, ctx.getText(), ret);
        }
        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.FatorContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        //System.out.println("VERIFICA Fator\n");
        for(var pa:ctx.parcela()){
            ret = verificarIncompativel(verificarTipo(tabela, pa), ctx.start, ctx.getText(), ret);
        }
        // se não for nenhum dos tipos acima, só pode ser uma expressão
        // entre parêntesis
        return ret;
    }
    
    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.ParcelaContext ctx) {
        //System.out.println("VERIFICA Parcela\n");
        if(ctx.parcela_unario() != null){
            return verificarTipo(tabela, ctx.parcela_unario());
        }else{
            return verificarTipo(tabela, ctx.parcela_nao_unario());
        }
        
        
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, Parcela_unarioContext ctx) {
        //System.out.println("VERIFICA Unario\n");

        TabelaDeSimbolos.TipoLA ret = null;
        if(ctx.identificador() != null){
            String nomeVar;
            if (ctx.identificador().dimensao().exp_aritmetica().size() > 0) {
                nomeVar = ctx.identificador().IDENT(0).getText();
            } else {
                nomeVar = ctx.identificador().getText();
            }
            if (tabela.existe(nomeVar)) {
                ret = tabela.verificar(nomeVar);
            } else {
                TabelaDeSimbolos escopoGlobal = LASemantico.escoposAninhados.obterEscopoGlobal();
                if (escopoGlobal.existe(nomeVar)) {
                    ret = escopoGlobal.verificar(nomeVar);
                } else {
                    adicionarErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                    ret = TabelaDeSimbolos.TipoLA.INVALIDO;
                }
            }
        }else if(ctx.IDENT() != null){
            //System.out.println("AQUI2\n");
            if (LASemantico.funcoes.containsKey(ctx.IDENT().getText())) {
                List<TabelaDeSimbolos.TipoLA> aux = LASemantico.funcoes.get(ctx.IDENT().getText());
                if (aux.size()-1 == ctx.expressao().size()) {
                    for (int i = 0; i < ctx.expressao().size(); i++) {
                        if (aux.get(i) != verificarTipo(tabela, ctx.expressao().get(i))) {
                            adicionarErroSemantico(ctx.expressao().get(i).getStart(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                        }
                    }
                    ret = aux.get(aux.size()-1);
                } else {
                    adicionarErroSemantico(ctx.IDENT().getSymbol(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                }
            } else {
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }       
        else if(ctx.NUM_INT()!= null){
            //System.out.println("AQUI3\n");
            ret =  TabelaDeSimbolos.TipoLA.INTEIRO;
        }else if(ctx.NUM_REAL()!= null){
            //System.out.println("AQUI4\n");
            ret =  TabelaDeSimbolos.TipoLA.REAL;
        }else{
            ret = verificarTipo(tabela, ctx.expressao().get(0));
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, Parcela_nao_unarioContext ctx) {
        //System.out.println("VERIFICA nao unario\n");
        if (ctx.CADEIA() != null) {
            return TabelaDeSimbolos.TipoLA.LITERAL;
        } else {
            String nomeVar = ctx.identificador().getText();
            if (!tabela.existe(nomeVar)) {
                adicionarErroSemantico(ctx.identificador().getStart(), "identificador " + nomeVar + " nao declarado");
                return TabelaDeSimbolos.TipoLA.INVALIDO;
            } else {
                return tabela.verificar(nomeVar);
            }
        }
    }

    public static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.ExpressaoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        //System.out.println("VERIFICAEXP\n");
        for(var tl: ctx.termo_logico()){
            ret = verificarIncompativel(verificarTipo(tabela, tl), ctx.start, ctx.getText(), ret);
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Termo_logicoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        //System.out.println("VERIFICA TERMO LÓGICO\n");
        for(var fl: ctx.fator_logico()){
            ret = verificarIncompativel(verificarTipo(tabela, fl), ctx.start, ctx.getText(), ret);
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Fator_logicoContext ctx) {
        //System.out.println("VERIFICA FATOR LÓGICO\n");
        
        return verificarTipo(tabela,ctx.parcela_logica());
    }
    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Parcela_logicaContext ctx) {
        //System.out.println("VERIFICA PARCELA LOGICA\n");
        if(ctx.exp_relacional() != null){
            return verificarTipo(tabela, ctx.exp_relacional());
        }else{
            return TipoLA.LOGICO;
        }
       
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Exp_relacionalContext ctx) {
        TabelaDeSimbolos.TipoLA exp1 = null;
        exp1 = verificarTipo(tabela, ctx.exp_aritmetica(0));
        if (ctx.exp_aritmetica(1) != null) {
            TabelaDeSimbolos.TipoLA exp2 = verificarTipo(tabela, ctx.exp_aritmetica(1));
            if (exp1 == exp2) {
                return TabelaDeSimbolos.TipoLA.LOGICO;
            } else {
                if ((exp1 == TabelaDeSimbolos.TipoLA.REAL && exp2 == TabelaDeSimbolos.TipoLA.INTEIRO) || (exp2 == TabelaDeSimbolos.TipoLA.REAL && exp1 == TabelaDeSimbolos.TipoLA.INTEIRO)) {
                    return TabelaDeSimbolos.TipoLA.LOGICO;
                } else {
                    return TabelaDeSimbolos.TipoLA.INVALIDO;
                }
            }
        } else {
            return exp1;
        }
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, String nomeVar) {
        //System.out.println("TIPO\n");
        if (tabela.existe(nomeVar)) {
            return tabela.verificar(nomeVar);
        } else {
            //System.out.println("NAO EXISTE\n");
            return TabelaDeSimbolos.TipoLA.INVALIDO;
        }
        
    }    
}