package Examen_1.Ontener_Lista_Simetrica;

public class DoubleNode<T> {
	T data;
	DoubleNode<T> next;
	DoubleNode<T> prev;
	
	public DoubleNode(T pData) {
		this.data = pData;
	}
}
