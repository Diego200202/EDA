package Examen_1.Borrar_SubLista;

public class DoubleLinkedList<T> {
	DoubleNode<T> first;
	
	public void anadirNodo(T pData) {
		DoubleNode<T> actual;
		
		if(this.first == null) {
			this.first = new DoubleNode<T>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			actual = first.prev;
			actual.next = new DoubleNode<T>(pData);
			actual.next.next = this.first;
			actual.next.prev = actual;
			this.first.prev = actual.next;
		}
	}
	
	public void imprimirLista() {
		 DoubleNode<T> actual=first;
	        if(first==null)
	        {
	            System.out.println("El nodo esta vacio");
	        }
	        else
	        {
	            System.out.print(actual.data+", ");
	            actual=actual.next;
	            while(actual!=first)
	            {
	                System.out.print(actual.data+", ");
	                actual=actual.next;
	            }
	            System.out.println("\n");
	        }
	}
	
	public void borrarSublista(DoubleLinkedList<T> pSublista) {
		DoubleNode<T> actual=first;
        DoubleNode<T> anterior=first;
        boolean esp=false;

        if(pSublista.first!=null) {
            while (!actual.data.equals(pSublista.first.data) && !anterior.equals(first.prev)) {
                anterior = actual;
                actual = actual.next;
            }
            if (!anterior.equals(first.prev)) {
                if (actual.equals(first)) {
                    if (pSublista.tamano() == tamano()) {
                        first = null;
                    } else {
                        anterior = anterior.prev;
                        esp = true;
                    }
                }
                for (int i = 0; i < pSublista.tamano(); i++) {
                    actual = actual.next;
                    if (actual == first) {
                        esp = true;
                    }
                }
                actual.prev = anterior;
                anterior.next = actual;
                if (esp) {
                    first = actual;
                }
            }
        }
	}
	
	public int tamano() {
		int i = 1;
		
		if(this.first == null) {
			i = 0;
		}else {
			DoubleNode<T> actual = this.first;
			while(actual.next!=this.first) {
				i++;
				actual = actual.next;
			}
		}
		
		return i;
	}
	
	public void reset() {
		this.first = null;
	}
}
