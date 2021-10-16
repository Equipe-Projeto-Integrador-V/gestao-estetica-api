package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoController(AgendamentoRepository agendamentoRepository){
        this.agendamentoRepository = agendamentoRepository;
    }
}
