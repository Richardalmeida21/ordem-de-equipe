package br.com.cast.ods.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "membros_equipe")
public class MembroEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private Integer posicao;
    
    // Construtores
    public MembroEquipe() {
    }
    
    public MembroEquipe(String nome, Integer posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getPosicao() {
        return posicao;
    }
    
    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
}