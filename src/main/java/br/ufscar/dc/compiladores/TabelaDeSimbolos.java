package br.ufscar.dc.compiladores;

import java.util.HashMap;
import java.util.Map;

public class TabelaDeSimbolos {
    public enum TipoLA {
        INTEIRO,
        REAL,
        INVALIDO,
        LITERAL,
        LOGICO,
        REGISTRO

    }
    
    class EntradaTabelaDeSimbolos {
        String nome;
        TipoLA tipo;
        TabelaDeSimbolos tipo_registro;

        private EntradaTabelaDeSimbolos(String nome, TipoLA tipo) {
            this.nome = nome;
            this.tipo = tipo;
            this.tipo_registro  = null;
        }
        private EntradaTabelaDeSimbolos(String nome, TipoLA tipo,TabelaDeSimbolos tabela_registro){
            this.nome = nome;
            this.tipo = tipo;
            this.tipo_registro = tabela_registro;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, TipoLA tipo) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo));
    }
    
    public void adicionar_registro(String nome, TipoLA tipo, TabelaDeSimbolos tabela_registro){
        tabela.put(nome,new EntradaTabelaDeSimbolos(nome, tipo,tabela_registro));
    }

    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
    public TipoLA verificar(String nome) {
        return tabela.get(nome).tipo;
    }

    public TabelaDeSimbolos getTabelaRegistro(String nome){
        return tabela.get(nome).tipo_registro;
    }
}