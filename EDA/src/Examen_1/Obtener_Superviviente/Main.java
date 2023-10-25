package Examen_1.Obtener_Superviviente;

public class Main {
	
	public static void main(String[] args) {
		DoubleCircularLinkedList<String> l1 = new DoubleCircularLinkedList<String>();
		l1.anadirNodo("Ana");
		l1.anadirNodo("Ander");
		l1.anadirNodo("Luis");
		l1.anadirNodo("Amaia");
		l1.anadirNodo("Jon");
		System.out.println(l1.obtenerSuperviviente(3));
	}
}
