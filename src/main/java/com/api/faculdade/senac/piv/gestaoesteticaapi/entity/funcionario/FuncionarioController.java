package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario;
import com.api.faculdade.senac.piv.gestaoesteticaapi.configs.errosapi.FuncionarioCadastroException;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.services.FuncionarioAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioAuthService funcionarioAuthService;


    @GetMapping
    public List<Funcionario> listarTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvarFuncionario(@RequestBody @Valid Funcionario funcionario){
        try{
            return funcionarioAuthService.salvarFuncionaro(funcionario);
        }catch (FuncionarioCadastroException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{id}")
    public Funcionario acharPorId(@PathVariable Long id){
        return funcionarioRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
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
