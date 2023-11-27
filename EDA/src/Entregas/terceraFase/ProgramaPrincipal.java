package Entregas.terceraFase;

import java.util.ArrayList;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        // Crear una instancia de ListaPelis
        ListaPelis lista = new ListaPelis();
    
        // Cargar los ficheros y procesar las películas
    
        // Crear una instancia de Graph
        Graph graph = new Graph();

        graph.cargarFicheros("/home/diego/EDA/movies-dir/", lista);
    
        // Crear el grafo a partir de la lista de películas
        graph.crearGrafo(lista);
    
        // Imprimir el grafo
        System.out.println("Grafo:");
        //graph.print();
    
        // Verificar si dos actores están conectados
        String actor1 = "Brad Pitt";
        String actor2 = "Cate Blanchett";
    
        boolean estanConectados = graph.estanConectados(actor1, actor2);
        System.out.println("\n¿Están conectados " + actor1 + " y " + actor2 + "? " + estanConectados);
        
        ArrayList<String> listaConectados = new ArrayList<>();
        for(String s : listaConectados){
            System.out.println(s);
        }
    }
    
}
