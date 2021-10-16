package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.contasPagar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contaspagar")
public class ContasPagarController {

    private final ContasPagarRepository contasPagarRepository;

    public ContasPagarController(ContasPagarRepository contasPagarRepository) {
        this.contasPagarRepository = contasPagarRepository;
    }
}
