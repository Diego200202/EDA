package Examen_1.Reemplazar_Por_Secuencias;

public class Main {
	 public static void main(String[] args)
	    {
	        DoubleLinkedList<Object> l=new DoubleLinkedList<Object>();
	        l.anadirEnOrden("ama");
	        l.anadirEnOrden("col");
	        l.anadirEnOrden("mar");
	        l.anadirEnOrden("rio");
	        l.anadirEnOrden("zar");

	        l.imprimirLista();

	        Pareja[] parejas=new Pareja[3];

	        String[] s1=new String[3];
	        s1[0]="cola";s1[1]="colar";s1[2]="color";
	        Pareja p1=new Pareja("col",s1);
	        parejas[0]=p1;

	        String[] s2=new String[3];
	        s2[0]="mara";s2[1]="marte";s2[2]="marzo";
	        Pareja p2=new Pareja("mar",s2);
	        parejas[1]=p2;

	        String[] s3=new String[2];
	        s3[0]="zara";s3[1]="zarza";
	        Pareja p3=new Pareja("zar",s3);
	        parejas[2]=p3;

	        l.reemplazar(parejas);
	        l.imprimirLista();
	    }
}
