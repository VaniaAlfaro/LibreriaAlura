package com.aluracursos.LibreriaAluraChallenge.repository;

import com.aluracursos.LibreriaAluraChallenge.model.Categoria;
import com.aluracursos.LibreriaAluraChallenge.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository <Libros, Long> {
    //------------------ RECOMENDACIONES --------------------
    List<Libros> findTop5ByOrderByNumeroDeDescargasDesc();

    //------------------ BUSQUEDAS --------------------
    Optional<Libros>findByAutoresContainsIgnoreCase (String nombreAutor);
    Optional<Libros> findByCategoriaContainsIgnoreCase(String nombreCategoria);

    Optional<Libros> findByTituloContainsIgnoreCase (String nombreLibro);
    List<Libros> findByIdioma (String idiomaLibro);
    List<Libros> findByFechaDeCumpleanosLessThanEqual (Integer fechaDeCumpleanos);
}
