package com.algaworks.model;

// @author Marcelo Neves

public class Contato {
    private String id;
    private String nome;
    private String telefone;

    public Contato(){}

    public Contato(String id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public boolean isNovo(){
        return id == null;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
