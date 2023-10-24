package Examen_1.Obtener_Lista_Simetrica;

public class DoubleCircularLinkedList<T> {

	DoubleNode<Integer> first;
	
	public void anadirNodoPrincipio(Integer pData) {
		if(this.first == null) {
			this.first = new DoubleNode<Integer>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			DoubleNode<Integer> actual = this.first.prev;
			actual.next = new DoubleNode<Integer>(pData);
			actual.next.next = this.first;
			this.first = actual.next;
			this.first.prev = actual;
		}
	}
	
	public void anadirNodoFinal(Integer pData) {
		if(this.first == null) {
			this.first = new DoubleNode<Integer>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			DoubleNode<Integer> actual = this.first.prev;
			actual.next = new DoubleNode<Integer>(pData);
			actual.next.next = this.first;
			this.first.prev = actual.next;
			actual.next.prev = actual;
		}
	}
	
	public void imprimirLista() {
		if(this.first == null) {
			System.out.println("La lista esta vacia");
		}else {
			DoubleNode<Integer> actual = this.first;
			while(actual.next!=this.first) {
				System.out.print(actual.data +", ");
				actual = actual.next;
			}
			System.out.println(actual.data +".\n");
		}
	}
	
	public void obtenerListaSimetrica(SimpleLinkedList<Integer> pLista) {
		if(pLista.first == null) {
			System.out.println("La lista esta vacia");
		}else {
			Node<Integer> actual = pLista.first;			
			while(actual.next!=null) {
				DoubleNode<Integer> actualNuevo = new DoubleNode<Integer>(actual.data);
				DoubleNode<Integer> actualNegativo = new DoubleNode<Integer>(-actual.data);
				anadirNodoFinal(actualNuevo.data);
				anadirNodoPrincipio(actualNegativo.data);
				actual = actual.next;
			}
			anadirNodoFinal(actual.data);
			anadirNodoPrincipio(-actual.data);
		}
	}
}
