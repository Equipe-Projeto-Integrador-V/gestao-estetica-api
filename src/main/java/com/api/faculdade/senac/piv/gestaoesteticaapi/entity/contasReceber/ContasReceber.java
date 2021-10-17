package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasReceber;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente.Cliente;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico.OrdemServico;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "contas_receber")
@Getter@Setter
public class ContasReceber {

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

    @Column(name = "valor_recebido")
    private Float valorRecebido;

    @Column(name = "data_recebimento")
    private LocalDate recebimento;

    @Column(name = "status") //criar uma anotação especifica para status: Aberto, Cancelado, Recebido
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull(message = "{campo.cliente.obrigatorio}")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_ordem_servico")
    @NotNull(message = "{campo.ordem.servico.obrigatorio}")
    private OrdemServico ordemServico;

}
