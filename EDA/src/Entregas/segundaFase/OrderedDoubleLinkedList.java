package Entregas.segundaFase;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	@Override
	public void add(T elem) {
	    Node<T> nuevo = new Node<T>(elem); // Crear un nuevo nodo con el elemento a agregar

	    if (this.isEmpty()) { // Si la lista está vacía, simplemente agregamos el nuevo elemento
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

	@Override
	public void merge(DoubleLinkedList<T> lista) {
	    if (this.isEmpty() && lista.isEmpty()) {
	    	
	    } else if (!this.isEmpty() && lista.isEmpty()) {
	    	// No se necesita hacer nada si la lista "lista" está vacía
	    } else if (this.isEmpty() && !lista.isEmpty()) {
	        // Si la lista actual está vacía, simplemente asignamos la lista "lista" a la lista actual
	        this.first = lista.first;
	        this.count = lista.count;
	    } else {
	    	Node<T> actual = lista.first;
	    	while (actual.next != lista.first) {
	    		this.add(actual.data); // Utilizamos el método add para agregar elementos a la lista actual
	    		actual = actual.next;
	    	}
	    	this.add(actual.data);
	    }
	}
	
	public void reset() {
		this.first = null;
		this.count = 0;
	}
}
