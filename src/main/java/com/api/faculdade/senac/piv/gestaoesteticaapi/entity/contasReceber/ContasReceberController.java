package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasReceber;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contasreceber")
public class ContasReceberController {

    private final ContasReceberRepository contasReceberRepository;

    public ContasReceberController(ContasReceberRepository contasReceberRepository){
        this.contasReceberRepository = contasReceberRepository;
    }
}
