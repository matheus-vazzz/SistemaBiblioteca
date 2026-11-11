package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
