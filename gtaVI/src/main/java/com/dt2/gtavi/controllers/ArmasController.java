package com.dt2.gtavi.controllers;

import com.dt2.gtavi.entities.Armas;
import com.dt2.gtavi.repositories.ArmasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/armas")
public class ArmasController {

    private final ArmasRepository repository;

    public ArmasController(ArmasRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Armas> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Armas buscarPorId(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Armas criar(@RequestBody Armas arma) {
        try {
            return repository.save(arma);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/{id}")
    public Armas editar(@PathVariable int id, @RequestBody Armas dadosAtualizados) {
        try {
            return repository.findById(id).map(arma -> {
                arma.setNome(dadosAtualizados.getNome());
                arma.setCategoria(dadosAtualizados.getCategoria());
                arma.setFabricante(dadosAtualizados.getFabricante());
                arma.setImagem(dadosAtualizados.getImagem());
                arma.setDescricao(dadosAtualizados.getDescricao());
                return repository.save(arma);
            }).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}