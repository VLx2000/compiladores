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
            int erro = 0,line = 0;
            String Regra ="",token ="";
            while ((t = lex.nextToken()).getType() != Token.EOF && erro != 1) {
                line = lex.getLine();
                Regra =  t1Lexer.VOCABULARY.getDisplayName(t.getType());
                if(!Regra.equals("ERRO")){
                    pw.write("<" + "\'" + t.getText()  + "\'" + "," + Regra + ">\n");
                }else{
                    token = t.getText();
                    erro = 1;
                }
                
            }
            if(erro == 1){
                pw.write("Linha "+ line + ": " +token+ " - simbolo nao identificado\n");
            }
            pw.close();
        } catch (IOException ex) {
        }
    }
}