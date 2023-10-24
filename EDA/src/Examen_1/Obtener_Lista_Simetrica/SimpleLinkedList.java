package Examen_1.Obtener_Lista_Simetrica;

public class SimpleLinkedList<T> {
	Node<Integer> first;
	
	public void anadirNodo(Integer pData) {
		if(this.first == null) {
			this.first = new Node<Integer>(pData);
			this.first.next = null;
		}else {
			Node<Integer> actual = this.first;
			while(actual.next!=null) {
				actual = actual.next;
			}
			actual.next = new Node<Integer>(pData);
			actual.next.next = null;
		}
	}
	
	public void imprimirLista() {
		if(this.first == null) {
			System.out.println("La lista esta vacia");
		}else {
			Node<Integer> actual = this.first;
			while(actual.next!=null){
				System.out.print(actual.data +", ");
				actual = actual.next;
			}
			System.out.println(actual.data +".\n");
		}
	}
}
