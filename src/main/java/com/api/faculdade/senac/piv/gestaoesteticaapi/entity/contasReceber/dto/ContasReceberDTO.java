package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasReceber.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ContasReceberDTO {

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate emissao;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate vencimento;
    private BigDecimal valor;
    private BigDecimal valorRecebido;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate recebimento;
    private String status;
    private Long cliente;
    private Long ordemServico;
}
