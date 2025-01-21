package com.new19.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long anioNacimiento;
    private Long anioFallecimiento;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    public Autor() {
    }

    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Long anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Long getAnioFallecimiento() {
        return anioFallecimiento;
    }

    public void setAnioFallecimiento(Long anioFallecimiento) {
        this.anioFallecimiento = anioFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return
                "\nnombre='" + nombre + '\'' +
                "\n, anioNacimiento=" + anioNacimiento +
                "\n, anioFallecimiento=" + anioFallecimiento;
    }
}
