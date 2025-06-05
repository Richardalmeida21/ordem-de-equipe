package br.com.cast.ods.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.ods.model.MembroEquipe;
import br.com.cast.ods.repository.MembroEquipeRepository;
import jakarta.annotation.PostConstruct;

@Service
public class EquipeService {
    
    @Autowired
    private MembroEquipeRepository repository;
    
    @PostConstruct
    public void inicializarEquipe() {
        if (repository.count() == 0) {
            // Inicializa a equipe apenas se o banco estiver vazio
            repository.save(new MembroEquipe("Richard", 1));
            repository.save(new MembroEquipe("Andre", 2));
            repository.save(new MembroEquipe("Mateus", 3));
            repository.save(new MembroEquipe("Leandro", 4));
        }
    }
    
    public List<String> getOrdemAtual() {
        return repository.findAllByOrderByPosicaoAsc()
                .stream()
                .map(MembroEquipe::getNome)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public String atribuirChamado() {
        // Busca todos os membros ordenados por posição
        List<MembroEquipe> membros = repository.findAllByOrderByPosicaoAsc();
        
        if (membros.isEmpty()) {
            return "Equipe vazia";
        }
        
        // Obtém o primeiro membro (que receberá o chamado)
        MembroEquipe primeiro = membros.get(0);
        String nome = primeiro.getNome();
        
        // Atualiza as posições
        int maxPosicao = membros.size();
        primeiro.setPosicao(maxPosicao + 1); // Move para o final
        repository.save(primeiro);
        
        // Ajusta as posições dos demais membros
        for (int i = 1; i < membros.size(); i++) {
            MembroEquipe membro = membros.get(i);
            membro.setPosicao(i);
            repository.save(membro);
        }
        
        return nome;
    }
}