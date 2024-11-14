package com.br.saladereunioes.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reserva {
    private String usuario;
    private Date dataInicio;
    private Date dataFim;
    private String salaId;

    @JsonCreator
    public Reserva(
        @JsonProperty("usuario") String usuario,
        @JsonProperty("dataInicio") Date dataInicio,
        @JsonProperty("dataFim") Date dataFim,
        @JsonProperty("salaId") String salaId
    ) {
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.salaId = salaId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getSalaId() {
        return salaId;
    }

    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }
}
