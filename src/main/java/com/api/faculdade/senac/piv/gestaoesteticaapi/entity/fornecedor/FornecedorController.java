package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.fornecedor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/fornecedores")
@CrossOrigin( origins = "http://localhost:4200")
public class FornecedorController{

    private final FornecedorRepository fornecedorRepository;

    public FornecedorController(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor salvarFornecedor(@RequestBody @Valid Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    @GetMapping("{id}")
    public Fornecedor acharPorId(@PathVariable Long id){
         return fornecedorRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFornecedor(@PathVariable Long id){
        fornecedorRepository.findById(id).map( fornecedor -> {
            fornecedorRepository.delete(fornecedor);
            return Void.TYPE;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFornecedor(@PathVariable Long id, @RequestBody @Valid Fornecedor fornecedor){
        fornecedorRepository.findById(id).map( fornecedorExiste -> {
            fornecedor.setId(fornecedorExiste.getId());
            fornecedorRepository.save(fornecedor);
            return fornecedorExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }


}
