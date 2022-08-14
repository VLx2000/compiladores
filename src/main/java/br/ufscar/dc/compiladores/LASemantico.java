package br.ufscar.dc.compiladores;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.LAParser.CmdAtribuicaoContext;
import br.ufscar.dc.compiladores.LAParser.CmdContext;
import br.ufscar.dc.compiladores.LAParser.CmdLeiaContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LASemantico extends LABaseVisitor<Void> {

    static Escopos escoposAninhados = new Escopos();
    static HashMap<String, ArrayList<TipoLA>> funcoes = new HashMap<>(); 
    HashMap<String, ArrayList<String>> registros = new HashMap<>();
    HashMap<String, String> unarios = new HashMap<>();

    public void insereVarEscopoAtual(String nomeVar, String tipoVar, Token nomeToken, Token tipoToken) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        TabelaDeSimbolos escopoGlobal = escoposAninhados.obterEscopoGlobal();
        TipoLA tipo = verificaTipoBasico(tipoVar);

        if (tipo == TipoLA.INVALIDO) {
            LASemanticoUtils.adicionarErroSemantico(tipoToken, "tipo " + tipoVar + " nao declarado");
        }

        if (!escopoAtual.existe(nomeVar) && !escopoGlobal.existe(nomeVar)) {
            escopoAtual.adicionar(nomeVar, tipo);
        }
        else {
            LASemanticoUtils.adicionarErroSemantico(nomeToken, "identificador " + nomeVar + " ja declarado anteriormente");
        }

    }

    public String verificaDimensao(LAParser.IdentificadorContext ident) {
        String nomeVar;
        if (ident.dimensao().exp_aritmetica().size() > 0) {
            nomeVar = ident.IDENT(0).getText();
        } else {
            nomeVar = ident.getText();
        }
        return nomeVar;
    }
    
    public TipoLA verificaTipoBasico(String strTipoVar) {

        //System.out.println("TIPO BASICO\n");

        if (registros.containsKey(strTipoVar)) {
            return TipoLA.REGISTRO;
        }

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
                break;
            default:
                // Nunca irá acontecer, pois o analisador sintático
                // não permite
                break;
        }

        return tipoVar;
    }

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitCorpo(LAParser.CorpoContext ctx){
        escoposAninhados.criarNovoEscopo();
        for (LAParser.CmdContext cmd : ctx.cmd()) {
            if (cmd.cmdRetorne() != null) {
                LASemanticoUtils.adicionarErroSemantico(cmd.getStart(), "comando retorne nao permitido nesse escopo");
            }
        }
            
        return super.visitCorpo(ctx);
    }

    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        String strTipoVar = null;
        
        if (ctx.variavel() != null) {
            if (ctx.variavel().tipo().registro() != null) {
                for (LAParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                    insereVarEscopoAtual(ident.getText(), "registro", ident.getStart(), null);
                    for (LAParser.VariavelContext vars : ctx.variavel().tipo().registro().variavel()) {
                        strTipoVar = vars.tipo().getText();
                        for (LAParser.IdentificadorContext ident_reg : vars.identificador()) {
                            insereVarEscopoAtual(ident.getText() + '.' + ident_reg.getText(), strTipoVar, ident_reg.getStart(), vars.tipo().getStart());
                        }
                    }
                }
            } else {
                strTipoVar = ctx.variavel().tipo().getText();
                String nome;
                if (registros.containsKey(strTipoVar)) {
                    ArrayList<String> variaveis_registro = registros.get(strTipoVar);
                    for (LAParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        nome = verificaDimensao(ident);
                        if (escopoAtual.existe(nome) || registros.containsKey(nome)) {
                            LASemanticoUtils.adicionarErroSemantico(ident.getStart(), "identificador " + nome + " ja declarado anteriormente");
                        } else {
                            insereVarEscopoAtual(nome, "registro", ident.getStart(), ctx.variavel().tipo().getStart());
                            for (int i = 0; i < variaveis_registro.size(); i = i + 2) {
                                insereVarEscopoAtual(nome + '.' + variaveis_registro.get(i), variaveis_registro.get(i+1), ident.getStart(), ctx.variavel().tipo().getStart());
                            }
                        }
                    }
                } else if (unarios.containsKey(strTipoVar)) {
                    strTipoVar = unarios.get(strTipoVar);
                    for (LAParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        insereVarEscopoAtual(ident.getText(), strTipoVar, ident.getStart(), ctx.variavel().tipo().getStart());
                    }
                } else {
                    for (LAParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        String nomeVar = verificaDimensao(ident);
                        if (funcoes.containsKey(nomeVar)) {
                            LASemanticoUtils.adicionarErroSemantico(ident.getStart(), "identificador " + nomeVar + " ja declarado anteriormente");
                        } else {
                            insereVarEscopoAtual(nomeVar, strTipoVar, ident.getStart(), ctx.variavel().tipo().getStart());
                        }
                    }
                }
            }
        } else if (ctx.tipo_basico() != null) {
            strTipoVar = ctx.tipo_basico().getText();
            insereVarEscopoAtual(ctx.IDENT().getText(), strTipoVar, ctx.IDENT().getSymbol(), ctx.IDENT().getSymbol());
        } else {
            if (ctx.tipo().registro() != null) {
                ArrayList<String> variaveis_registro = new ArrayList<String>();
                for (LAParser.VariavelContext vars : ctx.tipo().registro().variavel()) {
                    strTipoVar = vars.tipo().getText();
                    for (LAParser.IdentificadorContext ident_registro : vars.identificador()) {
                        variaveis_registro.add(ident_registro.getText());
                        variaveis_registro.add(vars.tipo().getText());
                    }
                }
                registros.put(ctx.IDENT().getText(), variaveis_registro);
            } else {
                strTipoVar = ctx.tipo().getText();
                unarios.put(ctx.IDENT().getText(), strTipoVar);
            }
        }

        return super.visitDeclaracao_local(ctx);
    }


    
    @Override
    public Void visitCmd(CmdContext ctx){
        if(ctx.cmdAtribuicao()!= null){
            return visitCmdAtribuicao(ctx.cmdAtribuicao());
        }
        else if(ctx.cmdLeia()!= null){
            return visitCmdLeia(ctx.cmdLeia());
        }
        else if(ctx.cmdEscreva()!= null){
            return visitCmdEscreva(ctx.cmdEscreva());
        }
        else if(ctx.cmdSe()!= null){
            return visitCmdSe(ctx.cmdSe());
        }
        else if(ctx.cmdCaso()!= null){
            return visitCmdCaso(ctx.cmdCaso());
        }
        else if(ctx.cmdPara()!= null){
            return visitCmdPara(ctx.cmdPara());
        }
        else if(ctx.cmdEnquanto()!= null){
            return visitCmdEnquanto(ctx.cmdEnquanto());
        }
        else if(ctx.cmdFaca()!= null){
            return visitCmdFaca(ctx.cmdFaca());
        }
        else if(ctx.cmdChamada()!= null){
            return visitCmdChamada(ctx.cmdChamada());
        }
        else if (ctx.cmdRetorne() != null) {
            return visitCmdRetorne(ctx.cmdRetorne());
        }

        return null;
    }

    @Override
    public Void visitCmdAtribuicao(CmdAtribuicaoContext ctx){
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao = LASemanticoUtils.verificarTipo(escopoAtual, ctx.expressao());
        String strVar = verificaDimensao(ctx.identificador());

        if (tipoExpressao != TipoLA.INVALIDO) {
            if (!escopoAtual.existe(strVar)) {
                LASemanticoUtils.adicionarErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
            } else {
                TipoLA tipoVar = LASemanticoUtils.verificarTipo(escopoAtual, strVar);
                if (tipoVar != tipoExpressao) {
                    if ( !(((tipoVar == TipoLA.REAL) || (tipoVar == TipoLA.INTEIRO)) & ((tipoExpressao == TipoLA.INTEIRO) || (tipoExpressao == TipoLA.REAL))) ) {
                        if (ctx.ponteiro != null) {
                            LASemanticoUtils.adicionarErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para ^" + ctx.identificador().getText());
                        } else {
                            LASemanticoUtils.adicionarErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
                        }
                    }
                }
            }
        } else {
            LASemanticoUtils.adicionarErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
        }
        return super.visitCmdAtribuicao(ctx);
    }

    @Override
    public Void visitCmdLeia(CmdLeiaContext ctx){
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        String nomeVar;        
        for (LAParser.IdentificadorContext identificador : ctx.identificador()) {
            nomeVar = verificaDimensao(identificador);
            if (!escopoAtual.existe(nomeVar)) {
                LASemanticoUtils.adicionarErroSemantico(identificador.getStart(), "identificador " + identificador.getText() + " nao declarado");
            }
        }
        return super.visitCmdLeia(ctx);
    }

    @Override
    public Void visitCmdEscreva(LAParser.CmdEscrevaContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao;
        for (LAParser.ExpressaoContext expressao : ctx.expressao()) {
            tipoExpressao = LASemanticoUtils.verificarTipo(escopoAtual, expressao);
        }
        return super.visitCmdEscreva(ctx);
    }

    @Override
    public Void visitCmdSe(LAParser.CmdSeContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao = LASemanticoUtils.verificarTipo(escopoAtual, ctx.expressao());
        return super.visitCmdSe(ctx);
    }

    @Override
    public Void visitCmdEnquanto(LAParser.CmdEnquantoContext ctx) { 
        return super.visitCmdEnquanto(ctx);
    }

    @Override 
    public Void visitCmdCaso(LAParser.CmdCasoContext ctx) {
        ctx.cmd().forEach(cmd -> visitCmd(cmd));
        return super.visitCmdCaso(ctx);
    }

    @Override 
    public Void visitCmdPara(LAParser.CmdParaContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (!escopoAtual.existe(ctx.IDENT().getText())) {
            LASemanticoUtils.adicionarErroSemantico(ctx.IDENT().getSymbol(), "identificador " + ctx.IDENT().getText() + " nao declarado");
        }
        ctx.exp_aritmetica().forEach(expr_arit -> LASemanticoUtils.verificarTipo(escopoAtual, expr_arit));
        ctx.cmd().forEach(cmd -> visitCmd(cmd));
        return super.visitCmdPara(ctx);
    }
    
}