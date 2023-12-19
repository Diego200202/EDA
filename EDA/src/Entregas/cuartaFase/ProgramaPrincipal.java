package Entregas.cuartaFase;

import java.util.*;

public class ProgramaPrincipal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Crear una instancia de ListaPelis
        ListaPelis lista = new ListaPelis();

        //Reloj para tiempo total
        StopWatch timer1 = new StopWatch();

        //Reloj para cargar ficheros y crear el grafo
        StopWatch timer2 = new StopWatch();

        // Crear una instancia de Graph
        Graph graph = new Graph();

        System.out.println("Introduce la ruta al directorio donde estan los archivos:");
        String dir = sc.nextLine();
        sc.close();

        // Cargar los ficheros y procesar las películas
        graph.cargarFicheros(dir, lista);

        // Crear el grafo a partir de la lista de películas
        graph.crearGrafo(lista);

        double tiempo = timer2.elapsedTime();
        System.out.print("Numero de actores: ");
        graph.tamaño();

        System.out.println("PageRank inicial de cada actor/actriz: " + graph.prInicial());

        //Reloj para calcular Pagerank y crear l alista ordenada
        StopWatch timer3 = new StopWatch();

        graph.buscarActores(graph.getLista());

        /*for (Par entry : graph.buscarActores(graph.getLista())) {
            String actor = entry.getActor();
            Double pageRank = entry.getPr();

            System.out.println(actor + ": " + pageRank);
        }*/

        System.out.println("Tiempo(segundos) en cargar los ficheros y cerar el grafo: " + tiempo);
        System.out.println("Tiempo(segundos) en calcular el PageRank y crear la lista: " + timer3.elapsedTime());
        System.out.println("Tiempo total paa 1000 iteraciones en el calculo del pageRank: " + timer1.elapsedTime());
        System.out.println("Esto ha sido usando la lista");

    }

}