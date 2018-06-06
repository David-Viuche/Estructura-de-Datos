package lineales;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Queue {

	Node head = null; // nodo principal de la pila

	//metodo para verificar si la fila esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
	//metodo para enfilar un nodo
	public void enqueue(Node newNode) {

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = newNode;

	}
	
	//metodo para desenfilar un nodo
	public Node dequeue() {

		Node temp;
		Node pre = head;
		while (pre.next.next != null)
			pre = pre.next;

		temp = pre.next;
		pre.next = null;
		return temp;
	}
	
	//funcion que imprime la fila por consola
		public void printQueue() throws IOException {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			Node temp = head;
			while (temp != null) {
				bw.write(temp.toString() + " ");
				temp = temp.next;
			}
			bw.write("\n\n");
			bw.flush();
		}
		
		//funcion que retorna el largo de la fila 
		public int QueueSize() {
			Node temp = head;
			int counter = 1;
			while (temp.next != null) {
				temp = temp.next;
				counter++;
			}
			return counter;
		}

	

}
