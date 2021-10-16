package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.fornecedor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController{

    private final FornecedorRepository fornecedorRepository;

    public FornecedorController(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }
}
