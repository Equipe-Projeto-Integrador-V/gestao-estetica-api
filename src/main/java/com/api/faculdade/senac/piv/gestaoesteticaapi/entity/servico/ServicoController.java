package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoRepository servicoRepository;

    public ServicoController(ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }
}
