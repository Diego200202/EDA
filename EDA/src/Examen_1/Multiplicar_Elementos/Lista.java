package Examen_1.Multiplicar_Elementos;

public class Lista<T> {
	Node<T> first;
	
	public void anadirNodo(T pData) {
		Node<T> actual = this.first;
		
		if(this.first == null) {
			this.first = new Node<T>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			actual = this.first.prev;
			
			actual.next = new Node<T>(pData);
			actual.next.next = this.first;
			actual.next.prev = actual;
			this.first.prev = actual.next;
		}
	}
	
	public void reset() {
		this.first = null;
	}
	
	public void imprimirLista() {
		Node<T> actual = this.first;
		if(this.first == null) {
			System.out.println("La lista esta vacia");
		}else {
			while(actual.next != this.first) {
				System.out.print(actual.data + " , ");
				actual = actual.next;
			}
			System.out.println(actual.data +".\n");
		}
	}
	
	public void multiplicar(Integer pNum) {
		Node<T> actual=first;
        Node<T> previo=first;
        Node<T> pFirst=null;
        Node<T> pActual=null;

        while(actual.next!=first)
        {
            previo=actual;
            actual=actual.next;
            for(int i=1; i<pNum;i++)
            {
                if(i==1)
                {
                    pFirst = new Node<>(previo.data);
                    pFirst.prev = pFirst;
                    pFirst.next = pFirst;
                }
                else
                {
                    pActual=pFirst.prev;

                    pActual.next=new Node<>(previo.data);
                    pActual.next.next=pFirst;
                    pActual.next.prev=pActual;
                    pFirst.prev=pActual.next;
                }
            }
            previo.next=pFirst;
            actual.prev=pFirst.prev;
            pFirst.prev.next=actual;
            pFirst.prev=previo;
        }
        previo=actual;
        actual=actual.next;
        for(int i=1; i<pNum;i++)
        {
            if(i==1)
            {
                pFirst = new Node<>(previo.data);
                pFirst.prev = pFirst;
                pFirst.next = pFirst;
            }
            else
            {
                pActual=pFirst.prev;

                pActual.next=new Node<>(previo.data);
                pActual.next.next=pFirst;
                pActual.next.prev=pActual;
                pFirst.prev=pActual.next;
            }
        }
        previo.next=pFirst;
        actual.prev=pFirst.prev;
        pFirst.prev.next=actual;
        pFirst.prev=previo;
	}
}
