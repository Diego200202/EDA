package Entregas.segundaFase;

import java.util.Iterator;

public class PruebaDoubleLinkedList {
	
	public static void visualizarNodos(UnorderedCircularDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
	
	
	public static void main(String[] args)  {
		
		UnorderedCircularDoubleLinkedList<Integer> l = new UnorderedCircularDoubleLinkedList<Integer>();
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(9);
		l.addToRear(0);
		l.addToRear(20);
		l.addToFront(8);
		l.addAfter(5, 9);
		l.removeFirst();
		l.removeLast();
		l.remove(new Integer(7));

		
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
				
		
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		
}
}
