package Entregas.segundaFase;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	@Override
	public void add(T elem) {
	    Node<T> nuevo = new Node<T>(elem); // Crear un nuevo nodo con el elemento a agregar

	    if (isEmpty()) { // Si la lista está vacía, simplemente agregamos el nuevo elemento
	        this.first = nuevo;
	        this.first.next = nuevo;
	        this.first.prev = nuevo;
	        this.count++;
	    } else {
	        Node<T> actual = this.first;

	        // Comparar con el primer elemento de la lista
	        if (elem instanceof Comparable) {
	            if (((Comparable<T>) elem).compareTo(actual.data) < 0) {
	                // Insertar elem antes del primer elemento
	                nuevo.next = actual;
	                nuevo.prev = actual.prev;
	                actual.prev.next = nuevo;
	                actual.prev = nuevo;
	                this.first = nuevo; // Actualizar el primer elemento si es necesario
	                this.count++; // Incrementar el contador de elementos en la lista
	                return;
	            }
	        }

	        // Recorrer la lista para encontrar la posición adecuada para insertar elem en orden
	        do {
	            if (elem instanceof Comparable) {
	                if (((Comparable<T>) elem).compareTo(actual.data) < 0) {
	                    // Insertar elem antes de actual
	                    nuevo.next = actual;
	                    nuevo.prev = actual.prev;
	                    actual.prev.next = nuevo;
	                    actual.prev = nuevo;
	                    this.count++; // Incrementar el contador de elementos en la lista
	                    return;
	                }
	            }
	            actual = actual.next;
	        } while (actual != this.first);

	        // Si el elemento no se ha insertado en el bucle, agregarlo al final
	        nuevo.next = this.first;
	        nuevo.prev = this.first.prev;
	        this.first.prev.next = nuevo;
	        this.first.prev = nuevo;
	        this.count++; // Incrementar el contador de elementos en la lista
	    }
	}





	public void merge(DoubleLinkedList<T> lista){
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE


	}

	


}
