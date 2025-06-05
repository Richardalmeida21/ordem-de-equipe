package br.com.cast.ods;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class EquipeController {

    private final List<String> equipe = new LinkedList<>(
        List.of("Richard", "Andre", "Mateus", "Leandro")
    );

    @GetMapping("/ordem")
        public List<String> getOrdemAtual() {
            return equipe;
    }

    @PostMapping("/chamado")
    public String atribuirChamado() {
        String nome = equipe.remove(0);
        equipe.add(nome);
        return nome;
    }
    

}
