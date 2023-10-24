package Examen_1.Obtener_Lista_Simetrica;

public class Main {
	public static void main(String[] args) {
		SimpleLinkedList<Integer> l = new SimpleLinkedList<Integer>();
		l.anadirNodo(8);
		l.anadirNodo(3);
		l.anadirNodo(4);
		l.anadirNodo(1);
		
		System.out.println("Lista simple:");
		l.imprimirLista();
		
		DoubleCircularLinkedList<Integer> l2 = new DoubleCircularLinkedList<Integer>();
		l2.obtenerListaSimetrica(l);
		l2.imprimirLista();
	}
}
