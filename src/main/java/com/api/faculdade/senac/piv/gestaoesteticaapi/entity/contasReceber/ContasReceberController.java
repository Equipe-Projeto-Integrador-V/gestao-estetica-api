package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasReceber;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/contasreceber")
public class ContasReceberController {

    private final ContasReceberRepository contasReceberRepository;

    public ContasReceberController(ContasReceberRepository contasReceberRepository){
        this.contasReceberRepository = contasReceberRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContasReceber salvarContasReceber(@RequestBody ContasReceber contasReceber){
        return contasReceberRepository.save(contasReceber);
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
    public void updateContasReceber(@PathVariable Long id, @RequestBody ContasReceber contasReceber){
        contasReceberRepository.findById(id).map( contasReceberExiste -> {
            contasReceber.setId(contasReceberExiste.getId());
            contasReceberRepository.save(contasReceber);
            return contasReceberExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contas a Receber não encontrado"));
    }
}
