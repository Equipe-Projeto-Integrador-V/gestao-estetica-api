package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasReceber.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ContasReceberDTO {

    private LocalDate emissao;
    private LocalDate vencimento;
    private BigDecimal valor;
    private BigDecimal valorRecebido;
    private LocalDate recebimento;
    private String status;
    private Long cliente;
    private Long ordemServico;
}
