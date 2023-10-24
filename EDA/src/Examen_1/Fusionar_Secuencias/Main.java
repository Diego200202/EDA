package Examen_1.Fusionar_Secuencias;

public class Main {
	public static void main(String[] args)
    {
        DoubleCircularLinkedList<Object> l=new DoubleCircularLinkedList<Object>();
        String[] s1,s2;

        System.out.println("===TEST 1 - Listas Vacia===");
        s1 = new String[3];s2 = new String[0];

        l.fusionarSecuencias(s1,s2);
        l.imprimirLista();
        l.reset();

        System.out.println("===TEST 2 - Lista s2 vacia===");
        s1 = new String[3];s2 = new String[0];
        s1[0]="col";s1[1]="oir";s1[2]="pan";
        l.fusionarSecuencias(s1,s2);
        l.imprimirLista();
        l.reset();

        System.out.println("===TEST 2 - Lista s1 vacia===");
        s1 = new String[0];s2 = new String[5];
        s2[0]="ama";s2[1]="gas";s2[2]="mar";s2[3]="rio";s2[4]="zar";
        l.fusionarSecuencias(s1,s2);
        l.imprimirLista();
        l.reset();

        System.out.println("===TEST 3 - Lista s1 y s2===");
        s1 = new String[3];s2 = new String[5];
        s1[0]="col";s1[1]="oir";s1[2]="pan";
        s2[0]="ama";s2[1]="gas";s2[2]="mar";s2[3]="rio";s2[4]="zar";
        l.fusionarSecuencias(s1,s2);
        l.imprimirLista();
        l.reset();
    }
}
