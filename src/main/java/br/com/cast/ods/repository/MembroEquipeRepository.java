package br.com.cast.ods.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cast.ods.model.MembroEquipe;

@Repository
public interface MembroEquipeRepository extends JpaRepository<MembroEquipe, Long> {
    
    List<MembroEquipe> findAllByOrderByPosicaoAsc();
    
    MembroEquipe findFirstByOrderByPosicaoAsc();
}