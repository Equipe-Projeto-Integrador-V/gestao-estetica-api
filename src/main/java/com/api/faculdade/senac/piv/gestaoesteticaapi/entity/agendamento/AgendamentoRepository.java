package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    //retorna uma lista de agendamentos com base no nome do cliente e mes escolhido
    //ex: Cliente : Fulano, Mes: 08 (agosto) -> retorna uma lista de agendamentos desse cliente no mês informado
    @Query(" select a from Agendamento a join a.cliente c where upper( c.nome ) like upper( :nome) and MONTH(a.data) =:mes  ")
    List<Agendamento> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);


    //retorna uma lista de agendamentos com base no nome do cliente e data
    //ex: Cliente : Fulano, Data: 20/02/2021 -> retorna uma lista de agendamentos desse cliente nesta data
    @Query(" select a from Agendamento a join a.cliente c where upper( c.nome) like upper(:nome) and a.data =:data ")
    List<Agendamento> findByNomeClienteAndDataCompleta(@Param("data") LocalDate data, @Param("nome") String nome);
}
