package Entrega1;

import java.util.*;

public class Actor {
	
	public String nombre;
	public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
	
	public Actor(String pNombre) {
		this.nombre = pNombre;
	}
	 
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	
	public ArrayList<Pelicula> getListaPeliculas(){
		return this.listaPeliculas;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Actor actor = (Actor) obj;
        return Objects.equals(nombre, actor.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
