package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.ordemServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {


    @Query(" select count (os.status) from OrdemServico os where os.status =:status")
    Integer totalStatusOrdemServico(String status);
}
