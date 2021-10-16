package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ordemservicos")
public class OrdemServicoController {

    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoController(OrdemServicoRepository ordemServicoRepository){
        this.ordemServicoRepository = ordemServicoRepository;
    }
}
