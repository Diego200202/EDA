package Examen_1.Reemplazar_Por_Secuencias;

public class DoubleLinkedList<T> {
	DoubleNode<String> first;
	
	public void anadirEnOrden(String pData) {
		if(this.first == null) {
			this.first = new DoubleNode<String>(pData);
			this.first.next = null;
			this.first.prev = null;
		}else {
			DoubleNode<String> actual = this.first;
			DoubleNode<String> posicion = this.first;
			boolean enc = false;
			while(!enc && actual != null) {
				if(actual.data.compareTo(pData)>0) {
					enc = true;
				}else {
					posicion = actual;
					actual = actual.next;
				}
			}
			if(enc) {
				posicion.next = new DoubleNode<String>(pData);
				posicion.next.prev = posicion;
				posicion.next.next = actual;
				actual.prev = posicion.next;
			}else {
				posicion.next = new DoubleNode<String>(pData);
				posicion.next.prev = posicion;
			}
		}
	}
	
	public void imprimirLista() {
		DoubleNode<String> actual = this.first;
		while(actual!=null) {
			System.out.print(actual.data + ", ");
			actual = actual.next;
		}
		System.out.println("\n");
	}
	
	public void eliminar(String pData) {
		if(this.first == null) {
			
		}else {
			DoubleNode<String> actual = this.first;
			DoubleNode<String> posicion = this.first;
			boolean enc = false;
			while(!enc && actual!=null) {
				if(actual.data.compareTo(pData)== 0) {
					enc = true;
				}else {
					posicion = actual;
					actual = actual.next;
				}
			}
			if(enc) {
				if(actual == this.first) {
					actual.next.prev = null;
					this.first = actual.next;
				}else if(actual.next== null) {
					posicion.next = null;
				}else {
					actual = actual.next;
					posicion.next = actual;
					actual.prev = posicion;
				}
			}
		}
	}
	
	public void reemplazar(Pareja[] pParejas) {
		for(Pareja p : pParejas) {
			for(String s : p.replacement) {
				anadirEnOrden(s);
			}
			eliminar(p.target);
		}
	}
}
