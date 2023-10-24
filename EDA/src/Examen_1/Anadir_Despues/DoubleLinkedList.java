package Examen_1.Anadir_Despues;

public class DoubleLinkedList<T> {
	DoubleNode<T> first;
	
	public void anadirNodo(T pData) {
		DoubleNode<T> actual;
		if(this.first == null) {
			this.first = new DoubleNode<T>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			actual = this.first.prev;
			actual.next = new DoubleNode<T>(pData);
			actual.next.next = this.first;
			actual.next.prev = actual;
			this.first.prev = actual.next;
		}
	}
	
	public void imprimirLista() {
		if(this.first == null) {
			System.out.println("La lisa esta vacia");
		}else {
			DoubleNode<T> actual = this.first;
			while(actual.next != this.first) {
				System.out.print(actual.data + " , ");
				actual = actual.next;
			}
			System.out.print(actual.data + ".\n");
		}
	}
	
	public void reset() {
		this.first = null;
	}
	
	public void anadirDespues(T pData, T pTarget) {
		DoubleNode<T> actual = this.first;
		DoubleNode<T> previo = this.first.prev;
		boolean enc = false;
		
		if(pTarget != this.first.data) {
			previo = actual;
			actual = actual.next;
			while(actual != this.first && actual.data != pTarget) {
				previo = actual;
				actual = actual.next;
				if(actual.data == pTarget) {
					enc = true;
				}
			}
			if(enc) {
				previo = actual;
				actual = actual.next;
				
				actual.prev = new DoubleNode<T>(pData);
				actual.prev.next = actual;
				actual.prev.prev = previo;
				previo.next = actual.prev;
			}else {
				actual.prev = new DoubleNode<T>(pData);
				actual.prev.next = actual;
				actual.prev.prev = previo;
				this.first = actual.prev;
				previo.next = this.first;
			}
		}else {
			previo = actual;
			actual = actual.next;
			
			actual.prev = new DoubleNode<T>(pData);
			actual.prev.next = actual;
			actual.prev.prev = previo;
			previo.next = actual.prev;
		}
	}
}
