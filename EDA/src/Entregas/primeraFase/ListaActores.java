package Entregas.primeraFase;

import java.util.ArrayList;

public class ListaActores {
	
	private static ListaActores listaActores;
	private ArrayList<String> lista = new ArrayList<>();
	
	private ListaActores() {}
	
	public static ListaActores getListaActores() {
		if(listaActores == null) {
			listaActores = new ListaActores();
		}
		return listaActores;
	}
	
	public void añadirActor(String pActor) {
		this.lista.add(pActor);
	}
	
	public ArrayList<String> getLista(){
		return this.lista;
	}
	
	public void eliminarActor(String pActor) {
		this.lista.remove(pActor);
	}

}
