package Entregas.terceraFase;

import java.util.List;

public class Peli {
    private String titulo;
    private List<String> actores;

    public Peli(String titulo, List<String> actores) {
        this.titulo = titulo;
        this.actores = actores;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getActores() {
        return actores;
    }

    public void agregarActor(String actor) {
        actores.add(actor);
    }
}



