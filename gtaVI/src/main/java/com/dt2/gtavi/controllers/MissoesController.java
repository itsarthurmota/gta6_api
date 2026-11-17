package com.dt2.gtavi.controllers;

import com.dt2.gtavi.entities.Missoes;
import com.dt2.gtavi.repositories.MissoesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missoes")
public class MissoesController {

    private final MissoesRepository repository;

    public MissoesController(MissoesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Missoes> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Missoes buscarPorId(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Missoes criar(@RequestBody Missoes missao) {
        try {
            return repository.save(missao);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/{id}")
    public Missoes editar(@PathVariable int id, @RequestBody Missoes dadosAtualizados) {
        try {
            return repository.findById(id).map(missao -> {
                missao.setNome(dadosAtualizados.getNome());
                missao.setLocal(dadosAtualizados.getLocal());
                missao.setDificuldade(dadosAtualizados.getDificuldade());
                missao.setImagem(dadosAtualizados.getImagem());
                missao.setDescricao(dadosAtualizados.getDescricao());
                return repository.save(missao);
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