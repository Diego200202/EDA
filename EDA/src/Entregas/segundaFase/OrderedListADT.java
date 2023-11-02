package Entregas.segundaFase;

public interface OrderedListADT<T>  extends ListADT<T> {
	
	public void add(T elem);
	// Añade un elemento a la lista (en el lugar de orden que le corresponde)

	public void merge(DoubleLinkedList<T> zerrenda);

}
