package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin( origins = "http://localhost:4200")
public class ServicoController {

    private final ServicoRepository servicoRepository;

    public ServicoController(ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }

    @PostMapping
    public Servico salvarServico(@RequestBody @Valid Servico servico){
        return servicoRepository.save(servico);
    }

    @GetMapping
    public List<Servico> listarTodosServicos(){
        return servicoRepository.findAll();
    }

    @GetMapping("{id}")
    public Servico acharPorId(@PathVariable Long id){
        return servicoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servico não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarServico(@PathVariable Long id){
        servicoRepository.findById(id).map( servico -> {
            servicoRepository.delete(servico);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateServico(@PathVariable Long id, @RequestBody @Valid Servico servico){
        servicoRepository.findById(id).map( servicoExiste -> {
            servico.setId(servicoExiste.getId());
            servicoRepository.save(servico);
            return servicoExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));
    }
}
