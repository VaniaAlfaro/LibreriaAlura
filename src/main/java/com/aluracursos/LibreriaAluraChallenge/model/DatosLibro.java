package com.aluracursos.LibreriaAluraChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") String autores,
        @JsonAlias("birth_year") Integer fechaDeCumpleanos,
        @JsonAlias("death_year") Integer fechaDeMuerte,
        @JsonAlias("languages") String idioma,
        @JsonAlias("download_count") Integer numeroDeDescargas,
        @JsonAlias ("subjects") String categoria) {
}
