package com.aluracursos.LibreriaAluraChallenge.principal;

import com.aluracursos.LibreriaAluraChallenge.model.Categoria;
import com.aluracursos.LibreriaAluraChallenge.model.DatosLibro;
import com.aluracursos.LibreriaAluraChallenge.model.Libros;
import com.aluracursos.LibreriaAluraChallenge.repository.LibrosRepository;
import com.aluracursos.LibreriaAluraChallenge.service.ConsumoAPI;
import com.aluracursos.LibreriaAluraChallenge.service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final LibrosRepository repositorio;
    private ConvierteDatos conversor = new ConvierteDatos();

    //DECLARACIÓN DE VARIABLES
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";

    //LLAMAR
    public Principal(LibrosRepository repository){
        this.repositorio = repository;
    }
    //DECLARACIÓN DEL MENÚ
    public void muestraMenu(){
        var opcion = -1;
        System.out.println(" ");
        System.out.println("----------------------------------------");
        System.out.println("*** BIENVENIDO A LA LIBRERIA ALURA ***");
        System.out.println("-----------------------------------------");

        while (opcion != 0){
            var menu = """
                    ------------ RECOMENDACIONES ------------
                    1. Top 5 de Libros Más Descargados.
                    
                    --------------- BUSQUEDAS ---------------
                    2. Buscar Libro Por Autor.
                    3. Buscar Libro Por Categoría.
                    4. Buscar Libro Por Titulo.
                    
                    ---------- LISTA DE BUSQUEDAS -----------
                    5. Lista de Autores Registrados.
                    6. Lista de Autores Vivos en Cierto Año.
                    7. Lista de Libros Por Idioma.
                    8. Lista de libros Por Titulo.
                    0. Salir
                    """;

            System.out.println(" ");
            System.out.println("--------------------------");
            System.out.println("*** MENÚ DE OPCIONES ***");
            System.out.println("---------------------------");

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    top5LibrosMasDescargados();
                    break;
                case 2:
                    buscarLibroPorAutor();
                    break;
                case 3:
                    buscarLibroPorCategoria();
                    break;
                case 4:
                    buscarLibroPorTitulo();
                    break;
                case 5:
                    autoresRegistrados();
                    break;
                case 6:
                    autoresVivos();
                    break;
                case 7:
                    librosPorIdioma();
                    break;
                case 8:
                    librosRegistrados();
                    break;
                case 0:
                    System.out.println("Saliendo de la LIBRERIA ALURA ");
            }

        }
    }

    //DECLARACIÓN DE LAS FUNCIONES DEL SWITCH
    // ---------------- RECOMENDACIONES ---------------------------
    private void top5LibrosMasDescargados(){
        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println("TOP 5 DE LIBROS MÁS DESCARGADOS");
        System.out.println(" ");
        List<Libros> listaLibrosMasDescargados = repositorio.findTop5ByOrderByNumeroDeDescargasDesc();
        listaLibrosMasDescargados.forEach(b ->
                System.out.println(
                        "---------- DATOS DEL LIBRO ----------" + "\n" +
                        "Título: " + b.getTitulo() + "\n" +
                        "Autor: " + b.getAutores() + "\n" +
                        "Idioma: " + b.getIdioma() + "\n" +
                        "Categoría: " + b.getCategoria() + "\n" +
                        "Descargas: " + b.getNumeroDeDescargas() + "\n" +
                        "------------------------------------" + "\n"));
    }

    // ---------------- BUSQUEDAS ---------------------------
    private void buscarLibroPorAutor(){
        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println("¿Qué Autor desea buscar?");
        var nombreAutor = teclado.nextLine();
        Optional<Libros> autorBuscado  = repositorio.findByAutoresContainsIgnoreCase(nombreAutor);

        if(autorBuscado.isPresent()){
            System.out.println(" ");
            System.out.println(autorBuscado.get());
        }else{
            System.out.println("AUTOR NO ENCONTRADO");
        }
    }

    private void buscarLibroPorCategoria(){
        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println("¿Qué Categoría desea buscar?");
        System.out.println("""
                1.Ficción - Fiction.
                2.Historias de amor - Love stories.
                3.Ficción romántica - Romance fiction.
                4.Historia - History.
                5.Bibliografía - Biography.
                6.Ficción fantástica - Fantasy fiction.
                7.Drama - Drama.""");
        var nombreCategoria = teclado.nextLine();
        Optional<Libros> categoriaBuscado  = repositorio.findByCategoriaContainsIgnoreCase(nombreCategoria);

        if(categoriaBuscado.isPresent()){
            System.out.println(" ");
            System.out.println(categoriaBuscado.get());
        }else{
            System.out.println("CATEGORÍA NO ENCONTRADA");
        }
    }

    private void buscarLibroPorTitulo(){
        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println("¿Qué libro desea buscar?");
        var nombreLibro = teclado.nextLine();
        Optional<Libros> libroBuscado  = repositorio.findByTituloContainsIgnoreCase(nombreLibro);

        if(libroBuscado.isPresent()){
            System.out.println(" ");
            System.out.println(libroBuscado.get());
        }else{
            System.out.println("SERIE NO ENCONTRADA");
        }
    }

    // ---------------- LISTA DE BUSQUEDAS ---------------------------
    private void autoresRegistrados(){
        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println("LISTA DE AUTORES REGISTRADOS");
        List<Libros> listaAutores = repositorio.findAll();
        //System.out.println(listaAutores);
        listaAutores.forEach(b ->
                System.out.println(
                        "---------- DATOS DEL AUTOR ----------" + "\n" +
                        "Autor: "+ b.getAutores() + "\n" +
                        "Libros: " + b.getTitulo()  + "\n" +
                        "Fecha de Nacimiento: " + b.getFechaDeCumpleanos() + "\n" +
                        "Fecha de Muerte: " + b.getFechaDeMuerte()+ "\n" +
                        "-------------------------------------" + "\n" ));
    }

    private void autoresVivos(){
        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println("¿Año qué desea buscar?");
        var fechaDeCumpleanos = teclado.nextInt();
        List<Libros> autorBuscado  = repositorio.findByFechaDeCumpleanosLessThanEqual(fechaDeCumpleanos);
        autorBuscado.forEach(b ->
                System.out.println(
                        "---------- DATOS DEL AUTOR ----------" + "\n" +
                        "Autor: "+ b.getAutores() + "\n" +
                        "Libros: " + b.getTitulo()  + "\n" +
                        "Fecha de Nacimiento: " + b.getFechaDeCumpleanos() + "\n" +
                        "Fecha de Muerte: " + b.getFechaDeMuerte()+ "\n" +
                        "-------------------------------------" + "\n"));
    }

    private void librosPorIdioma(){
        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println("Selecciona el idioma y escribe su abreviatura:");
        System.out.println("""
                1.Español - es.
                2.Francés - fr.
                3.Inglés - en.
                4.Portugués - pt.""");
        var idiomaLibro = teclado.nextLine();
        List<Libros> busquedaIdioma = repositorio.findByIdioma(idiomaLibro);
        busquedaIdioma.forEach(b ->
                System.out.println(
                        "---------- DATOS DEL LIBRO ----------" + "\n" +
                        "Título: " + b.getTitulo() + "\n" +
                        "Autor: " + b.getAutores() + "\n" +
                        "Idioma: " + b.getIdioma() + "\n" +
                        "Categoría: " + b.getCategoria() + "\n" +
                        "Descargas: " + b.getNumeroDeDescargas() + "\n" +
                        "------------------------------------" + "\n"));
    }

    private void librosRegistrados(){
        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println("LISTA DE LIBROS REGISTRADOS");
        System.out.println(" ");
        List<Libros> listaLibros = repositorio.findAll();
        listaLibros.forEach(b ->
                System.out.println(
                        "---------- DATOS DEL LIBRO ----------" + "\n" +
                        "Título: " + b.getTitulo() + "\n" +
                        "Autor: " + b.getAutores() + "\n" +
                        "Idioma: " + b.getIdioma() + "\n" +
                        "Categoría: " + b.getCategoria() + "\n" +
                        "Descargas: " + b.getNumeroDeDescargas() + "\n" +
                        "------------------------------------" + "\n"));
    }







}
