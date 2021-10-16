package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente.Cliente;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.Funcionario;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico.Servico;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
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
    private LocalDate data;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;
}
