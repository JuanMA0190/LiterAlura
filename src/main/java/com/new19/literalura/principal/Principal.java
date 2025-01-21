package com.new19.literalura.principal;

import com.new19.literalura.model.Autor;
import com.new19.literalura.model.DatosLibros;
import com.new19.literalura.model.DatosLiterarios;
import com.new19.literalura.model.Libro;
import com.new19.literalura.repositorio.AutorRepositorio;
import com.new19.literalura.repositorio.LibroRepositorio;
import com.new19.literalura.service.ConsumoAPI;
import com.new19.literalura.service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibroRepositorio repositorio;
    private AutorRepositorio repositorioAutor;

    public Principal(LibroRepositorio repository, AutorRepositorio autorRepositorio) {
        this.repositorio = repository;
        this.repositorioAutor = autorRepositorio;
    }

    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    --------------------------------------
                    Elija la opción a través de su número:
                    1 - Buscar libro por título 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - listar libros por idioma
                    
                    0 - Salir
                    --------------------------------------
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    listarLibroRegistrado();
                    break;
                case 3:
                    listarAutoresRegistrado();
                    break;
                case 4:
                    listarAutoresVivosEnAnio();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }
    }

    private DatosLibros getDatosLibros() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE +"?search="+nombreLibro.replace(" ","+") );

        var datos = conversor.obtenerDatos(json, DatosLiterarios.class);
        Optional<DatosLibros> libroBuscado = datos.datosLibros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();

        // Manejar el resultado: mensaje si no se encuentra
        if (libroBuscado.isEmpty()) {
            System.out.println("Libro no encontrado. Por favor, intente con otro título.");
        }

        if(repositorio.findByTituloContainsIgnoreCase(nombreLibro).isPresent()){
            System.out.println("Libro ya registrado");
            libroBuscado = Optional.empty();
        }

        return libroBuscado.orElse(null);
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingese el idioma: ");
        var idioma = teclado.nextLine();
        List<Libro> libros = repositorio.findLibrosPorIdioma(idioma);
        libros.forEach(System.out::println);
    }

    private void listarAutoresVivosEnAnio() {
        System.out.println("Ingrese el año: ");
        var anio = teclado.nextInt();
        teclado.nextLine();
        List<Autor> autores = repositorioAutor.findAutoresVivosEnAnio(anio);
        autores.forEach(System.out::println);
    }

    private void listarAutoresRegistrado() {
        System.out.println("lista de Autores:");
        List<Autor> autores = repositorioAutor.findALLAutores();
        autores.forEach(System.out::println);
    }

    private void listarLibroRegistrado() {
        System.out.println("lista de libros:");
        List<Libro> libros = repositorio.findALLLibros();
        libros.forEach(System.out::println);
    }

    private void buscarLibro() {

        DatosLibros datos = getDatosLibros();
        if (datos == null) {
            System.out.println("No se encontro el libro o libro ya registrado");
            return;
        }
        Libro libro = new Libro(datos);
        System.out.println(libro);
        repositorio.save(libro);

    }


      /*
    *         var json = consumoApi.obtenerDatos(URL_BASE);
        var datos = conversor.obtenerDatos(json, DatosLiterarios.class);
        System.out.println(datos);
        *
        *
        *
        *
        *
        * URLBASE + ?search = {titulo}
    * */

}