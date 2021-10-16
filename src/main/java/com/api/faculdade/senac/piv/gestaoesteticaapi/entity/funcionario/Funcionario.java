package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
@Getter@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "commisao")
    private Float comissao;
}
