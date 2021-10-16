package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasPagar;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.fornecedor.Fornecedor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contas_pagar")
public class ContasPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_emissao")
    private LocalDate emissao;

    @Column(name = "data_vencimento")
    private LocalDate vencimento;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "valor_pago")
    private Float valorPago;

    @Column(name = "data_pagamento")
    private LocalDate pagamento;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

}
