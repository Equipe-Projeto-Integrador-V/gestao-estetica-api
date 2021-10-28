package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class AgendamentoDTO {

    private LocalDate data;
    private LocalTime hora;
    private String observacao;
    private Long idCliente;
    private Long idFuncionario;
    private Long idServico;
}
