package br.ufscar.dc.compiladores.t1;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class App {

    public static void main(String[] args) {

        String entrada = args[0];
        String saida = args[1];

        try (PrintWriter pw = new PrintWriter(new FileWriter(saida))){
            CharStream cs = CharStreams.fromFileName(entrada);
            t1Lexer lex = new t1Lexer(cs);
            Token t = null;
            boolean erro = false;
            int line;
            String Regra, token;
            while ((t = lex.nextToken()).getType() != Token.EOF && !erro) {
                line = t.getLine();
                token = t.getText();
                Regra = t1Lexer.VOCABULARY.getDisplayName(t.getType());
                if (Regra.equals("ERRO")){
                    pw.write("Linha " + line + ": " + token + " - simbolo nao identificado\n");
                    erro = true;
                }
                else if (Regra.equals("COMENTARIO_N_FECHADO")){
                    pw.write("Linha " + line + ": comentario nao fechado\n");
                    erro = true;
                }
                else if (Regra.equals("CADEIA_N_FECHADA")){
                    pw.write("Linha " + line + ": cadeia literal nao fechada\n");
                    erro = true;
                }
                else {
                    pw.write("<\'" + token + "\'," + Regra + ">\n");
                }
            }
            pw.close();
        } catch (IOException ex) {
        }
    }
}