package Examen_1.Fusionar_Secuencias;

public class DoubleCircularLinkedList<T> {

	DoubleNode<String> first;
	
	public void reset() {
		this.first = null;
	}
	
	public void anadirNodo(String pData) {
		DoubleNode<String> actual;
		
		if(this.first == null) {
			this.first = new DoubleNode<String>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			actual = this.first.prev;
			actual.next = new DoubleNode<String>(pData);
			actual.next.next = this.first;
			actual.next.prev = actual;
			this.first.prev = actual.next;
		}
	}
	
	public void imprimirLista() {
		if(this.first == null) {
			System.out.println("La lista esta vacia");
		}else {
			DoubleNode<String> actual = this.first;
			while(!actual.equals(this.first.prev)) {
				System.out.print(actual.data + " , ");
				actual = actual.next;
			}
			System.out.println(actual.data + ".\n");
		}
	}
	
	public void fusionarSecuencias(String[] s1, String[] s2) {
		if(s1.length == 0 && s2.length == 0) {
			this.first = null;
		}else if(s1.length != 0 && s2.length == 0){
			for(String s : s1) {
				anadirNodo(s);
			}
		}else if(s1.length == 0 && s2.length != 0) {
			for(String s : s2) {
				anadirNodo(s);
			}
		}else {
			int i = 0, j = 0;
			while(i!=s1.length || j!=s2.length) {
				if(i!=s1.length && j!=s2.length) {
					if (s1[i].compareTo(s2[j])<0){
                        anadirNodo(s1[i]);
                        i++;
                    } else {
                        anadirNodo(s2[j]);
                        j++;
                    }			
				}
				
				if(i == s1.length) {
					anadirNodo(s2[j]);
					j++;
				}else if(j == s2.length) {
					anadirNodo(s1[i]);
					i++;
				}
			}
		}		
	}
}
