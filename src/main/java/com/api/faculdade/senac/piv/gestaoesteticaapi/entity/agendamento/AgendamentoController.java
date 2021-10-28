package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento;


import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento.dto.AgendamentoDTO;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente.Cliente;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.cliente.ClienteRepository;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.Funcionario;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.FuncionarioRepository;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico.Servico;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ServicoRepository servicoRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvarAgendamento(@RequestBody @Valid AgendamentoDTO dto){

        Agendamento agendamento = new Agendamento();

        agendamento.setData(dto.getData());
        agendamento.setHora(dto.getHora());
        agendamento.setObservacao(dto.getObservacao());
        Cliente cliente = clienteRepository
                          .findById(dto.getIdCliente())
                           .orElseThrow(
                                   () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));

        agendamento.setCliente(cliente);
        Funcionario funcionario = funcionarioRepository
                                   .findById(dto.getIdFuncionario())
                                              .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionario inexistente"));
        agendamento.setFuncionario(funcionario);
        Servico servico = servicoRepository
                                .findById(dto.getIdServico())
                                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Servico inexistente"));
        agendamento.setServico(servico);

        List<Agendamento> agendamentoConflito = agendamentoRepository.findAll();
        agendamentoConflito.forEach( a -> {
            if(a.getData().equals(agendamento.getData()) && a.getHora().equals(agendamento.getHora())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agendamento nessa data e horario já existe");
            }
        });
        return agendamentoRepository.save(agendamento);
    }

    @GetMapping("{id}")
    public Agendamento acharPorId(@PathVariable Long id){
        return agendamentoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAgendamento(@PathVariable Long id){
        agendamentoRepository.findById(id).map( agendamento -> {
            agendamentoRepository.delete(agendamento);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAgendamento(@PathVariable Long id, @RequestBody @Valid Agendamento agendamento){
        agendamentoRepository.findById(id).map( agendamentoExiste -> {
            agendamento.setId(agendamentoExiste.getId());
            agendamentoRepository.save(agendamento);
            return agendamentoExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontradop"));
    }

    @GetMapping("/listar")
    public List<Agendamento> listar(){
        return agendamentoRepository.findAll();
    }

    @GetMapping
    public List<Agendamento> pesquisar( @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
                                        @RequestParam(value = "mes", required = false) Integer mes){

        //Uma especie de coringa, caso não passe nome completo
        //where cliente.nome like '%ulano%'
        return agendamentoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }
}
