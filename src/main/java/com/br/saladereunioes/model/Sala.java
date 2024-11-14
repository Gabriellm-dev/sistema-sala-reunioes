package com.br.saladereunioes.model;

import org.bson.types.ObjectId;

public class Sala {
    private ObjectId id;
    private String nome;
    private int capacidade;
    private boolean ativa;

    public Sala() {
    }

    public Sala(String nome, int capacidade, boolean ativa) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.ativa = ativa;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {
        return "Sala{id=" + id + ", nome='" + nome + "', capacidade=" + capacidade + ", ativa=" + ativa + '}';
    }
}
