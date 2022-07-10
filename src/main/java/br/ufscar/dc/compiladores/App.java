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

        try (PrintWriter pw = new PrintWriter(new FileWriter(saida))) {

            Token t = null;
            Integer line;
            String regra, token, erroLexico = "", resultado = "";

            // O loop continuará até ler todo o arquivo ou até haver algum
            // erro: token não identificado, comentario ou cadeia não fechada
            while ((t = lex.nextToken()).getType() != Token.EOF && erroLexico.isEmpty()) {
                // Obtendo linha atual
                line = t.getLine();
                // Obtendo token atual
                token = t.getText();
                // Obtendo tipo
                regra = LALexer.VOCABULARY.getDisplayName(t.getType());

                // Condição em que algum token não foi identificado
                if (regra.equals("SIMBOLO_DESCONHECIDO")) {
                    erroLexico = ("Linha " + line + ": " + token + " - simbolo nao identificado\n");
                    resultado += erroLexico;
                }
                // Condição em que um comentário { } não foi fechado corretamente
                else if (regra.equals("COMENTARIO_N_FECHADO")) {
                    erroLexico = ("Linha " + line + ": comentario nao fechado\n");
                    resultado += erroLexico;
                }
                // Condição em que uma cadeia " " não foi fechada corretamente
                else if (regra.equals("CADEIA_N_FECHADA")) {
                    erroLexico = ("Linha " + line + ": cadeia literal nao fechada\n");
                    resultado += erroLexico;
                }
                // Se não for um dos casos acima será impresso o token com sua regra neste
                // formato
                else {
                    resultado += ("<\'" + token + "\'," + regra + ">\n");
                }
            }
            if (erroLexico.isEmpty()) {
                // Resetando fluxo de tokens para a análise sintática
                lex.reset();
                
                CommonTokenStream tokens = new CommonTokenStream(lex);
                LAParser parser = new LAParser(tokens);

                // Registrando o error lister personalizado
                MensagensCustomizadas msgs = new MensagensCustomizadas(pw, false);
                //parser.removeErrorListeners();
                parser.addErrorListener(msgs);

                parser.programa();
            }
            
            if (!erroLexico.isEmpty()) {
                pw.write(erroLexico);
                pw.write("Fim da compilacao\n");
                pw.close(); // Fechando arquivo escrito
            }
        
            pw.write(resultado);
            pw.close(); // Fechando arquivo escrito
            
        } catch (IOException ex) {
        }
    }
}