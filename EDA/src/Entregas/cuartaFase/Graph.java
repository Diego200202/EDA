package Entregas.cuartaFase;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

	HashMap<String, Integer> th;
	String[] keys;
	ArrayList<Integer>[] adjList;

	public void crearGrafo(ListaPelis lista) {
		this.th = new HashMap<>();
		int index = 0;

		for (Peli pelicula : lista.getPeliculas()) {
			for (String actor : pelicula.getActores()) {
				// Modifica la lógica para manejar correctamente el caso cuando el actor ya está
				// en th
				if (!th.containsKey(actor)) {
					th.put(actor, index++);
				}
			}
		}

		keys = new String[th.size()];
		for (String k : th.keySet()) {
			keys[th.get(k)] = k;
		}

		adjList = new ArrayList[th.size()];
		for (int i = 0; i < th.size(); i++) {
			adjList[i] = new ArrayList<>();
		}

		for (Peli pelicula : lista.getPeliculas()) {
			List<String> actores = pelicula.getActores();
			for (int i = 0; i < actores.size(); i++) {
				for (int j = i + 1; j < actores.size(); j++) {
					int indexI = th.get(actores.get(i));
					int indexJ = th.get(actores.get(j));

					// Evitar duplicados en las relaciones
					if (!adjList[indexI].contains(indexJ)) {
						adjList[indexI].add(indexJ);
						adjList[indexJ].add(indexI);
					}
				}
			}
		}
	}

	public void print() {
		for (int i = 0; i < adjList.length; i++) {
			System.out.print("Element: " + i + " " + keys[i] + " --> ");
			for (int k : adjList[i])
				System.out.print(keys[k] + " ### ");

			System.out.println();
		}
	}

	public boolean estanConectados(String a1, String a2) {
		Queue<Integer> porExaminar = new LinkedList<>();
		Integer pos1 = th.get(a1);
		Integer pos2 = th.get(a2);

		// Verificar si los actores están presentes en el grafo
		if (pos1 == null || pos2 == null) {
			// Manejar el caso en el que uno o ambos actores no están presentes en el grafo
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

			for (int vecino : adjList[actual]) {
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

		// Verificar si los actores están presentes en el grafo
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

			for (int vecino : adjList[actual]) {
				if (!examinados[vecino]) {
					porExaminar.add(vecino);
					examinados[vecino] = true;
					padre.put(vecino, actual);
				}
			}
		}

		// Construir la cadena de conexiones
		if (examinados[pos2]) {
			int actual = pos2;
			while (actual != pos1) {
				relaciones.add(keys[actual]);
				actual = padre.get(actual);
			}
			relaciones.add(keys[pos1]);

			// Invertir la lista para que esté en orden correcto
			Collections.reverse(relaciones);
		} else {
			System.out.println("No hay conexión entre " + a1 + " y " + a2);
		}

		return relaciones;
	}

	public void cargarFicheros(String pString, ListaPelis lista) {
		Map<String, Peli> peliculasMap = new HashMap<>();

		for (int i = 1970; i <= 2023; i++) {
			String nombreFichero = pString + "actors_and_films_" + i + ".txt";

			try {
				Scanner entrada = new Scanner(new FileReader(nombreFichero));
				String linea;
				String[] separado;

				while (entrada.hasNext()) {
					linea = entrada.nextLine();
					separado = separadorDeLineas(linea);

					String actor = separado[1];
					String peliculaNombre = separado[3];

					// Buscar si la película ya existe en el mapa temporal
					Peli peliculaExistente = peliculasMap.get(peliculaNombre);

					if (peliculaExistente != null) {
						peliculaExistente.agregarActor(actor);
					} else {
						// Si no existe, crear una nueva instancia de Peli y agregarla al mapa temporal
						List<String> actores = new ArrayList<>();
						actores.add(actor);
						Peli peliculaNueva = new Peli(peliculaNombre, actores);
						peliculasMap.put(peliculaNombre, peliculaNueva);

						// Agregar la película a la lista
						lista.agregarPelicula(peliculaNueva);
					}
				}

				entrada.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// No es necesario crear el grafo aquí, ya que lo haces después en el main
	}

	public static String[] separadorDeLineas(String pString) {
		String[] lineaSeparada = pString.split(" ### ");
		return lineaSeparada;
	}

    public HashMap<String, Double> pageRank(){
        return null;
    }

}
