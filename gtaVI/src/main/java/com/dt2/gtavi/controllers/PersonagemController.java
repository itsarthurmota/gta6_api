package com.dt2.gtavi.controllers;

import com.dt2.gtavi.entities.Personagem;
import com.dt2.gtavi.repositories.PersonagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    private final PersonagemRepository repository;

    public PersonagemController(PersonagemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Personagem> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Personagem buscarPorId(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Personagem criar(@RequestBody Personagem rodrigo) {
        try {
            return repository.save(rodrigo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/{id}")
    public Personagem editar(@PathVariable int id, @RequestBody Personagem dadosAtualizados) {
        try {
            return repository.findById(id).map(personagem -> {
                personagem.setNome(dadosAtualizados.getNome());
                personagem.setApelido(dadosAtualizados.getApelido());
                personagem.setCategoria(dadosAtualizados.getCategoria());
                personagem.setImagem(dadosAtualizados.getImagem());
                personagem.setDescricao(dadosAtualizados.getDescricao());
                return repository.save(personagem);
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