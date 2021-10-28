package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin( origins = "http://localhost:4200")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }


    @GetMapping
    public List<Cliente> obterTodosClientes(){
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody @Valid Cliente cliente){
        List<Cliente> todosClientesSalvos = clienteRepository.findAll();
        todosClientesSalvos.forEach( c -> {
            if(c.getCpf().equalsIgnoreCase(cliente.getCpf())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já Existe um Cliente com o mesmo CPF");
            }
        });

        return clienteRepository.save(cliente);
    }


    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Long id){

        return clienteRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente (@PathVariable Long id){
        clienteRepository.findById(id).map( cliente -> {
            clienteRepository.delete(cliente);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @Valid Cliente cliente){

        clienteRepository.findById(id).map( clienteExiste -> {
            cliente.setId( clienteExiste.getId());
            clienteRepository.save(cliente);
            return clienteExiste;
        }).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado" )
        );
    }
}
