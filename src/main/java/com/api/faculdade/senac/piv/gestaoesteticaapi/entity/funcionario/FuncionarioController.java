package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }
}
