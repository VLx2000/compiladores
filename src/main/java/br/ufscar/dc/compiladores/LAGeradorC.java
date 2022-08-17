package br.ufscar.dc.compiladores;

import java.util.regex.Pattern;

import br.ufscar.dc.compiladores.LAParser.VariavelContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LAGeradorC extends LABaseVisitor<Void> {

    StringBuilder saida;
    TabelaDeSimbolos tabela;

    public LAGeradorC() {
        saida = new StringBuilder();
        this.tabela = new TabelaDeSimbolos();
    }

    String verificaTipoExpressao(TipoLA tipoExpressao){
        String aux = "";
        switch (tipoExpressao) {
            case INTEIRO:
                aux = "%d";
                break;
            case REAL:
                aux = "%f";
                break;
            case LITERAL:
                aux = "%s";
                break;
            default:
                break;
        }
        return aux;
    }

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        saida.append("\n");
        ctx.declaracoes().decl_local_global().forEach(dec -> visitDecl_local_global(dec));
        saida.append("\n");
        saida.append("int main() {\n");
        ctx.corpo().declaracao_local().forEach(dec -> visitDeclaracao_local(dec));
        ctx.corpo().cmd().forEach(cmd -> visitCmd(cmd));
        saida.append("\treturn 0;\n");
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {

        if (ctx.IDENT() != null && ctx.tipo_basico() != null && ctx.valor_constante() != null) {
            saida.append("#define " + ctx.IDENT().getText() + " " + ctx.valor_constante().getText());
        } else if (ctx.variavel() != null) {
            visitVariavel(ctx.variavel());
        }else if(ctx.tipo() != null) {
            if(ctx.tipo().registro() != null){
                saida.append("\ttypedef struct {\n");
                for(VariavelContext var : ctx.tipo().registro().variavel()){
                    visitVariavel(var);
                }
                saida.append("} " + ctx.IDENT().getText() + ";\n");
                
            }
            //System.out.println(ctx.IDENT() + " " + ctx.tipo().getText());
            //saida.append(ctx.IDENT() + " " + ctx.tipo().getText());
        }
        return null;
    }

    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx) {
        String strTipoVar = ctx.tipo().getText();
        if(ctx.tipo().registro() != null){
            saida.append("struct{\n");
            for(VariavelContext var : ctx.tipo().registro().variavel()){
                visitVariavel(var);
            }
            if(ctx.identificador().size() > 1){
                saida.append("} ");
                int i  = 0;
                for(i = 0; i<ctx.identificador().size()-1;i++){
                    saida.append(ctx.identificador().get(i).getText() + ", ");
                }
                saida.append(ctx.identificador().get(i).getText() + ";\n");
            }else{
                saida.append("} " + ctx.identificador().get(0).getText() + ";\n");
            }

        }else{
            TabelaDeSimbolos.TipoLA tipoVar = TabelaDeSimbolos.TipoLA.INVALIDO;
            // saida.append(strTipoVar + " " + nomeVar + ";\n");

            if(tabela.existe(strTipoVar)==true && tabela.verificar(strTipoVar)==TipoLA.REGISTRO){
                tipoVar = TipoLA.REGISTRO;
            }

            switch (strTipoVar) {
                case "inteiro":
                    tipoVar = TabelaDeSimbolos.TipoLA.INTEIRO;
                    strTipoVar = "int";
                    break;
                case "real":
                    tipoVar = TabelaDeSimbolos.TipoLA.REAL;
                    strTipoVar = "float";
                    break;
                case "^inteiro":
                    tipoVar = TabelaDeSimbolos.TipoLA.INTEIRO;
                    strTipoVar = "int*";
                    break;
                case "^real":
                    tipoVar = TabelaDeSimbolos.TipoLA.REAL;
                    strTipoVar = "float*";
                    break;
                case "literal":
                    tipoVar = TabelaDeSimbolos.TipoLA.LITERAL;
                    strTipoVar = "char";
                    break;
                default:
                    // Nunca irá acontecer, pois o analisador sintático
                    // não permite
                    break;
            }

            saida.append("\t" + strTipoVar + " ");
            for (int i = 0; i < ctx.identificador().size(); i++) {
                String nomeVar = ctx.identificador(i).IDENT(0).getText();
                System.out.println(nomeVar);
                // Podemos adicionar na tabela de símbolos sem verificar
                // pois a análise semântica já fez as verificações
                tabela.adicionar(nomeVar, tipoVar);
                if (strTipoVar.equals("char"))
                    saida.append(nomeVar + "[80]" /* + ctx.identificador(0).dimensao().toString() */);
                else
                    saida.append(nomeVar);
                if (i < ctx.identificador().size() - 1)
                    saida.append(", ");
                if (ctx.identificador(0).dimensao().exp_aritmetica() != null)
                    saida.append(ctx.identificador(0).dimensao().getText());
            }
            saida.append(";\n");

        }

        return null;
    }

    @Override
    public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {
        //System.out.println(ctx.getText());
        if (ctx.getText().contains("^")){
            saida.append("*");
        }
        if(ctx.expressao().getText().contains("\"")){
            System.out.println(ctx.identificador().getText());
            saida.append("\tstrcpy(" + ctx.identificador().getText() + ","+ ctx.expressao().getText()+");\n");
        }else{
            saida.append("\t" + ctx.identificador().getText() + " = ");
            visitExp_aritmetica(
                    ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
            saida.append(";\n");
        }

        return null;
    }

    @Override
    public Void visitCmdSe(LAParser.CmdSeContext ctx) {
        saida.append("\tif(");
        visitExp_relacional(ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional());
        saida.append("){\n\t");
        visitCmd(ctx.cmd(0));
        saida.append("\t}\n");
        if (ctx.cmd().size() > 1) { // tem else
            saida.append("\telse {\n\t");
            visitCmd(ctx.cmd(1));
            saida.append("\t}\n");
        }
        return null;
    }

    @Override
    public Void visitCmdLeia(LAParser.CmdLeiaContext ctx) {
        String nomeVar = ctx.identificador(0).IDENT(0).getText();
        TipoLA tipoVariavel = LASemanticoUtils.verificarTipo(tabela, nomeVar);
        String aux = "";
        switch (tipoVariavel) {
            case INTEIRO:
                aux = "%d";
                break;
            case REAL:
                aux = "%f";
                break;
            default:
                break;
        }
        if (aux.isEmpty())
            saida.append("\tgets(" + nomeVar + ");\n");
        else
            saida.append("\tscanf(\"" + aux + "\", &" + nomeVar + ");\n");
        return null;
    }

    @Override
    public Void visitCmdEnquanto(LAParser.CmdEnquantoContext ctx) {
        saida.append("\twhile(");
        visitExp_relacional(ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional());
        saida.append(") {\n");
        for (LAParser.CmdContext cmd : ctx.cmd()) {
            saida.append("\t");
            visitCmd(cmd);
        }
        saida.append("\t}\n");
        return null;
    }

    @Override
    public Void visitCmdFaca(LAParser.CmdFacaContext ctx) {
        saida.append("\tdo {\n\t");
        for (LAParser.CmdContext item : ctx.cmd()) {
            visitCmd(item);
        }
        saida.append("\t} while (");
        visitFator_logico(ctx.expressao().termo_logico(0).fator_logico(0));
        saida.append(");\n");
        return null;
    }

    @Override
    public Void visitCmdEscreva(LAParser.CmdEscrevaContext ctx) {

        ctx.expressao().forEach(exp -> {
            // System.out.println(exp.getText().startsWith("\""));
            if (exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0) != null) {

                TipoLA tipoExpressao = LASemanticoUtils.verificarTipo(tabela, exp);
                String aux = verificaTipoExpressao(tipoExpressao);


                saida.append("\tprintf(");
                if(exp.getText().contains(".")){
                    tipoExpressao = tabela.verificar(exp.getText().split(Pattern.quote("."))[1]);
                    aux = verificaTipoExpressao(tipoExpressao);
                }
                if (!exp.getText().startsWith("\"")) {
                    saida.append("\"" + aux + "\", ");
                    visitExp_aritmetica(
                            exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
                } else {
                    visitExp_aritmetica(
                            exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
                }
                saida.append(");\n");
            }
        });
        return null;
    }

    @Override
    public Void visitCmdCaso(LAParser.CmdCasoContext ctx) {

        saida.append("\tswitch ( ");
        visitExp_aritmetica(ctx.exp_aritmetica());
        saida.append(" ) {\n");
        for (LAParser.Item_selecaoContext item : ctx.selecao().item_selecao()) {
            visitItem_selecao(item);
        }
        saida.append("\tdefault:\n\t\tbreak;\n");
        saida.append("\t}\n");
        return null;
    }

    @Override
    public Void visitCmdPara(LAParser.CmdParaContext ctx) {

        saida.append("\tfor ( ");
        saida.append(ctx.IDENT() + "=");
        visitExp_aritmetica(ctx.exp_aritmetica(0));
        saida.append(";" + ctx.IDENT() + "<=");
        visitExp_aritmetica(ctx.exp_aritmetica(1));
        saida.append(";" + ctx.IDENT() + "++) {\n");
        for (LAParser.CmdContext item : ctx.cmd()) {
            visitCmd(item);
        }
        saida.append("\t}\n");
        return null;
    }

    @Override
    public Void visitItem_selecao(LAParser.Item_selecaoContext ctx) {

        Integer inicio = Integer.parseInt(ctx.constantes().numero_intervalo(0).NUM_INT(0).getText());
        if (ctx.constantes().numero_intervalo(0).NUM_INT(1) != null) {
            Integer fim = Integer.parseInt(ctx.constantes().numero_intervalo(0).NUM_INT(1).getText());
            for (int i = inicio; i <= fim; i++) {
                saida.append("\tcase ");
                saida.append(i);
                saida.append(":\n");
                for (LAParser.CmdContext cmd : ctx.cmd()) {
                    saida.append("\t");
                    visitCmd(cmd);
                    saida.append("\t\tbreak;\n");
                }
            }
        } else {
            saida.append("\tcase ");
            saida.append(ctx.constantes().numero_intervalo(0).NUM_INT(0).getText());
            saida.append(":\n");
            for (LAParser.CmdContext cmd : ctx.cmd()) {
                saida.append("\t");
                visitCmd(cmd);
                saida.append("\t\tbreak;\n");
            }
        }
        return null;
    }

    @Override
    public Void visitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx) {
        visitTermo(ctx.termo(0));
        for (int i = 0; i < ctx.op1().size(); i++) {
            saida.append(" " + ctx.op1(i).getText() + " ");
            visitTermo(ctx.termo(i + 1));
        }
        return null;
    }

    @Override
    public Void visitTermo(LAParser.TermoContext ctx) {
        visitFator(ctx.fator(0));
        for (int i = 0; i < ctx.op2().size(); i++) {
            saida.append(" " + ctx.op2(i).getText() + " ");
            visitFator(ctx.fator(i + 1));
        }
        return null;
    }

    @Override
    public Void visitFator(LAParser.FatorContext ctx) {
        visitParcela(ctx.parcela(0));
        for (int i = 0; i < ctx.op3().size(); i++) {
            saida.append(" " + ctx.op3(i).getText() + " ");
            visitParcela(ctx.parcela(i + 1));
        }
        return null;
    }

    @Override
    public Void visitFator_logico(LAParser.Fator_logicoContext ctx) {
        if ((ctx.getText().contains("nao"))) {
            saida.append("!(");
            visitExp_relacional(ctx.parcela_logica().exp_relacional());
            saida.append(")");
        }
        else {
            visitExp_relacional(ctx.parcela_logica().exp_relacional());
        }
        return null;
    }

    @Override
    public Void visitParcela(LAParser.ParcelaContext ctx) {
        //System.out.println(ctx.getText());
        if (ctx.parcela_nao_unario() != null) {
            visitParcela_nao_unario(ctx.parcela_nao_unario());
        }
        if (ctx.parcela_unario() != null) {
            visitParcela_unario(ctx.parcela_unario());
        }
        return null;
    }

    @Override
    public Void visitParcela_nao_unario(LAParser.Parcela_nao_unarioContext ctx) {
        if (ctx.CADEIA() != null) {
            String aux = ctx.CADEIA().getText();
            // aux = aux.substring(0, aux.length() - 1);
            saida.append(aux);
        } else if ((ctx.identificador() != null) ) {
            if (ctx.getText().contains("&")){
                saida.append("&");
            }
            saida.append(ctx.identificador().IDENT(0));
        }
        return null;
    }

    @Override
    public Void visitParcela_unario(LAParser.Parcela_unarioContext ctx) {
        if (ctx.NUM_INT() != null) {
            saida.append(ctx.NUM_INT().getText());
        } else if (ctx.NUM_REAL() != null) {
            saida.append(ctx.NUM_REAL().getText());
        } else if (ctx.identificador() != null) {
            if (ctx.identificador() != null) {
                saida.append(ctx.identificador().getText());
            }
        } else if ((ctx.expressao(0).termo_logico(0).fator_logico(0) != null)) {
                //System.out.println((ctx.parcela_unario().expressao(0).termo_logico(0).fator_logico(0).getText()));
                visitExp_relacional((ctx.expressao(0).termo_logico(0).fator_logico(0)
                        .parcela_logica().exp_relacional()));
        } else {
            saida.append("(");
            // visitExp_aritmetica(ctx.parcela_unario().expressao(0).termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
            saida.append(")");
        }
        return null;
    }

    @Override
    public Void visitExp_relacional(LAParser.Exp_relacionalContext ctx) {
        visitExp_aritmetica(ctx.exp_aritmetica(0));
        if (ctx.op_relacional() != null) {
            visitOp_relacional(ctx.op_relacional());
            visitExp_aritmetica(ctx.exp_aritmetica(1));
        }
        return null;
    }

    @Override
    public Void visitTipo_estendido(LAParser.Tipo_estendidoContext ctx) {
        if ((ctx.getText().contains("^"))) {
            saida.append("*");
        }
        return null;
    }

    @Override
    public Void visitOp_relacional(LAParser.Op_relacionalContext ctx) {
        String aux = "";
        switch (ctx.getText().toString()) {
            case "=":
                aux = "==";
                break;
            case "<>":
                aux = "!=";
                break;
            case ">=":
                aux = ">=";
                break;
            case "<=":
                aux = "<=";
                break;
            case ">":
                aux = ">";
                break;
            case "<":
                aux = "<";
                break;
            default:
                break;
        }
        saida.append(" " + aux + " ");
        return null;
    }
}