package Entregas.segundaFase;

public class UnorderedCircularDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	    if (elem == null) {
	        System.out.println("No se puede añadir un elemento nulo");
	        return;
	    }

	    Node<T> newNode = new Node<>(elem);

	    if (first == null) {
	        // La lista está vacía, el nuevo nodo apunta a sí mismo
	        newNode.next = newNode;
	        newNode.prev = newNode;
	    } else {
	        // La lista no está vacía, actualiza los punteros
	        newNode.next = first;
	        newNode.prev = first.prev;
	        first.prev.next = newNode;
	        first.prev = newNode;
	    }

	    first = newNode;  // Actualiza el primer nodo
	    count++;
	}


	public void addToRear(T elem) {
	    if (elem == null) {
	        System.out.println("No se puede añadir un elemento nulo");
	        return;
	    }

	    Node<T> newNode = new Node<>(elem);

	    if (first == null) {
	        // La lista está vacía, el nuevo nodo apunta a sí mismo
	        newNode.next = newNode;
	        newNode.prev = newNode;
	        first = newNode;
	    } else {
	        // La lista no está vacía, actualiza los punteros
	        newNode.next = first;
	        newNode.prev = first.prev;
	        first.prev.next = newNode;
	        first.prev = newNode;
	    }

	    count++;
	}

		
		public void addAfter(T elem, T target) {
		// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
			// �COMPLETAR OPCIONAL!
			if(elem == null) {
				System.out.println("Introduce el elemento que quieres añadir");
			}else {
				Node<T> actual = this.first.next;
				while(actual != first) {
					if(actual.next.data == target) {
						Node<T> nuevo = new Node<T>(elem);
						actual.next.prev=nuevo;
						actual.next= nuevo;
						nuevo.next= actual.next;
						nuevo.prev=actual;
						actual=nuevo;
						this.count++;
						return;
						
					}
				actual=actual.next;
				}
				System.out.println("El elemento target no esta en la lista");
			}
			
		}

}
