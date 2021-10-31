package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasPagar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ContasPagarDTO {

    private LocalDate emissao;
    private LocalDate vencimento;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private LocalDate pagamento;
    private String status;
    private Long fornecedor;
}
