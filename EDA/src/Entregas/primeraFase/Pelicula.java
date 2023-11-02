package Entregas.primeraFase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pelicula {
	
	public String nombre;
	public ArrayList<Actor> listaActores;
	public int añoEstreno;
	
	public Pelicula(String pNombre, int pAño) {
		this.nombre = pNombre;
		this.añoEstreno = pAño;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getAñoEstreno() {
		return this.añoEstreno;
	}
	
	public void setAñoEstreno(int pAño) {
		this.añoEstreno = pAño;
	}
	
	public List<Actor> getListaActores(){
		return this.listaActores;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}