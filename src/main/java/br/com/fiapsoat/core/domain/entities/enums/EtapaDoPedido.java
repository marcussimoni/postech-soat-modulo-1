package br.com.fiapsoat.core.domain.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EtapaDoPedido {
    RECEBIDO("Recebido"), EM_PREPARACAO("Em preparação"), PRONTO("Pronto"), FINALIZADO("Finalizado");

    private final String etapa;

    EtapaDoPedido(String etapa) {
        this.etapa = etapa;
    }

    @JsonValue
    public String getEtapa(){
        return this.etapa;
    }

}
