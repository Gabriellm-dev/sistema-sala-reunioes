package com.br.saladereunioes.model;

import org.bson.types.ObjectId;

public class Sala {
    private ObjectId id;
    private String nome;
    private int capacidade;
    private String[] recursos;
    private String status;

    public Sala(String nome, int capacidade, String[] recursos, String status) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.recursos = recursos;
        this.status = status;
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

    public String[] getRecursos() {
        return recursos;
    }

    public void setRecursos(String[] recursos) {
        this.recursos = recursos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
