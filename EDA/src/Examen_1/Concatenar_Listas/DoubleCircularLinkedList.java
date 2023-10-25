package Examen_1.Concatenar_Listas;

public class DoubleCircularLinkedList<T> {
	
	DoubleNode<T> first;
	
	public void anadirNodoFinal(T pData) {
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
			while(actual.next!= this.first) {
				System.out.print(actual.data + ", ");
				actual = actual.next;
			}
			System.out.println(actual.data + ".\n");
		}
	}
	
	public void concatenarListas(DoubleCircularLinkedList<T> pLista) {
	    if (this.first == null && pLista.first == null) {
	        System.out.println("Las listas están vacías");
	    } else if (this.first != null && pLista.first != null) {
	        DoubleNode<T> lastThisList = this.first.prev;
	        DoubleNode<T> lastPLista = pLista.first.prev;

	        lastThisList.next = pLista.first;
	        pLista.first.prev = lastThisList;

	        lastPLista.next = this.first;
	        this.first.prev = lastPLista;
	        this.imprimirLista();

	    } else if (this.first == null) {
	        this.first = pLista.first;
	        this.imprimirLista();
	    }else {
	    	this.imprimirLista();
	    }
	}

	
	public void reset() {
		this.first = null;
	}
}
