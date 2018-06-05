package monk_and_Philosophers_Stone_01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * Author: David viuche
 * 
 * implementacion de una fila 
 * */


public class Queue {

	Node head = null; // Nodo principal de la Fila

	//funcion para saber si la fila esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
	//funcion enfilar en el ultimo nodo
	public void enqueue(Node newNode) {
		if (isEmpty()) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = newNode;
		}
	}
	
	//funcion desenfilar del principio de la fila 
	public Node dequeue() {

		Node temp = head;
		head = temp.next;

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
