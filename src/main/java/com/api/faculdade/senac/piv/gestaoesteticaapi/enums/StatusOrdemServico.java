package com.api.faculdade.senac.piv.gestaoesteticaapi.enums;


import lombok.Getter;

@Getter
public enum StatusOrdemServico {

    STATUS_ORDEM_SERVICO("ABERTO", "CANCELADO", "EM EXECUÇÃO", "CONCLUIDO");

    String aberto, cancelado, emExecucao, concluido;

    StatusOrdemServico(String aberto, String cancelado, String emExecucao, String concluido) {
        this.aberto = aberto;
        this.cancelado = cancelado;
        this.emExecucao = emExecucao;
        this.concluido = concluido;
    }
}
