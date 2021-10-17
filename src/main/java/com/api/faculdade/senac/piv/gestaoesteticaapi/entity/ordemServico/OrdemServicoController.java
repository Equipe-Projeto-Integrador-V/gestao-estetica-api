package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ordemservicos")
public class OrdemServicoController {

    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoController(OrdemServicoRepository ordemServicoRepository){
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico salvarOrdemServico(@RequestBody @Valid OrdemServico ordemServico){
        return ordemServicoRepository.save(ordemServico);
    }

    @GetMapping("{id}")
    public OrdemServico acharPorId(@PathVariable Long id){
        return ordemServicoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Ordem de Serviço não encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarOrdemServico(@PathVariable Long id){
        ordemServicoRepository.findById(id).map( ordemServico -> {
            ordemServicoRepository.delete(ordemServico);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrdemServico(@PathVariable Long id, @RequestBody @Valid OrdemServico ordemServico){
        ordemServicoRepository.findById(id).map( ordemServicoExiste -> {
            ordemServico.setId(ordemServicoExiste.getId());
            ordemServicoRepository.save(ordemServico);
            return ordemServicoExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrada"));
    }

}
