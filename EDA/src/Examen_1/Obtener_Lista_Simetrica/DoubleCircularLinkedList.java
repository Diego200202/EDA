package Examen_1.Obtener_Lista_Simetrica;

public class DoubleCircularLinkedList<T> {

	DoubleNode<Integer> first;
	
	public void anadirNodoPrincipio(Integer pData) {
		if(this.first == null) {
			this.first = new DoubleNode<Integer>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			DoubleNode<Integer> actual = this.first;
			while(actual.prev!=this.first){
				actual = actual.next;
			}
		}
	}
}
