package com.api.faculdade.senac.piv.gestaoesteticaapi.enums;


import lombok.Getter;

@Getter
public enum StatusAgendamento {

    STATUS_AGENDAMENTO("ABERTO", "CANCELADO", "CONFIRMADO");


    private String aberto, cancelado, confirmado;

    StatusAgendamento(String aberto, String cancelado, String confirmado) {
        this.aberto = aberto;
        this.cancelado = cancelado;
        this.confirmado = confirmado;
    }

}

