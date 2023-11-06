package Entregas.segundaFase;

public class UnorderedCircularDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	    if (elem == null) {
	        System.out.println("No se puede añadir un elemento nulo");
	        return;
	    }

	    Node<T> nuevo = new Node<>(elem);

	    if (first == null) {
	        // La lista está vacía, el nuevo nodo apunta a sí mismo
	        nuevo.next = nuevo;
	        nuevo.prev = nuevo;
	    } else {
	        // La lista no está vacía, actualiza los punteros
	        nuevo.next = first;
	        nuevo.prev = first.prev;
	        first.prev.next = nuevo;
	        first.prev = nuevo;
	    }

	    first = nuevo;  // Actualiza el primer nodo
	    count++;
	}


	public void addToRear(T elem) {
	    if (elem == null) {
	        System.out.println("No se puede añadir un elemento nulo");
	        return;
	    }

	    Node<T> nuevo = new Node<>(elem);

	    if (first == null) {
	        // La lista está vacía, el nuevo nodo apunta a sí mismo
	        nuevo.next = nuevo;
	        nuevo.prev = nuevo;
	        first = nuevo;
	    } else {
	        // La lista no está vacía, actualiza los punteros
	        nuevo.next = first;
	        nuevo.prev = first.prev;
	        first.prev.next = nuevo;
	        first.prev = nuevo;
	    }

	    count++;
	}

		
		public void addAfter(T elem, T target) {
		// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
			// �COMPLETAR OPCIONAL!
			 if (elem == null) {
			        System.out.println("Introduce el elemento que quieres añadir");
			    } else {
			        Node<T> actual = this.first.next;
			        while (actual != this.first) {
			            if (actual.data.equals(target)) {  
			                Node<T> nuevo = new Node<T>(elem);
			                nuevo.next = actual.next;
			                nuevo.prev = actual;
			                actual.next.prev = nuevo;
			                actual.next = nuevo;
			                this.count++;
			                return;
			            }
			            actual = actual.next;
			        }
			        System.out.println("El elemento target no está en la lista");
			    }
		}

}
