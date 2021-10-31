package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class AgendamentoDTO {

    @NotNull(message = "{campo.data.agendamento.obrigatorio}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull(message = "{campo.hora.agendamento.obrigatorio}")
    private LocalTime hora;


    private String observacao;

    @NotNull(message = "{campo.cliente.obrigatorio}")
    private Long cliente;

    @NotNull(message = "{campo.funcionario.obrigatorio}")
    private Long funcionario;

    @NotNull(message = "{campo.ordem.servico.obrigatorio}")
    private Long servico;
}
