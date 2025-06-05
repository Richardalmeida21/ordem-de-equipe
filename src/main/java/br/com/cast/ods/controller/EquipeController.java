package br.com.cast.ods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.ods.service.EquipeService;

@RestController
@RequestMapping("/api")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping("/ordem")
    public List<String> getOrdemAtual() {
        return equipeService.getOrdemAtual();
    }

    @PostMapping("/chamado")
    public String atribuirChamado() {
        return equipeService.atribuirChamado();
    }
}