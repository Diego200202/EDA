package Entregas.cuartaFase;

import java.util.*;

public class ProgramaPrincipal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Crear una instancia de ListaPelis
        ListaPelis lista = new ListaPelis();

        // Cargar los ficheros y procesar las películas

        // Crear una instancia de Graph
        Graph graph = new Graph();

        System.out.println("Introduce la ruta al directorio donde estan los archivos:");
        String dir = sc.nextLine();
        sc.close();

        graph.cargarFicheros(dir, lista);

        // Crear el grafo a partir de la lista de películas
        graph.crearGrafo(lista);

        System.out.print("Numero de actores: ");
        graph.tamaño();

        System.out.println("PageRank inicial de cada actor/actriz: " + graph.prInicial());
        StopWatch timer = new StopWatch();

        graph.buscarActores(graph.pageRank(0.85, 1000));

        /*
         * for (Par entry : graph.buscarActores(graph.pageRank(0.85, 10000))) {
         * String actor = entry.getActor();
         * Double pageRank = entry.getPr();
         * 
         * System.out.println(actor + ": " + pageRank);
         * }
         */

        System.out.println("Tiempo(segundos): " + timer.elapsedTime());

    }

}