package Entregas.primeraFase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Ficheros {

		private static Ficheros mFicheros;
		private Map<Actor, ArrayList<Pelicula>> actores = new HashMap<>();
		private Map<Pelicula, ArrayList<Actor>> peliculas = new HashMap<>();
		
		private Ficheros() {}
		
		public static Ficheros getFicheros() {
			if(mFicheros == null) {
				mFicheros = new Ficheros();
			}
			return mFicheros;
		}		

		public void guardarTxtActores(Map<Actor, ArrayList<Pelicula>> pHashMap, String pNombreArchivo) throws FileNotFoundException, IOException, ClassNotFoundException{
			FileOutputStream ficheroSalida=new FileOutputStream(pNombreArchivo);  
			String saltoLinea = " \n";
			String despuesClave = ": ";
			String coma = " / ";
			for(Actor clave : pHashMap.keySet()) {
				ficheroSalida.write(clave.getNombre().getBytes());
				ficheroSalida.write(despuesClave.getBytes());
				for(Pelicula p : pHashMap.get(clave)) {
					ficheroSalida.write(p.getNombre().getBytes());
					ficheroSalida.write(coma.getBytes());
				}
				ficheroSalida.write(saltoLinea.getBytes());
			}
			ficheroSalida.close();
		}
		
		public void guardarTxtPeliculas(Map<Pelicula, ArrayList<Actor>> pHashMap, String pNombreArchivo) throws FileNotFoundException, IOException, ClassNotFoundException{
			FileOutputStream ficheroSalida=new FileOutputStream(pNombreArchivo);  
			String saltoLinea = " \n";
			String despuesClave = ": ";
			String coma = " / ";
			String año1 = " (";
			String año2 = ")";
			for(Pelicula clave : pHashMap.keySet()) {
				String año = clave.getAñoEstreno()+"";
				ficheroSalida.write(clave.getNombre().getBytes());
				ficheroSalida.write(año1.getBytes());
				ficheroSalida.write(año.getBytes());
				ficheroSalida.write(año2.getBytes());
				ficheroSalida.write(despuesClave.getBytes());
				for(Actor a : pHashMap.get(clave)) {
					ficheroSalida.write(a.getNombre().getBytes());
					ficheroSalida.write(coma.getBytes());
				}
				ficheroSalida.write(saltoLinea.getBytes());
			}
			ficheroSalida.close();
		}
    
		public void cargarHashMaps(String pString) {
		    for (int i = 1970; i <= 2023; i++) {
		        String nombreFichero = pString + "actors_and_films_" + i + ".txt";
		        try {
		            Scanner entrada = new Scanner(new FileReader(nombreFichero));
		            String linea;
		            String[] separado;

		            while (entrada.hasNext()) {
		                linea = entrada.nextLine();
		                separado = separadorDeLineas(linea);

		                // Crear una nueva película para cada línea
		                Pelicula pelicula = new Pelicula(separado[3], i);

		                // Crear un objeto Actor
		                Actor actor = new Actor(separado[1]);

		                if (this.actores.containsKey(actor)) {
		                    // Si el actor ya existe en el HashMap, obten su lista de películas y agrégale la nueva película.
		                    ArrayList<Pelicula> listaPeliculas = this.actores.get(actor);
		                    listaPeliculas.add(pelicula);
		                } else {
		                    // Si el actor no existe en el HashMap, crea una nueva lista de películas y agrega el actor con su lista.
		                    ArrayList<Pelicula> listaPeliculas = actor.getListaPeliculas();
		                    listaPeliculas.add(pelicula);
		                    
		                    ListaActores.getListaActores().añadirActor(actor.getNombre());
		                    this.actores.put(actor, listaPeliculas);
		                }
		                
		                if (this.peliculas.containsKey(pelicula)) {
		                    // Si el actor ya existe en el HashMap, obten su lista de películas y agrégale la nueva película.
		                    ArrayList<Actor> listaActores = this.peliculas.get(pelicula);
		                    listaActores.add(actor);
		                } else {
		                    // Si el actor no existe en el HashMap, crea una nueva lista de películas y agrega el actor con su lista.
		                    ArrayList<Actor> listaActores = new ArrayList<>();
		                    listaActores.add(actor);
		                    this.peliculas.put(pelicula, listaActores);
		                }
		            }
		            entrada.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}

		public static String[] separadorDeLineas(String pString) {
			String[] lineaSeparada = pString.split(" ### ");
			return lineaSeparada;
		}
		
		public Map<Actor, ArrayList<Pelicula>> getHashMapActores(){
			return this.actores;
		}
		
		public Map<Pelicula, ArrayList<Actor>> getHashMapPeliculas(){
			return this.peliculas;
		}
}
