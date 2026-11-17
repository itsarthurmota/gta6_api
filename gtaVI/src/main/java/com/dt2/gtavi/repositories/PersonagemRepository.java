package com.dt2.gtavi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dt2.gtavi.entities.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {
}
