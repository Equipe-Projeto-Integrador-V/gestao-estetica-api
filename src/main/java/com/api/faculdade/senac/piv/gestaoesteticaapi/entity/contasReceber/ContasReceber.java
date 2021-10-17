package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasReceber;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente.Cliente;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico.OrdemServico;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contas_receber")
@Getter@Setter
public class ContasReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_emissao")
    private LocalDate emissao;

    @Column(name = "data_vencimento")
    private LocalDate vencimento;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "valor_recebido")
    private Float valorRecebido;

    @Column(name = "data_recebimento")
    private LocalDate recebimento;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_ordem_servico")
    private OrdemServico ordemServico;

}
