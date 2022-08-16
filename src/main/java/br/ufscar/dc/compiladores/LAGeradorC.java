package br.ufscar.dc.compiladores;

import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoLA;

public class LAGeradorC extends LABaseVisitor<Void> {

    StringBuilder saida;
    TabelaDeSimbolos tabela;

    public LAGeradorC() {
        saida = new StringBuilder();
        this.tabela = new TabelaDeSimbolos();
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
        }
        else if (ctx.variavel() != null) {
            visitVariavel(ctx.variavel());
        }
        return null;
    }

    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx) {
        String strTipoVar = ctx.tipo().getText();
        TabelaDeSimbolos.TipoLA tipoVar = TabelaDeSimbolos.TipoLA.INVALIDO;
        //saida.append(strTipoVar + " " + nomeVar + ";\n");
        switch (strTipoVar) {
            case "inteiro":
                tipoVar = TabelaDeSimbolos.TipoLA.INTEIRO;
                strTipoVar = "int";
                break;
            case "real":
                tipoVar = TabelaDeSimbolos.TipoLA.REAL;
                strTipoVar = "float";
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
            String nomeVar = ctx.identificador(i).IDENT(0).toString();
            
            // Podemos adicionar na tabela de símbolos sem verificar
            // pois a análise semântica já fez as verificações
            tabela.adicionar(nomeVar, tipoVar);
            if (strTipoVar.equals("char"))
                saida.append(nomeVar + "[80]" /*+ ctx.identificador(0).dimensao().toString()*/);
            else
                saida.append(nomeVar);
            if (i < ctx.identificador().size() - 1)
                saida.append(", ");
        }
        saida.append(";\n");
        return null;
    }

    @Override
    public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {
        saida.append("\t" + ctx.identificador().IDENT(0).getText() + " = ");
        visitExp_aritmetica(ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
        saida.append(";\n");
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
        saida.append(" {\n\t");
        visitExp_relacional(ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional());
        saida.append(")\n");
        visitCmd(ctx.cmd(0));
        return null;
    }

    @Override
    public Void visitCmdEscreva(LAParser.CmdEscrevaContext ctx) {
        
        ctx.expressao().forEach(exp -> { 
            //System.out.println(exp.getText().startsWith("\""));
            if (exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0) != null) {
            
                TipoLA tipoExpressao = LASemanticoUtils.verificarTipo(tabela, exp);
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
                saida.append("\tprintf(");
                if (!exp.getText().startsWith("\"")){
                    saida.append("\"" + aux + "\", ");
                    visitExp_aritmetica(exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
                }
                else{
                    visitExp_aritmetica(exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
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
        if (ctx.constantes().numero_intervalo(0).NUM_INT(1) != null){
            Integer fim = Integer.parseInt(ctx.constantes().numero_intervalo(0).NUM_INT(1).getText());
            for (int i = inicio; i <= fim; i++){
                saida.append("\tcase ");
                saida.append(i);
                saida.append(":\n");
                for (LAParser.CmdContext cmd : ctx.cmd()) {
                    saida.append("\t");
                    visitCmd(cmd);
                    saida.append("\t\tbreak;\n");
                }
            }
        }
        else {
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
    public Void visitParcela(LAParser.ParcelaContext ctx) {
        if (ctx.parcela_nao_unario() != null){
            String aux = ctx.parcela_nao_unario().CADEIA().getText();
            //aux = aux.substring(0, aux.length() - 1);
            saida.append(aux);
        }
        if (ctx.parcela_unario() != null){
            if (ctx.parcela_unario().NUM_INT() != null) {
                saida.append(ctx.parcela_unario().NUM_INT().getText());
            } else if (ctx.parcela_unario().NUM_REAL() != null) {
                saida.append(ctx.parcela_unario().NUM_REAL().getText());
            } else if (ctx.parcela_unario().identificador().IDENT(0) != null) {
                saida.append(ctx.parcela_unario().identificador().IDENT(0).getText());
            } else {
                saida.append("(");
                //visitExp_aritmetica(ctx.parcela_unario().expressao(0).termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
                saida.append(")");
            }
        }
        return null;
    }

    @Override
    public Void visitExp_relacional(LAParser.Exp_relacionalContext ctx) {
        visitExp_aritmetica(ctx.exp_aritmetica(0));
        if (ctx.op_relacional() != null){
            visitOp_relacional(ctx.op_relacional());
            visitExp_aritmetica(ctx.exp_aritmetica(1));
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