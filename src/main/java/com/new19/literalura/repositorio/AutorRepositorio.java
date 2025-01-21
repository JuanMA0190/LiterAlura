package com.new19.literalura.repositorio;

import com.new19.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepositorio extends JpaRepository<Autor,Long> {
    @Query("SELECT a FROM Autor a")
    List<Autor> findALLAutores();

    @Query("SELECT a FROM Autor a WHERE a.anioFallecimiento IS NULL OR a.anioFallecimiento > :anio")
    List<Autor> findAutoresVivosEnAnio(@Param("anio") int anio);
}
