package Examen_1.Obtener_Superviviente;

public class DoubleCircularLinkedList<T> {
	DoubleNode<T> first;
	
	public void anadirNodo(T pData) {
		if(this.first == null) {
			this.first = new DoubleNode<T>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			DoubleNode<T> actual = this.first.prev;
			actual.next = new DoubleNode<T>(pData);
			actual.next.next = this.first;
			actual.next.prev = actual;
			this.first.prev = actual.next;
		}
	}
	
	public void imprimirLista() {
		if(this.first == null) {
			System.out.println("La lista esta vacia");
		}else {
			DoubleNode<T> actual = this.first;
			while(actual.next != this.first) {
				System.out.print(actual.data + ", ");
				actual = actual.next;
			}
			System.out.println(actual.data +".\n");
		}
	}
	
	public int size() {
		int i = 0;
		if(this.first == null) {
			i = 0;
		}else {
			DoubleNode<T> actual = this.first;
			while(actual.next != this.first) {
				i+=1;
				actual = actual.next;
			}
			i+=1;
		}
		
		return i;
	}
	
	public void eliminarNodo(T pData) {
		boolean enc = false;
		if(this.first == null) {
			System.out.println("La lista esta vacia");
		}else {
			DoubleNode<T> actual = this.first;
			while(!enc && actual.next!= this.first) {
				if(actual.data.equals(pData)) {
					enc = true;
				}else {
					actual = actual.next;
				}
			}
			if(enc) {
				if(this.size() == 1) {
					this.first = null;
				}else {
					this.first = actual.next;
					this.first.prev = actual.prev;
					actual.prev.next = this.first;
				}
			}
		}
	}
	
	public T obtenerSuperviviente(Integer pNumSaltos) {
		if(pNumSaltos >= this.size()) {
			System.out.println("El numero de saltos no es menor que el tamaño de la lista");
		}else {
			int i = 0;
			while(i < pNumSaltos) {
				this.eliminarNodo(this.first.data);
				i++;
			}
		}
		
		return this.first.data;
	}
}
