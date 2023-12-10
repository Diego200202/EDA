package Entregas.cuartaFase;

import java.util.*;

public class ListaPelis {
    private List<Peli> peliculas;

    public ListaPelis() {
        this.peliculas = new ArrayList<>();
    }

    public List<Peli> getPeliculas() {
        return peliculas;
    }

    public void agregarPelicula(Peli pelicula) {
        peliculas.add(pelicula);
    }

    public Peli buscarPeliculaPorNombre(String nombre) {
        for (Peli pelicula : peliculas) {
            if (pelicula.getTitulo().equals(nombre)) {
                return pelicula;
            }
        }
        return null;
    }
}
