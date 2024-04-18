package com.example.Store.repositorios;

import com.example.Store.modelos.TipoPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TipoPrendaRepositorio extends JpaRepository<TipoPrenda,Integer> {
}
