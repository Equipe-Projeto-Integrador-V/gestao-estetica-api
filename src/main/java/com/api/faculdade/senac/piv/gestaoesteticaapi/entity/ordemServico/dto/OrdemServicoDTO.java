package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class OrdemServicoDTO {

    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private String status;
    private BigDecimal valor;
    private Long agendamento;
    private Long funcionarioOs;
    private Long funcionarioExec;
}
