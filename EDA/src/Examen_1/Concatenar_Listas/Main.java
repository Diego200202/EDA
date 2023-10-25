package Examen_1.Concatenar_Listas;

public class Main {
	public static void main(String[] argss) {
		DoubleCircularLinkedList<String> l1 = new DoubleCircularLinkedList<String>();
		DoubleCircularLinkedList<String> l2 = new DoubleCircularLinkedList<String>();
		
		System.out.println("=====Caso 1: Ambas listas vacias=====");
		System.out.println("Primera lista:");
		l1.imprimirLista();
		System.out.println("Segunda lista:");
		l2.imprimirLista();
		
		System.out.println("Listas concatenadas");
		l1.concatenarListas(l2);
		
		l1.reset();
		l2.reset();
		
		System.out.println("=====Caso 2: Segunda lista vacia=====");
		l1.anadirNodoFinal("Diego");
		l1.anadirNodoFinal("Peio");
		l1.anadirNodoFinal("Unai");
		
		System.out.println("Primera lista:");
		l1.imprimirLista();
		System.out.println("Segunda lista:");
		l2.imprimirLista();
		
		System.out.println("Listas concatenadas");
		l1.concatenarListas(l2);
		
		l1.reset();
		l2.reset();
		
		System.out.println("=====Caso 3: Primera lista vacia=====");
		l2.anadirNodoFinal("Ander");
		l2.anadirNodoFinal("Jon");
		l2.anadirNodoFinal("Amaia");
		
		System.out.println("Primera lista:");
		l1.imprimirLista();
		System.out.println("Segunda lista:");
		l2.imprimirLista();
		
		System.out.println("Listas concatenadas");
		l1.concatenarListas(l2);
		
		l1.reset();
		l2.reset();
		
		System.out.println("=====Caso 4: Ambas listas con datos=====");
		l1.anadirNodoFinal("Diego");
		l1.anadirNodoFinal("Peio");
		l1.anadirNodoFinal("Unai");
		
		System.out.println("Primera lista:");
		l1.imprimirLista();
		
		l2.anadirNodoFinal("Paula");
		l2.anadirNodoFinal("Cristina");
		l2.anadirNodoFinal("Pedro");
		
		System.out.println("Segunda lista:");
		l2.imprimirLista();
		
		System.out.println("Listas concatenadas");
		l1.concatenarListas(l2);
	}
}
