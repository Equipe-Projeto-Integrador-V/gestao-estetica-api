package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "servico")
@Getter@Setter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_custo")
    private Float precoCusto;

    @Column(name = "preco_venda")
    private Float precoVenda;
}
