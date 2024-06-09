package com.aluracursos.LibreriaAluraChallenge.model;

public enum Categoria {

    FICTION("Fiction", "Ficción"),
    LOVE_STORIES("Love stories", "Historias de amor"),
    ROMANCE_FICTION("Romance fiction", "Ficción romántica"),
    HISTORY("History", "Historia"),
    BIOGRAPHY("Biography", "Bibliografía"),
    FANTASY_FICTION("Fantasy fiction", "Ficción fantástica");;

    private String categoriaOmdb;
    private String categoriaEspanol;

    Categoria (String categoriaOmdb, String categoriaEspanol) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaEspanol = categoriaEspanol;
    }

    public static Categoria fromString (String text){
        for (Categoria categoria : Categoria.values()){
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static Categoria fromEspanol (String text){
        for (Categoria categoria : Categoria.values()){
            if (categoria.categoriaEspanol.equalsIgnoreCase(text)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}
