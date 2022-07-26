package br.ufscar.dc.compiladores;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;

import org.antlr.runtime.tree.TreeWizard.ContextVisitor;
import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.LAParser.Exp_relacionalContext;
import br.ufscar.dc.compiladores.LAParser.ExpressaoContext;
import br.ufscar.dc.compiladores.LAParser.Fator_logicoContext;
import br.ufscar.dc.compiladores.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.LAParser.Parcela_logicaContext;
import br.ufscar.dc.compiladores.LAParser.Parcela_unarioContext;
import br.ufscar.dc.compiladores.LAParser.TermoContext;
import br.ufscar.dc.compiladores.LAParser.Parcela_nao_unarioContext;
import br.ufscar.dc.compiladores.LAParser.Termo_logicoContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LASemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        int coluna = t.getCharPositionInLine();
        errosSemanticos.add(String.format("Erro %d:%d - %s", linha, coluna, mensagem));
    }

    public static TipoLA verificarIncompativel(TabelaDeSimbolos.TipoLA aux, Token start, String text, TabelaDeSimbolos.TipoLA ret) {
        if (ret == null) {
            ret = aux;
        } else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO) {
            adicionarErroSemantico(start, "Expressão " + text + " contém tipos incompatíveis");
            ret = TabelaDeSimbolos.TipoLA.INVALIDO;
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.DeclaracoesContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for (var dlg : ctx.decl_local_global()) {
            ret = verificarIncompativel(verificarTipo(tabela, dlg), ctx.start, ctx.getText(), ret);
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Decl_local_globalContext ctx) {
        if(ctx.declaracao_local() != null){
            return verificarTipo(tabela, ctx.declaracao_local());
        }
        else{
            return verificarTipo(tabela, ctx.declaracao_global());
        }
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Declaracao_localContext ctx) {
        if(ctx.variavel() != null){
            return verificarTipo(tabela, ctx.variavel());
        }
        else if(ctx.IDENT() != null){
            //falta terminar ainda
        }
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Exp_aritmeticaContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for (var te : ctx.termo()) {
            ret = verificarIncompativel(verificarTipo(tabela, te), ctx.start, ctx.getText(), ret);
        }

        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.TermoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;

        for (var fa : ctx.fator()) {
            ret = verificarIncompativel(verificarTipo(tabela, fa), ctx.start, ctx.getText(), ret);
        }
        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.FatorContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var pa:ctx.parcela()){
            ret = verificarIncompativel(verificarTipo(tabela, pa), ctx.start, ctx.getText(), ret);
        }
        // se não for nenhum dos tipos acima, só pode ser uma expressão
        // entre parêntesis
        return ret;
    }
    
    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.ParcelaContext ctx) {
        if(ctx.op_unario() != null){
            return verificarTipo(tabela, ctx.parcela_unario());
        }
        return verificarTipo(tabela, ctx.parcela_nao_unario());
        
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, Parcela_unarioContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        if(ctx.identificador() != null){
            ret =  verificarTipo(tabela, ctx.identificador());
        }else if(ctx.IDENT() != null){
            for(var exp: ctx.expressao()){
                ret = verificarIncompativel(verificarTipo(tabela, exp), ctx.start, ctx.getText(), ret);
            }
        }else if(ctx.NUM_INT()!= null){
            ret =  TabelaDeSimbolos.TipoLA.INTEIRO;
        }else if(ctx.NUM_REAL()!= null){
            ret =  TabelaDeSimbolos.TipoLA.REAL;
        }else{
            for(var exp: ctx.expressao()){
                ret = verificarIncompativel(verificarTipo(tabela, exp), ctx.start, ctx.getText(), ret);
            }
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, Parcela_nao_unarioContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        if(ctx.identificador() != null){
            ret =  verificarTipo(tabela, ctx.identificador());
        }else if(ctx.CADEIA() != null){
            ret =  TabelaDeSimbolos.TipoLA.CADEIA;
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.ExpressaoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var tl: ctx.termo_logico()){
            ret = verificarIncompativel(verificarTipo(tabela, tl), ctx.start, ctx.getText(), ret);
        }
        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.Termo_logicoContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for(var fl: ctx.fator_logico()){
            ret = verificarIncompativel(verificarTipo(tabela, fl), ctx.start, ctx.getText(), ret);
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
            ret = verificarIncompativel(verificarTipo(tabela, ea), ctx.start, ctx.getText(), ret);
        }

        return ret;
    }

    private static TipoLA verificarTipo(TabelaDeSimbolos tabela, LAParser.IdentificadorContext ctx) {
        TabelaDeSimbolos.TipoLA ret = null;
        for (var id : ctx.IDENT()) {
            ret = verificarIncompativel(verificarTipo(tabela, id.getText()), ctx.start, ctx.getText(), ret);
        }

        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, String nomeVar) {
        return tabela.verificar(nomeVar);
    }
}