package com.new19.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

    private List<String> idiomas;
    private Long numeroDescargas;


    public Libro() {
    }

    public Libro(DatosLibros d) {
        this.titulo = d.titulo();
        this.idiomas = d.idiomas();
        this.numeroDescargas = d.numeroDescargas();
        this.autores = convertirDatosAutorAAutor(d.datosAutorList());

    }

    private List<Autor> convertirDatosAutorAAutor(List<DatosAutor> datosAutorList) {
        List<Autor> autores = new ArrayList<>();
        for (DatosAutor datosAutor : datosAutorList) {
            Autor autor = new Autor();
            autor.setNombre(datosAutor.nombre());
            autor.setAnioNacimiento(datosAutor.anioNacimiento());
            autor.setAnioFallecimiento(datosAutor.anioFallecimiento());
            autores.add(autor);
        }
        return autores;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Long getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Long numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return  "\nTitulo='" + titulo + '\'' +
                "\n, numeroDescargas=" + numeroDescargas +
                "\n, idiomas=" + idiomas +
                "\n, id=" + id;
    }
}
