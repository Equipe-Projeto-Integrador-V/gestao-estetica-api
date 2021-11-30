package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByLogin(String login);

    // select count(*) > 0 from funcionario where login = :login
    boolean existsByLogin(String login);
}
