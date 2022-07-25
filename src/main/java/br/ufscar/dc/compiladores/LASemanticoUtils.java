package br.ufscar.dc.compiladores;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.LAParser.Exp_relacionalContext;
import br.ufscar.dc.compiladores.LAParser.ExpressaoContext;
import br.ufscar.dc.compiladores.LAParser.Fator_logicoContext;
import br.ufscar.dc.compiladores.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.LAParser.Parcela_logicaContext;
import br.ufscar.dc.compiladores.LAParser.Parcela_unarioContext;
import br.ufscar.dc.compiladores.LAParser.Termo_logicoContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LASemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        int coluna = t.getCharPositionInLine();
        errosSemanticos.add(String.format("Erro %d:%d - %s", linha, coluna, mensagem));
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Exp_aritmeticaContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for (var ta : ctx.termo()) {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, ta);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO) {
                adicionarErroSemantico(ctx.start, "Expressão " + ctx.getText() + " contém tipos incompatíveis");
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }

        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.TermoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;

        for (var fa : ctx.fator()) {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, fa);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO) {
                adicionarErroSemantico(ctx.start, "Termo " + ctx.getText() + " contém tipos incompatíveis");
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.FatorContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var pa:ctx.parcela()){
            TabelaDeSimbolos.TipoLA aux =  verificarTipo(tabela, pa);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                adicionarErroSemantico(ctx.start, "Expressão " +ctx.getText()+ " contém tipos incompatíveis");
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        // se não for nenhum dos tipos acima, só pode ser uma expressão
        // entre parêntesis
        return ret;
    }
    
    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.ParcelaContext ctx) {
        if(ctx.op_unario() != null){
            return verificarTipo(tabela, ctx.parcela_unario());
        }
        return verificarTipo(tabela, ctx.parcela_unario());
        
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, Parcela_unarioContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        if(ctx.identificador() != null){
            ret =  verificarTipo(tabela, ctx.identificador());
        }else if(ctx.IDENT() != null){
            for(var exp: ctx.expressao()){
                TabelaDeSimbolos.TipoLA aux =  verificarTipo(tabela, exp);
                if(ret == null){
                    ret = aux;
                }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                    adicionarErroSemantico(ctx.start, "Expressão " +ctx.getText()+ " contém tipos incompatíveis");
                    ret = TabelaDeSimbolos.TipoLA.INVALIDO;
                }
            }
        }else if(ctx.NUM_INT()!= null){
            ret =  TabelaDeSimbolos.TipoLA.INTEIRO;
        }else if(ctx.NUM_REAL()!= null){
            ret =  TabelaDeSimbolos.TipoLA.REAL;
        }else{
            for(var exp: ctx.expressao()){
                TabelaDeSimbolos.TipoLA aux =  verificarTipo(tabela, exp);
                if(ret == null){
                    ret = aux;
                }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                    adicionarErroSemantico(ctx.start, "Expressão " +ctx.getText()+ " contém tipos incompatíveis");
                    ret = TabelaDeSimbolos.TipoLA.INVALIDO;
                }
            }
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.ExpressaoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var tl: ctx.termo_logico()){
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, tl);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                adicionarErroSemantico(ctx.start, "Expressão " +ctx.getText()+ " contém tipos incompatíveis");
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Termo_logicoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var fl: ctx.fator_logico()){
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, fl);
            if(ret == null){
                ret = aux;
            }else if(ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                adicionarErroSemantico(ctx.start, "Expressão " +ctx.getText()+ " contém tipos incompatíveis");
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Fator_logicoContext ctx) {
        return verificarTipo(tabela,ctx.parcela_logica());
    }
    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Parcela_logicaContext ctx) {
        return verificarTipo(tabela, ctx.exp_relacional());
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Exp_relacionalContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for (var ea : ctx.exp_aritmetica()) {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, ea);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO) {
                adicionarErroSemantico(ctx.start, "Expressão " + ctx.getText() + " contém tipos incompatíveis");
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }

        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.IdentificadorContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for (var id : ctx.IDENT()) {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, id.getText());
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO) {
                adicionarErroSemantico(ctx.start, "Expressão " + ctx.getText() + " contém tipos incompatíveis");
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }

        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, String nomeVar) {
        return tabela.verificar(nomeVar);
    }
}