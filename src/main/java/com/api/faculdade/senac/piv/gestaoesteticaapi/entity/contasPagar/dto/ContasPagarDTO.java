package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasPagar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@NoArgsConstructor
public class ContasPagarDTO {

	@JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate emissao;
	@JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate vencimento;
    private BigDecimal valor;
    private BigDecimal valorPago;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate pagamento;
    private String status;
    private Long fornecedor;
}
