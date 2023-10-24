package Examen_1.Borrar_SubLista;

public class Main {
	public static void main(String[] args)
    {
        DoubleLinkedList<String> l1=new DoubleLinkedList<String>();
        DoubleLinkedList<String> l2=new DoubleLinkedList<>();

        System.out.println("===Listas Vacias===");
        System.out.println("Lista 1");l1.imprimirLista();
        System.out.println("Lista 2");l2.imprimirLista();

        l2.borrarSublista(l1);

        System.out.println("Resultado");l2.imprimirLista();

        l1.reset();l2.reset();

        System.out.println("===BORRAR SUBLISTA VACIA===");
        l2.anadirNodo("ana");l2.anadirNodo("jon");l2.anadirNodo("amaia");l2.anadirNodo("luis");l2.anadirNodo("ander");

        System.out.println("Lista 1");l1.imprimirLista();
        System.out.println("Lista 2");l2.imprimirLista();

        l2.borrarSublista(l1);

        System.out.println("Resultado");l2.imprimirLista();

        l1.reset();l2.reset();

        System.out.println("===BORRAR POR EL MEDIO===");
        l1.anadirNodo("jon");l1.anadirNodo("amaia");l1.anadirNodo("luis");
        l2.anadirNodo("ana");l2.anadirNodo("jon");l2.anadirNodo("amaia");l2.anadirNodo("luis");l2.anadirNodo("ander");

        System.out.println("Lista 1");l1.imprimirLista();
        System.out.println("Lista 2");l2.imprimirLista();

        l2.borrarSublista(l1);

        System.out.println("Resultado");l2.imprimirLista();

        l1.reset();l2.reset();

        System.out.println("\n===BORRAR EL PRIMERO===");//BORRAR EL PRIMERO
        l1.anadirNodo("ana");l1.anadirNodo("jon");l1.anadirNodo("amaia");
        l2.anadirNodo("ana");l2.anadirNodo("jon");l2.anadirNodo("amaia");l2.anadirNodo("luis");l2.anadirNodo("ander");

        System.out.println("Lista 1");l1.imprimirLista();
        System.out.println("Lista 2");l2.imprimirLista();

        l2.borrarSublista(l1);

        System.out.println("Resultado");l2.imprimirLista();

        l1.reset();l2.reset();

        System.out.println("\n===BORRAR EL ULTIMO===");//BORRAR EL ULTIMO
        l1.anadirNodo("amaia");l1.anadirNodo("luis");l1.anadirNodo("ander");
        l2.anadirNodo("ana");l2.anadirNodo("jon");l2.anadirNodo("amaia");l2.anadirNodo("luis");l2.anadirNodo("ander");

        System.out.println("Lista 1");l1.imprimirLista();
        System.out.println("Lista 2");l2.imprimirLista();

        l2.borrarSublista(l1);

        System.out.println("Resultado");l2.imprimirLista();

        l1.reset();l2.reset();

        System.out.println("\n===BORRAR TODOS===");//BORRAR EL ULTIMO
        l1.anadirNodo("ana");l1.anadirNodo("jon");l1.anadirNodo("amaia");l1.anadirNodo("luis");l1.anadirNodo("ander");
        l2.anadirNodo("ana");l2.anadirNodo("jon");l2.anadirNodo("amaia");l2.anadirNodo("luis");l2.anadirNodo("ander");

        System.out.println("Lista 1");l1.imprimirLista();
        System.out.println("Lista 2");l2.imprimirLista();

        l2.borrarSublista(l1);

        System.out.println("Resultado");l2.imprimirLista();

        l1.reset();l2.reset();


        System.out.println("\n===OTROS===");
        l1.anadirNodo("8");l1.anadirNodo("1");l1.anadirNodo("2");
        l2.anadirNodo("1");l2.anadirNodo("2");l2.anadirNodo("3");l2.anadirNodo("4");l2.anadirNodo("5");l2.anadirNodo("6");l2.anadirNodo("7");l2.anadirNodo("8");

        System.out.println("Lista 1");l1.imprimirLista();
        System.out.println("Lista 2");l2.imprimirLista();

        l2.borrarSublista(l1);

        System.out.println("Resultado");l2.imprimirLista();
    }
}
