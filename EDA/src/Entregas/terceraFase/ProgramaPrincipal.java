package Entregas.terceraFase;

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
        graph.print();
    
        // Verificar si dos actores están conectados
        String actor1 = "Logan Miller";
        String actor2 = "Q100977063";
    
        boolean estanConectados = graph.estanConectados(actor1, actor2);
        System.out.println("\n¿Están conectados " + actor1 + " y " + actor2 + "? " + estanConectados);
    }
    
}
