package Entregas.primeraFase;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class ProgramaPrincipal {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		System.out.println("Introduce el nombre del directorio donde se encuentran los archivos: ");	
		Ficheros.getFicheros().cargarHashMaps(sc.nextLine());
		System.out.println("Introduce el directorio donde quieres que se guarden los archivos.txt: ");
		String dir = sc.nextLine();
		
		insertarActor(Ficheros.getFicheros().getHashMapActores());
		buscarActor(Ficheros.getFicheros().getHashMapActores());
		obtenerListaPeliculas(Ficheros.getFicheros().getHashMapActores());
		borrarActor(Ficheros.getFicheros().getHashMapActores());
		obtenerListaActores(Ficheros.getFicheros().getHashMapPeliculas());
		cambiarAñoPelicula(Ficheros.getFicheros().getHashMapPeliculas());
		ordenarListaActores();

		//Ficheros.getFicheros().guardarTxtActores(Ficheros.getFicheros().getHashMapActores(),dir + "MapaConClaveActores.txt");
		Ficheros.getFicheros().guardarTxtPeliculas(Ficheros.getFicheros().getHashMapPeliculas(),dir + "MapaConClavePeliculas.txt");
	}
	
	public static Actor buscarActor(Map<Actor, ArrayList<Pelicula>> mapaActores) {
		System.out.println("Nombre del actor que quieres buscar: ");
		Actor actor = new Actor(sc.nextLine());
		if (mapaActores.containsKey(actor)) {
	        // Se encontró un actor con el nombre proporcionado
			actor.listaPeliculas = mapaActores.get(actor);
	        return actor; 
	    }
		else System.out.println("El actor no existe");
		
	    return null; // No se encontró ningún actor con el nombre proporcionado
	}
	
	public static ArrayList<Pelicula> obtenerListaPeliculas(Map<Actor, ArrayList<Pelicula>> mapaActores) {
		System.out.println("Introduce el nombre del actor del que quieres obtener la lista de peliculas: ");
		Actor actor = new Actor(sc.nextLine());
		if(mapaActores.containsKey(actor)) {
			return mapaActores.get(actor);
		}
		else System.out.println("No existe el actor.");
		return null;
	}
	
	public static ArrayList<Actor> obtenerListaActores(Map<Pelicula, ArrayList<Actor>> mapaPeliculas) {
		System.out.println("Introduce el nombre de la pelicula de la que quieres obtener la lista de actores: ");
		Pelicula pelicula = new Pelicula(sc.nextLine(), 0);
		if(mapaPeliculas.containsKey(pelicula)) {
			return mapaPeliculas.get(pelicula);
		}
		else System.out.println("No existe la pelicula");
		
		return null;
	}
	
	public static void insertarActor(Map<Actor, ArrayList<Pelicula>> mapaActores) {
		System.out.println("Nombre del actor que quieres insertar: ");
		Actor actor = new Actor(sc.nextLine());
		if(!mapaActores.containsKey(actor)) {
		mapaActores.put(actor, actor.getListaPeliculas());
		}
		else {
			System.out.println("El actor ya existe");
		}
	}
	
	public static void cambiarAñoPelicula(Map<Pelicula, ArrayList<Actor>> mapaPeliculas) {
		System.out.println("Introduce el nombre de la pelicula de la que quieres cambiar el año de estreno: ");
		boolean encontrado = false;
		Pelicula pelicula = new Pelicula(sc.nextLine(), 0);
		if(mapaPeliculas.containsKey(pelicula)) {
			System.out.println("Introduce el año de estreno que quieres que tenga la pelicula: ");
			int año = sc.nextInt();
			while(!encontrado) {
				for(Pelicula p : mapaPeliculas.keySet()) {
					if(p.equals(pelicula)) {
					encontrado = true;
					p.setAñoEstreno(año);
					}
				}
			}
		}
		else System.out.println("No existe la pelicula");
	}
	
	public static void borrarActor(Map<Actor, ArrayList<Pelicula>> mapaActores) {
		System.out.println("Introduce el nombre del actor que quieres eliminar: ");
		Actor actor = new Actor(sc.nextLine());
		if(mapaActores.containsKey(actor)) {
			ListaActores.getListaActores().eliminarActor(actor.getNombre());
			mapaActores.remove(actor);
		}
		else System.out.println("No existe el actor que quieres eliminar");
	}
	
	public static void ordenarListaActores() {
		Collections.sort(ListaActores.getListaActores().getLista());
	}
}
