package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente.Cliente;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.Funcionario;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamento")
@Getter@Setter
public class Agendamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    @NotNull(message = "{campo.data.agendamento.obrigatorio}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Column(name = "hora")
    @NotNull(message = "{campo.hora.agendamento.obrigatorio}")
    private LocalTime hora;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull(message = "{campo.cliente.obrigatorio}")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    @NotNull(message = "{campo.funcionario.obrigatorio}")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    @NotNull(message = "{campo.ordem.servico.obrigatorio}")
    private Servico servico;
}
