package br.ufscar.dc.compiladores;

import br.ufscar.dc.compiladores.LAParser.Decl_local_globalContext;
import br.ufscar.dc.compiladores.LAParser.Declaracao_globalContext;
import br.ufscar.dc.compiladores.LAParser.Declaracao_localContext;
import br.ufscar.dc.compiladores.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LASemantico extends LABaseVisitor<Void> {

    Escopos escoposAninhados = new Escopos();
    TabelaDeSimbolos tabela;

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracoes(LAParser.DeclaracoesContext ctx) {
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();

        for (Decl_local_globalContext d : ctx.decl_local_global()) {
            visitDecl_local_global(d);
        }
        return null; // declaração não tem valor

        // TipoLA tipoExpressao = LASemanticoUtils.verificarTipo(tabela,
        // ctx.decl_local_global());

        // String nomeVar = ctx.
        // String strTipoVar = ctx.decl_local_global().size()
        // TipoLA tipoVar = TipoLA.INVALIDO;
        // switch (strTipoVar) {
        // case "INTEIRO":
        // tipoVar = TipoLA.INTEIRO;
        // break;
        // case "REAL":
        // tipoVar = TipoLA.REAL;
        // break;
        // default:
        // // Nunca irá acontecer, pois o analisador sintático
        // // não permite
        // break;
        // }

        // // Verificar se a variável já foi declarada
        // if (tabela.existe(nomeVar)) {
        // LASemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Variável
        // " + nomeVar + " já existe");
        // } else {
        // tabela.adicionar(nomeVar, tipoVar);
        // }
        // return super.visitDeclaracoes(ctx);
    }

    @Override
    public Void visitDecl_local_global(LAParser.Decl_local_globalContext ctx) {

        visitDeclaracao_local(ctx.declaracao_local());
        return null;
    }

    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        if (ctx.variavel() != null) {
            return visitVariavel(ctx.variavel());
        }if(ctx.tipo_basico()!=null){
            TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
            String nomeVar = ctx.IDENT().getText();
            TipoLA tipoVar = verificaTipoBasico(ctx.tipo_basico());
            if (escopoAtual.verificar(nomeVar) != null) {
                LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), nomeVar
                        + " declarada duas vezes num mesmo escopo");
            } else {
                escopoAtual.adicionar(nomeVar, tipoVar);
            }
        

        } else if (ctx.tipo() != null){
            visitTipo(ctx.tipo());
        }
        return null;
    }

    public TipoLA verificaTipoBasico(LAParser.Tipo_basicoContext ctx){
        String strTipoVar = ctx.getText();
            
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
            case "logico":
                tipoVar = TipoLA.LOGICO;
            default:
                // Nunca irá acontecer, pois o analisador sintático
                // não permite
                break;
        }
        if(tipoVar == TipoLA.INVALIDO){
            LASemanticoUtils.adicionarErroSemantico(ctx.getStart(),"tipo "+ strTipoVar
                        + " nao declarado");
        }
        return tipoVar;
    }

    @Override
    public Void visitTipo(LAParser.TipoContext ctx){
        if(ctx.registro()!=null){
            visitRegistro(ctx.registro());
        } else if (ctx.tipo_estendido() != null) {
            visitTipo_estendido(ctx.tipo_estendido());
        }
        return null;
    }

    @Override
    public Void visitRegistro(LAParser.RegistroContext ctx){
        for(LAParser.VariavelContext variavel : ctx.variavel()){
            visitVariavel(variavel);
        }
        return null;
    }
    
    @Override
    public Void visitTipo_estendido(LAParser.Tipo_estendidoContext ctx){
        return null;
    }


    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx) {
        String nomeVar;
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        String strTipoVar = ctx.tipo().getText();
        TabelaDeSimbolos.TipoLA tipoVar = TipoLA.INVALIDO;
        switch (strTipoVar) {
            case "inteiro":
                tipoVar = TipoLA.INTEIRO;
                break;
            case "real":
                tipoVar = TipoLA.REAL;
                break;
            case "literal":
                tipoVar = TipoLA.LITERAL;
            case "logico":
                tipoVar = TipoLA.LOGICO;
            default:
                // Nunca irá acontecer, pois o analisador sintático
                // não permite
                break;
        }
        for (LAParser.IdentificadorContext id : ctx.identificador()) {
            nomeVar = retornaIdentificador(id);
            if (escopoAtual.verificar(nomeVar) != null) {
                LASemanticoUtils.adicionarErroSemantico(id.getStart(), nomeVar
                        + " declarada duas vezes num mesmo escopo");
            } else {
                escopoAtual.adicionar(nomeVar, tipoVar);
            }
        }
        return null;
    }

    // Vcs tão tentando pegar coisas tipo INT, REAL, etc? tamo tentando remover o
    // erro

    @Override
    public Void visitCmd(LAParser.CmdContext ctx) {

        if (ctx.cmdLeia() != null) {
            return visitCmdLeia(ctx.cmdLeia());
        } else if (ctx.cmdEscreva() != null) {
            return visitCmdEscreva(ctx.cmdEscreva());
        } else if (ctx.cmdSe() != null) {
            return visitCmdSe(ctx.cmdSe());
        } else if (ctx.cmdCaso() != null) {
            return visitCmdCaso(ctx.cmdCaso());
        } else if (ctx.cmdPara() != null) {
            return visitCmdPara(ctx.cmdPara());
        } else if (ctx.cmdEnquanto() != null) {
            return visitCmdEnquanto(ctx.cmdEnquanto());
        } else if (ctx.cmdFaca() != null) {
            return visitCmdPara(ctx.cmdPara());
        } else if (ctx.cmdAtribuicao() != null) {
            return visitCmdAtribuicao(ctx.cmdAtribuicao());
        } else if (ctx.cmdChamada() != null) {
            return visitCmdChamada(ctx.cmdChamada());
        } else if (ctx.cmdRetorne() != null) {
            return visitCmdRetorne(ctx.cmdRetorne());
        }

        return null;
    }

    public String retornaIdentificador(LAParser.IdentificadorContext identificador) {
        String nomeVar = identificador.getText();
        return nomeVar;
    }
    /*
     * //comentei so pra testar ok
     * 
     * @Override
     * public Void visitCmdLeia(LAParser.CmdLeiaContext ctx) {
     * TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
     * String nomeVar;
     * 
     * for (LAParser.IdentificadorContext identificador : ctx.identificador()) {
     * nomeVar = retornaIdentificador(identificador);
     * if (!tabela.existe(nomeVar)) {
     * LASemanticoUtils.adicionarErroSemantico(identificador.getStart(),
     * "identificador" + identificador.getText() + " nao declarado");
     * }
     * }
     * 
     * return super.visitCmdLeia(ctx);
     * }
     * 
     * @Override
     * public Void visitCmdEscreva(LAParser.CmdEscrevaContext ctx) {
     * TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
     * 
     * for (LAParser.ExpressaoContext expressao : ctx.expressao()) {
     * 
     * }
     * return super.visitCmdEscreva(ctx);
     * }
     * 
     * @Override
     * public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {
     * TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
     * TipoLA tipoExpressao = LASemanticoUtils.verificarTipo(tabela,
     * ctx.expressao());
     * 
     * if (tipoExpressao != TipoLA.INVALIDO) {
     * String nomeVar = ctx.VARIAVEL().getText();
     * if (!tabela.existe(nomeVar)) {
     * LASemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(),
     * "Variável " + nomeVar + " não foi declarada antes do uso");
     * } else {
     * TipoLA tipoVariavel = LASemanticoUtils.verificarTipo(tabela, nomeVar);
     * if (tipoVariavel != tipoExpressao) {
     * LASemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(),
     * "Tipo da variável " + nomeVar + " não é compatível com o tipo da expressão");
     * }
     * }
     * }
     * return super.visitCmdAtribuicao(ctx);
     * }
     * 
     * 
     * @Override
     * public Void visitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx) {
     * LASemanticoUtils.verificarTipo(tabela, ctx);
     * return super.visitExp_aritmetica(ctx);
     * }
     */
}
