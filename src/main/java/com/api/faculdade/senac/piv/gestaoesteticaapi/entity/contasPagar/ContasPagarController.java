package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasPagar;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasPagar.dto.ContasPagarDTO;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.fornecedor.Fornecedor;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.fornecedor.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contaspagar")
public class ContasPagarController {

    private final ContasPagarRepository contasPagarRepository;
    private final FornecedorRepository fornecedorRepository;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContasPagar salvarContasPagar(@RequestBody @Valid ContasPagarDTO dto){

        ContasPagar contasPagar = new ContasPagar();
        contasPagar.setEmissao(dto.getEmissao());
        contasPagar.setVencimento(dto.getVencimento());
        contasPagar.setValor(dto.getValor());
        contasPagar.setValorPago(dto.getValorPago());
        contasPagar.setPagamento(dto.getPagamento());
        contasPagar.setStatus(dto.getStatus());

        Fornecedor fornecedor = fornecedorRepository
                .findById(dto.getFornecedor())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
        contasPagar.setFornecedor(fornecedor);

        return contasPagarRepository.save(contasPagar);
    }

    @GetMapping("{id}")
    public ContasPagar acharPorId(@PathVariable Long id){
        return contasPagarRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contas a Pagar Não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContasPagar(@PathVariable Long id){
        contasPagarRepository.findById(id).map( contasPagar -> {
            contasPagarRepository.delete(contasPagar);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contas a Pagar Não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void updateContasPagar(@PathVariable Long id, @RequestBody @Valid ContasPagar contasPagar){
        contasPagarRepository.findById(id).map( contasPagarExiste -> {
            contasPagar.setId(contasPagarExiste.getId());
            contasPagarRepository.save(contasPagar);
            return contasPagarExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contas a Pagar Não encontrado"));
    }
}
