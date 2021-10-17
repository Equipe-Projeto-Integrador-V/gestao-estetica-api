package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasPagar;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.fornecedor.Fornecedor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "contas_pagar")
@Getter@Setter
public class ContasPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_emissao")
    @NotEmpty(message = "{campo.data.emissao.obrigatorio}")
    private LocalDate emissao;

    @Column(name = "data_vencimento")
    @NotEmpty(message = "{campo.data.vencimento.obrigatorio}")
    private LocalDate vencimento;

    @Column(name = "valor")
    @NotEmpty(message = "{campo.valor.obrigatorio}")
    private Float valor;

    @Column(name = "valor_pago")
    private Float valorPago;

    @Column(name = "data_pagamento")
    private LocalDate pagamento;

    @Column(name = "status")  //criar uma anotação especifica para status: Aberto, Cancelado, Pago
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    @NotNull(message = "{campo.fornecedor.obrigatorio}")
    private Fornecedor fornecedor;

}
