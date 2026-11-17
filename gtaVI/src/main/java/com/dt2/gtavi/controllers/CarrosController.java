package com.dt2.gtavi.controllers;

import com.dt2.gtavi.entities.Carros;
import com.dt2.gtavi.repositories.CarrosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class CarrosController {

    private final CarrosRepository repository;

    public CarrosController(CarrosRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Carros> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Carros buscarPorId(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Carros criar(@RequestBody Carros carro) {
        try {
            return repository.save(carro);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/{id}")
    public Carros editar(@PathVariable int id, @RequestBody Carros dadosAtualizados) {
        try {
            return repository.findById(id).map(carro -> {
                carro.setNome(dadosAtualizados.getNome());
                carro.setMarca(dadosAtualizados.getMarca());
                carro.setCategoria(dadosAtualizados.getCategoria());
                carro.setImagem(dadosAtualizados.getImagem());
                carro.setDescricao(dadosAtualizados.getDescricao());
                return repository.save(carro);
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