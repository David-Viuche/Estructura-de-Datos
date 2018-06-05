package monk_and_Philosophers_Stone_01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*@author David Viuche 
 * NRC: 6285
 
 implementacion de una Pila
 * */

public class Stack {

	Node head = null; // Nodo principal de la Pila

	//funcion para saber si la Pila esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}

	//funcion para ingresar un nodo en la parte superior de la pila
	public void push(Node newNode) {
		newNode.next = head;
		head = newNode;
	}

	//funcion eliminar de la parte superior de la pila
	public Node pop() {

		Node temp = head;
		head = head.next;

		return temp;

	}

	//funcion que retorna el largo de la Pila 
	public int StackSize() {
		Node temp = head;
		int counter = 1;
		while (temp.next != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}

	//funcion que imprime la Pila por consola
	public void printStack() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Node temp = head;
		while (temp != null) {
			bw.write(temp.toString());
			temp = temp.next;
		}
		bw.write("\n\n");
		bw.flush();
	}
}
