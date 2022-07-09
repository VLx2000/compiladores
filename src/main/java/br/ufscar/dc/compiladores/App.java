package br.ufscar.dc.compiladores;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class App {

    public static void main(String args[]) throws IOException {

        String entrada = args[0];
        String saida = args[1];

        CharStream cs = CharStreams.fromFileName(entrada);
        LALexer lex = new LALexer(cs);
/*
        try (PrintWriter pw = new PrintWriter(new FileWriter(saida))){
            Token t = null;
            boolean erro = false;   // variável para controle de execução
            int line;
            String regra, token;

            // O loop continuará até ler todo o arquivo ou até haver algum
            // erro: token não identificado, comentario ou cadeia não fechada
            /*while ((t = lex.nextToken()).getType() != Token.EOF && !erro) {
                // Obtendo linha atual
                line = t.getLine();
                // Obtendo token atual
                token = t.getText();
                // Obtendo tipo
                regra = LALexer.VOCABULARY.getDisplayName(t.getType());

                // Condição em que algum token não foi identificado
                if (regra.equals("SIMBOLO_DESCONHECIDO")){
                    pw.write("Linha " + line + ": " + token + " - simbolo nao identificado\n");
                    erro = true;
                }
                // Condição em que um comentário { } não foi fechado corretamente
                else if (regra.equals("COMENTARIO_N_FECHADO")){
                    pw.write("Linha " + line + ": comentario nao fechado\n");
                    erro = true;
                }
                // Condição em que uma cadeia " " não foi fechada corretamente
                else if (regra.equals("CADEIA_N_FECHADA")){
                    pw.write("Linha " + line + ": cadeia literal nao fechada\n");
                    erro = true;
                }
                // Se não for um dos casos acima será impresso o token com sua regra neste formato
                else {
                    pw.write("<\'" + token + "\'," + regra + ">\n");
                }
            }
            pw.close(); // Fechando arquivo escrito
        } catch (IOException ex) {
        }*/
        CommonTokenStream tokens = new CommonTokenStream(lex);
        LAParser parser = new LAParser(tokens);

        // Registrando o error lister personalizado
        MensagensCustomizadas msgs = new MensagensCustomizadas();
        parser.addErrorListener(msgs);

        parser.programa();
    }
}