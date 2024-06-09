package com.aluracursos.LibreriaAluraChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "Libros")

public class Libros {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
    private String autores;
    private Integer fechaDeCumpleanos;
    private Integer fechaDeMuerte;
    private String idioma;
    private Integer numeroDeDescargas;
    private String categoria;

    public Libros (DatosLibro datosLibro){
        this.id = Long.valueOf(datosLibro.id());
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autores();
        this.fechaDeCumpleanos = datosLibro.fechaDeCumpleanos();
        this.fechaDeMuerte = datosLibro.fechaDeMuerte();
        this.idioma = datosLibro.idioma();
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
        this.categoria = datosLibro.categoria();
    }

    public Libros(){

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Integer getFechaDeCumpleanos() {
        return fechaDeCumpleanos;
    }

    public void setFechaDeCumpleanos(Integer fechaDeCumpleanos) {
        this.fechaDeCumpleanos = fechaDeCumpleanos;
    }

    public Integer getFechaDeMuerte() {
        return fechaDeMuerte;
    }

    public void setFechaDeMuerte(Integer fechaDeMuerte) {
        this.fechaDeMuerte = fechaDeMuerte;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString(){
        return
                "---------- DATOS DEL LIBRO ----------" + "\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autores + "\n" +
                "Idioma: " + idioma + "\n" +
                "Categoría: " + categoria + "\n" +
                "Descargas: " + numeroDeDescargas + "\n" +
                "------------------------------------" +
                "\n" ;
    }


}
