package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "servico")
@Getter@Setter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @Column(name = "preco_custo")
    @NotNull(message = "{campo.preco.custo.obrigatorio}")
    private Float precoCusto;

    @Column(name = "preco_venda")
    @NotNull(message = "{campo.preco.venda.obrigatorio}")
    private Float precoVenda;
}
