package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico;

import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento.Agendamento;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento.AgendamentoRepository;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.Funcionario;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.FuncionarioRepository;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico.dto.OrdemServicoDTO;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico.Servico;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.servico.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordemservicos")
public class OrdemServicoController {

    private final OrdemServicoRepository ordemServicoRepository;
    private final AgendamentoRepository agendamentoRepository;
    private final FuncionarioRepository funcionarioRepository;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico salvarOrdemServico(@RequestBody @Valid OrdemServicoDTO dto){

        String FuncionarionotFound = "Funcionario não encontrado";

        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setDataInicio(dto.getDataInicio());
        ordemServico.setDataFinal(dto.getDataFinal());
        ordemServico.setHoraInicio(dto.getHoraInicio());
        ordemServico.setHoraFinal(dto.getHoraFinal());
        ordemServico.setStatus(dto.getStatus());
        ordemServico.setValor(dto.getValor());

        Agendamento agendamento = agendamentoRepository
                .findById(dto.getAgendamento())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
        ordemServico.setAgendamento(agendamento);


        Funcionario funcionarioOs = funcionarioRepository
                .findById(dto.getFuncionarioOs())
                .orElseThrow(
                        () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, FuncionarionotFound));
        ordemServico.setFuncionarioOs(funcionarioOs);

        Funcionario funcionarioExec = funcionarioRepository
                .findById(dto.getFuncionarioExec())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, FuncionarionotFound));
        ordemServico.setFuncionarioExec(funcionarioExec);


        return ordemServicoRepository.save(ordemServico);
    }

    @GetMapping("{id}")
    public OrdemServico acharPorId(@PathVariable Long id){
        return ordemServicoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Ordem de Serviço não encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarOrdemServico(@PathVariable Long id){
        ordemServicoRepository.findById(id).map( ordemServico -> {
            ordemServicoRepository.delete(ordemServico);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrdemServico(@PathVariable Long id, @RequestBody @Valid OrdemServico ordemServico){
        ordemServicoRepository.findById(id).map( ordemServicoExiste -> {
            ordemServico.setId(ordemServicoExiste.getId());
            ordemServicoRepository.save(ordemServico);
            return ordemServicoExiste;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrada"));
    }

}
