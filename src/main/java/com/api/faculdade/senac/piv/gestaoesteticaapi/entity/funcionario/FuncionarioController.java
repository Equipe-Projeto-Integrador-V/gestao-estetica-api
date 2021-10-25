package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin( origins = "http://localhost:4200")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvarFuncionario(@RequestBody @Valid Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("{id}")
    public Funcionario acharPorId(@PathVariable Long id){
        return funcionarioRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFuncionario(@PathVariable Long id){
        funcionarioRepository.findById(id).map( funcionario -> {
            funcionarioRepository.delete(funcionario);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFuncionario(@PathVariable  Long id, @RequestBody @Valid Funcionario funcionario){
        funcionarioRepository.findById(id).map( funcionarioExiste -> {
            funcionario.setId(funcionarioExiste.getId());
            funcionarioRepository.save(funcionario);
            return funcionarioExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
    }
}
