package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasPagar;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/contaspagar")
public class ContasPagarController {

    private final ContasPagarRepository contasPagarRepository;

    public ContasPagarController(ContasPagarRepository contasPagarRepository) {
        this.contasPagarRepository = contasPagarRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContasPagar salvarContasPagar(@RequestBody @Valid ContasPagar contasPagar){
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
