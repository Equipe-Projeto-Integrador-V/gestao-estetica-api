package com.api.faculdade.senac.piv.gestaoesteticaapi.enums;


import lombok.Getter;

@Getter
public enum StatusContasReceber {

    STATUS_CONTAS_RECEBERER("ABERTO", "CANCELADO", "RECEBIDO");

    String aberto, cancelado, recebido;

    StatusContasReceber(String aberto, String cancelado, String recebido) {
        this.aberto = aberto;
        this.cancelado = cancelado;
        this.recebido = recebido;
    }
}
