package Entregas.cuartaFase;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

    HashMap<String, Integer> th = new HashMap<>();
    String[] keys;
    List<List<Integer>> adjList;
    List<String> actores;

    public void crearGrafo(ListaPelis lista) {
        int[] index = { 0 };

        for (Peli pelicula : lista.getPeliculas()) {
            for (String actor : pelicula.getActores()) {
                th.computeIfAbsent(actor, key -> index[0]++);
            }
        }

        keys = new String[th.size()];
        th.forEach((k, v) -> keys[v] = k);

        adjList = new ArrayList<>(th.size());

        for (int i = 0; i < th.size(); i++) {
            adjList.add(new ArrayList<>());
        }

        for (Peli pelicula : lista.getPeliculas()) {
            List<String> actores = pelicula.getActores();
            for (int i = 0; i < actores.size(); i++) {
                for (int j = i + 1; j < actores.size(); j++) {
                    int indexI = th.get(actores.get(i));
                    int indexJ = th.get(actores.get(j));

                    if (!adjList.get(indexI).contains(indexJ)) {
                        adjList.get(indexI).add(indexJ);
                        adjList.get(indexJ).add(indexI);
                    }
                }
            }
        }
    }

    public void tamaño() {
        System.out.println(this.th.size());
    }

    public void print() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Element: " + i + " " + keys[i] + " --> ");
            for (int k : adjList.get(i))
                System.out.print(keys[k] + " ### ");

            System.out.println();
        }
    }

    public boolean estanConectados(String a1, String a2) {
        Queue<Integer> porExaminar = new LinkedList<>();
        Integer pos1 = th.get(a1);
        Integer pos2 = th.get(a2);

        if (pos1 == null || pos2 == null) {
            System.out.println("Uno o ambos actores no están presentes en el grafo.");
            return false;
        }

        boolean enc = false;
        boolean[] examinados = new boolean[th.size()];

        porExaminar.add(pos1);
        examinados[pos1] = true;

        while (!porExaminar.isEmpty()) {
            int actual = porExaminar.poll();
            if (actual == pos2) {
                enc = true;
                break;
            }

            for (int vecino : adjList.get(actual)) {
                if (!examinados[vecino]) {
                    porExaminar.add(vecino);
                    examinados[vecino] = true;
                }
            }
        }

        return enc;
    }

    public ArrayList<String> listaEstanConectados(String a1, String a2) {
        Queue<Integer> porExaminar = new LinkedList<>();
        Integer pos1 = th.get(a1);
        Integer pos2 = th.get(a2);
        ArrayList<String> relaciones = new ArrayList<>();

        if (pos1 == null || pos2 == null) {
            System.out.println("Uno o ambos actores no están presentes en el grafo.");
            return relaciones;
        }

        boolean[] examinados = new boolean[th.size()];
        HashMap<Integer, Integer> padre = new HashMap<>();

        porExaminar.add(pos1);
        examinados[pos1] = true;

        while (!porExaminar.isEmpty()) {
            int actual = porExaminar.poll();

            for (int vecino : adjList.get(actual)) {
                if (!examinados[vecino]) {
                    porExaminar.add(vecino);
                    examinados[vecino] = true;
                    padre.put(vecino, actual);
                }
            }
        }

        if (examinados[pos2]) {
            int actual = pos2;
            while (actual != pos1) {
                relaciones.add(keys[actual]);
                actual = padre.get(actual);
            }
            relaciones.add(keys[pos1]);
            Collections.reverse(relaciones);
        } else {
            System.out.println("No hay conexión entre " + a1 + " y " + a2);
        }

        return relaciones;
    }

    public void cargarFicheros(String pString, ListaPelis lista) {
        Set<String> actoresSet = new HashSet<>();
        Map<String, Peli> peliculasMap = new HashMap<>();

        for (int i = 1970; i <= 2023; i++) {
            String nombreFichero = pString + "actors_and_films_" + i + ".txt";

            try (Scanner entrada = new Scanner(new FileReader(nombreFichero))) {
                while (entrada.hasNext()) {
                    String linea = entrada.nextLine();
                    String[] separado = separadorDeLineas(linea);

                    String actor = separado[1];
                    String peliculaNombre = separado[3];

                    peliculasMap.computeIfAbsent(peliculaNombre, key -> new Peli(peliculaNombre, new ArrayList<>()))
                            .agregarActor(actor);

                    actoresSet.add(actor);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        peliculasMap.values().forEach(lista::agregarPelicula);
        this.actores = new ArrayList<>(actoresSet);
    }

    public HashMap<String, Double> pageRank(double dampingFactor, int iteraciones) {
        double[][] pageRankNuevo = new double[2][th.size()];

        int indiceLectura = 0;
        int indiceEscritura = 1;

        for (int iteracion = 0; iteracion < iteraciones; iteracion++) {
            Arrays.fill(pageRankNuevo[indiceEscritura], 0.0);

            for (int i = 0; i < pageRankNuevo[indiceEscritura].length; i++) {
                double sumatoria = 0.0;
                List<Integer> vecinos = adjList.get(i);

                for (int vecino : vecinos) {
                    sumatoria += pageRankNuevo[indiceLectura][vecino] / vecinos.size();
                }

                // Ajustar el valor directamente en el array existente
                pageRankNuevo[indiceEscritura][i] = (1.0 - dampingFactor) / th.size() + dampingFactor * sumatoria;
            }

            // Utilizar System.arraycopy solo para los arrays de double
            System.arraycopy(pageRankNuevo[indiceEscritura], 0, pageRankNuevo[indiceLectura], 0, th.size());
        }

        int ultimoIndice = (iteraciones - 1) % 2;
        HashMap<String, Double> resultados = new HashMap<>();

        // Crear un nuevo HashMap y copiar los valores
        for (int i = 0; i < th.size(); i++) {
            resultados.put(keys[i], pageRankNuevo[ultimoIndice][i]);
        }

        return resultados;
    }

    public double prInicial() {
        return 1.0 / th.size();
    }

    public ArrayList<Par> buscarActores(List<String> actores) {
        // Convertir las entradas del HashMap a una lista y ordenarla
        HashMap<String, Double> hashMap = this.pageRank(0.85, 100);

        ArrayList<Par> resultado = new ArrayList<>();

        for (String actor : actores) {
            Double pr = hashMap.get(actor);
            Par par = new Par(actor, pr);
            resultado.add(par);
        }

        Collections.sort(resultado, Comparator.comparing(Par::getPr).reversed());

        return resultado;

    }

    public static String[] separadorDeLineas(String pString) {
        return pString.split(" ### ");
    }

    public List<String> getLista() {
        return this.actores;
    }

}
