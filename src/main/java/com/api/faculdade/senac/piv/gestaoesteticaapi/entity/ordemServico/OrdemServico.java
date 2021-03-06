package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento.Agendamento;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.Funcionario;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ordem_servico")
@Getter@Setter
public class  OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @Column(name = "data_final")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_final")
    private LocalTime horaFinal;

    @Column(name = "status")
    private String status;

    @Column(name = "valor")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_agendamento")
    @NotNull(message = "{campo.agendamento.obrigatorio}")
    private Agendamento agendamento;


    @ManyToOne
    @JoinColumn(name = "id_funcionario_os")   //funcionario responsavel por emitir a ordem de servico
    @NotNull(message = "{campo.agendamento.os.obrigatorio}")
    private Funcionario funcionarioOs;

    @ManyToOne
    @JoinColumn(name = "id_funcionario_ex")  //funcionario responsavel por executar o servico
    @NotNull(message = "{campo.agendamento.exec.obrigatorio}")
    private Funcionario funcionarioExec;
}
