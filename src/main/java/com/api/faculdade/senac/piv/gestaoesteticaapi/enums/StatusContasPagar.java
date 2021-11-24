package com.api.faculdade.senac.piv.gestaoesteticaapi.enums;

import lombok.Getter;

@Getter
public enum StatusContasPagar {

    STATUS_CONTAS_PAGARTASPAGAR("ABERTO", "CANCELADO", "PAGO");

    String aberto, cancelado, pago;

    StatusContasPagar(String aberto, String cancelado, String pago) {
        this.aberto = aberto;
        this.cancelado = cancelado;
        this.pago = pago;
    }
}
