package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasReceber;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente.Cliente;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente.ClienteRepository;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasReceber.dto.ContasReceberDTO;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico.OrdemServico;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico.OrdemServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contasreceber")
public class ContasReceberController {

    private final ContasReceberRepository contasReceberRepository;
    private final ClienteRepository clienteRepository;
    private final OrdemServicoRepository ordemServicoRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContasReceber salvarContasReceber(@RequestBody @Valid ContasReceberDTO dto){

        ContasReceber contasReceber = new ContasReceber();
        contasReceber.setEmissao(dto.getEmissao());
        contasReceber.setVencimento(dto.getVencimento());
        contasReceber.setValor(dto.getValor());
        contasReceber.setValorRecebido(dto.getValorRecebido());
        contasReceber.setRecebimento(dto.getRecebimento());
        contasReceber.setStatus(dto.getStatus());

        Cliente cliente = clienteRepository
                .findById(dto.getCliente())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        contasReceber.setCliente(cliente);

        OrdemServico ordemServico = ordemServicoRepository
                .findById(dto.getOrdemServico())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrado"));
        contasReceber.setOrdemServico(ordemServico);

        return contasReceberRepository.save(contasReceber);
    }
    
    @GetMapping
    public List<ContasReceber> getTodasContasReceber() {
    	return contasReceberRepository.findAll();
    }

    @GetMapping("{id}")
    public ContasReceber acharPorId(@PathVariable Long id){
        return contasReceberRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contas a Receber não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContasReceber(@PathVariable Long id){
        contasReceberRepository.findById(id).map( contasReceber -> {
            contasReceberRepository.delete(contasReceber);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contas a Receber não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateContasReceber(@PathVariable Long id, @RequestBody @Valid ContasReceber contasReceber){
        contasReceberRepository.findById(id).map( contasReceberExiste -> {
            contasReceber.setId(contasReceberExiste.getId());
            contasReceberRepository.save(contasReceber);
            return contasReceberExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contas a Receber não encontrado"));
    }
}
