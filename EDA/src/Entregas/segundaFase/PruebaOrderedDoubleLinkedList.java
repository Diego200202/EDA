package Entregas.segundaFase;

public class PruebaOrderedDoubleLinkedList {	
	
	public static <T> void main(String[] args)  {
		OrderedDoubleLinkedList<Integer> l = new OrderedDoubleLinkedList<Integer>();
		OrderedDoubleLinkedList<Integer> l2 = new OrderedDoubleLinkedList<Integer>();
		OrderedDoubleLinkedList<Persona> l3 = new OrderedDoubleLinkedList<Persona>();
		OrderedDoubleLinkedList<Persona> l4 = new OrderedDoubleLinkedList<Persona>();
		
		System.out.println("##### PRIMER CASO: AMBAS LISTAS ESTAN VACIAS #####\n");
		
		System.out.println("---Las listas contienen enteros---");
		System.out.println("\nLista 1 ............");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());
		
		System.out.println("\nLista 2 ............");
		l2.visualizarNodos();
		System.out.println(" Num elementos: " + l2.size());
		
		l.merge(l2);
		
		System.out.println("\nResultado de la fusion:");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());
		
		System.out.println("\n---Las listas contienen personas---");

		System.out.println("\nLista 3 ............");
		l3.visualizarNodos();
		System.out.println(" Num elementos: " + l3.size());
		
		System.out.println("\nLista 4 ............");
		l4.visualizarNodos();
		System.out.println(" Num elementos: " + l4.size());
		
		l3.merge(l4);
		
		System.out.println("\nResultado de la fusion:");
		l3.visualizarNodos();
		System.out.println(" Num elementos: " + l3.size());
		
		System.out.println("\nPrueba Find ...............");
		System.out.println("20? " + l.find(20));
		System.out.println("9? " + l.find(9));
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		System.out.println("2222? " + l3.find(new Persona("", "2222")));
		System.out.println("5555? " + l3.find(new Persona("", "5555")));
		System.out.println("7777? " + l3.find(new Persona("", "7777")));	
		System.out.println("8888? " + l3.find(new Persona("", "8888")));
		
		l.reset();
		l2.reset();
		l3.reset();
		l4.reset();
		
		System.out.println("\n##### SEGUNDO CASO: LA LISTA RECIBIDA ESTA VACIA #####\n");
		
		l.add(1);
		l.add(3);
		l.add(6);
		l.add(7);
		l.add(9);
		l.add(0);
		l.add(20);
		l.remove(new Integer(7));
		
		l3.add(new Persona("jon", "1111"));
		l3.add(new Persona("ana", "7777"));
		l3.add(new Persona("amaia", "3333"));
		l3.add(new Persona("unai", "8888"));
		l3.add(new Persona("pedro", "2222"));
		l3.add(new Persona("olatz", "5555"));
		l3.remove(new Persona("", "8888"));

		System.out.println("\n---Las listas contienen enteros---");
		
		System.out.println("Lista 1 ............");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());
		
		System.out.println("\nLista 2 ............");
		l2.visualizarNodos();
		System.out.println(" Num elementos: " + l2.size());
		
		l.merge(l2);
		
		System.out.println("\nResultado de la fusion:");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());

		System.out.println("\n---Las listas contienen personas---");
		
		System.out.println("\nLista 3 ............");
		l3.visualizarNodos();
		System.out.println(" Num elementos: " + l3.size());
		
		System.out.println("\nLista 4 ............");
		l4.visualizarNodos();
		System.out.println(" Num elementos: " + l4.size());
		
		l3.merge(l4);
		
		System.out.println("\nResultado de la fusion:");
		l3.visualizarNodos();
		System.out.println(" Num elementos: " + l3.size());
		
		System.out.println("\nPrueba Find ...............");
		System.out.println("20? " + l.find(20));
		System.out.println("9? " + l.find(9));
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		System.out.println("2222? " + l3.find(new Persona("", "2222")));
		System.out.println("5555? " + l3.find(new Persona("", "5555")));
		System.out.println("7777? " + l3.find(new Persona("", "7777")));	
		System.out.println("8888? " + l3.find(new Persona("", "8888")));
		
		l.reset();
		l2.reset();
		l3.reset();
		l4.reset();
		
		System.out.println("\n\n##### TERCER CASO: LA LISTA RECIBIDA NO ESTA VACIA PERO L AQUE TENEMOS SI#####");
		
		l2.add(9);
		l2.add(2);
		l2.add(4);
		l2.add(8);
		l2.add(5);
		
		l4.add(new Persona("aaron", "6666"));
		l4.add(new Persona("Zaira", "4444"));
		l4.add(new Persona("Maria", "9999"));

		System.out.println("\n---Las listas contienen enteros---");
		
		System.out.println("Lista 1 ............");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());
		
		System.out.println("\nLista 2 ............");
		l2.visualizarNodos();
		System.out.println(" Num elementos: " + l2.size());
		
		l.merge(l2);
		
		System.out.println("\nResultado de la fusion:");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());

		System.out.println("\n---Las listas contienen personas---");
		
		System.out.println("\nLista 3 ............");
		l3.visualizarNodos();
		System.out.println(" Num elementos: " + l3.size());
		
		System.out.println("\nLista 4 ............");
		l4.visualizarNodos();
		System.out.println(" Num elementos: " + l4.size());
		
		l3.merge(l4);
		
		System.out.println("\nResultado de la fusion:");
		l3.visualizarNodos();
		System.out.println(" Num elementos: " + l3.size());
		
		System.out.println("\nPrueba Find ...............");
		System.out.println("20? " + l.find(20));
		System.out.println("9? " + l.find(9));
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		System.out.println("2222? " + l3.find(new Persona("", "2222")));
		System.out.println("5555? " + l3.find(new Persona("", "5555")));
		System.out.println("7777? " + l3.find(new Persona("", "7777")));	
		System.out.println("8888? " + l3.find(new Persona("", "8888")));
		
		l.reset();
		l2.reset();
		l3.reset();
		l4.reset();
		
		System.out.println("\n\n##### CUARTO CASO: AMBAS LISTAS CONTIENEN ELEMENTOS#####");
		
		l.add(1);
		l.add(3);
		l.add(6);
		l.add(7);
		l.add(9);
		l.add(0);
		l.add(20);
		
		l2.add(2);
		l2.add(4);
		l2.add(8);
		l2.add(25);
		
		l3.add(new Persona("jon", "1111"));
		l3.add(new Persona("ana", "7777"));
		l3.add(new Persona("amaia", "3333"));
		l3.add(new Persona("unai", "8888"));
		l3.add(new Persona("pedro", "2222"));
		l3.add(new Persona("olatz", "5555"));
		l3.remove(new Persona("", "8888"));
		
		l4.add(new Persona("aaron", "6666"));
		l4.add(new Persona("Zaira", "4444"));
		l4.add(new Persona("Maria", "9999"));

		System.out.println("\n---Las listas contienen enteros---");
		
		System.out.println("Lista 1 ............");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());
		
		System.out.println("\nLista 2 ............");
		l2.visualizarNodos();
		System.out.println(" Num elementos: " + l2.size());
		
		l.merge(l2);
		
		System.out.println("\nResultado de la fusion:");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());

		System.out.println("\n---Las listas contienen personas---");
		
		System.out.println("\nLista 3 ............");
		l3.visualizarNodos();
		System.out.println(" Num elementos: " + l3.size());
		
		System.out.println("\nLista 4 ............");
		l4.visualizarNodos();
		System.out.println(" Num elementos: " + l4.size());
		
		l3.merge(l4);
		
		System.out.println("\nResultado de la fusion:");
		l3.visualizarNodos();
		System.out.println(" Num elementos: " + l3.size());
		
		System.out.println("\nPrueba Find ...............");
		System.out.println("20? " + l.find(20));
		System.out.println("9? " + l.find(9));
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		System.out.println("2222? " + l3.find(new Persona("", "2222")));
		System.out.println("5555? " + l3.find(new Persona("", "5555")));
		System.out.println("7777? " + l3.find(new Persona("", "7777")));	
		System.out.println("8888? " + l3.find(new Persona("", "8888")));
		
		l.reset();
		l2.reset();
		l3.reset();
		l4.reset();		
	}
}
