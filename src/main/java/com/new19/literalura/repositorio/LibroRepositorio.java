package com.new19.literalura.repositorio;

import com.new19.literalura.model.Autor;
import com.new19.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepositorio extends JpaRepository<Libro,Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String nombreTitulo);

    @Query("SELECT l FROM Libro l")
    List<Libro> findALLLibros();

    @Query("SELECT l FROM Libro l WHERE l.idiomas = :idioma")
    List<Libro> findLibrosPorIdioma(@Param("idioma") String idioma);


}
