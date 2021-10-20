package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoController(AgendamentoRepository agendamentoRepository){
        this.agendamentoRepository = agendamentoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvarAgendamento(@RequestBody @Valid Agendamento agendamento){
        List<Agendamento> agendamentoConflito = agendamentoRepository.findAll();
        agendamentoConflito.forEach( a -> {
            if(a.getData().equals(agendamento.getData()) && a.getHora().equals(agendamento.getHora())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agendamento nessa data e horario já existe");
            }
        });
        return agendamentoRepository.save(agendamento);
    }

    @GetMapping("{id}")
    public Agendamento acharPorId(@PathVariable Long id){
        return agendamentoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAgendamento(@PathVariable Long id){
        agendamentoRepository.findById(id).map( agendamento -> {
            agendamentoRepository.delete(agendamento);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAgendamento(@PathVariable Long id, @RequestBody @Valid Agendamento agendamento){
        agendamentoRepository.findById(id).map( agendamentoExiste -> {
            agendamento.setId(agendamentoExiste.getId());
            agendamentoRepository.save(agendamento);
            return agendamentoExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontradop"));
    }

    @GetMapping("/listar")
    public List<Agendamento> listar(){
        return agendamentoRepository.findAll();
    }
}
