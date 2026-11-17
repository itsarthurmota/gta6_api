package com.dt2.gtavi.repositories;

import com.dt2.gtavi.entities.Carros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<Carros, Integer> {
}