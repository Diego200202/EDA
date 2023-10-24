package Examen_1.Anadir_Despues;

public class Main {
	 public static void main(String[] args) {
	        DoubleLinkedList<String> l1=new DoubleLinkedList<String>();;

	        System.out.println("===Esta en medio de la lista===");
	        l1.anadirNodo("ana");l1.anadirNodo("jon");l1.anadirNodo("amaia");l1.anadirNodo("luis");;l1.anadirNodo("ander");
	        l1.imprimirLista();
	        l1.anadirDespues("peio","amaia");
	        l1.imprimirLista();

	        l1.reset();

	        System.out.println("===Esta al principio de la lista===");
	        l1.anadirNodo("ana");l1.anadirNodo("jon");l1.anadirNodo("amaia");l1.anadirNodo("luis");;l1.anadirNodo("ander");
	        l1.imprimirLista();
	        l1.anadirDespues("peio","ana");
	        l1.imprimirLista();

	        l1.reset();

	        System.out.println("===No esta en la lista===");
	        l1.anadirNodo("ana");l1.anadirNodo("jon");l1.anadirNodo("amaia");l1.anadirNodo("luis");;l1.anadirNodo("ander");
	        l1.imprimirLista();
	        l1.anadirDespues("peio","xabier");
	        l1.imprimirLista();
	    }
}
