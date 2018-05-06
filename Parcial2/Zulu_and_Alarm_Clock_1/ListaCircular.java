package Zulu_and_Alarm_Clock_1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
/*@author David Viuche 
 * NRC: 6285
 * Date: 04-05-2018
 */
public class ListaCircular {

	//cabeza de la lista
	Node head = null;// Empty List

	//metodo que retorna si la lista esta vacia true de lo contrario retorna false
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
	//metodo que retorna la menor distancia entre dos nodos
	public int returnDistance(Node n1,Node n2) {
		Node temp = n1;
		int counter1 = 1;
		
		while(temp.next != n2) {
			temp = temp.next;
			counter1++;
		}
		
		Node temp2 = n2;
		int counter2 = 1;
		
		while(temp2.next != n1) {
			temp2 = temp2.next;
			counter2++;
		}
		
		if(counter1 == 60 || counter2 == 60 || counter1 == 24 || counter2 == 24) {
			counter1 = 0;
			counter2 = 0;
		}
		
		if(counter1 < counter2) {
			return counter1;
		}else {
			return counter2;
		}
	}

	//metodo que inserta un nuevo nodo a la lista en el inicio 
	public void insertAtBegin(Node newNode) {

		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
		} else {
			Node temp = head;
			while (temp.next != head)
				temp = temp.next;

			newNode.next = head;
			head = newNode;
			temp.next = head;
		}
	}

	//metodo que inserta un nuevo nodo a la lista en el final
	public void insertAtEnd(Node newNode) {
		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
		} else {
			Node temp = head;
			while (temp.next != head)
				temp = temp.next;

			temp.next = newNode;
			newNode.next = head;
		}
	}

	//metodo que retorna el tamaño de la lista
	public int sizeList() {
		int counter = 1;

		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
			counter += 1;
		}
		return counter;
	}

	//metodo que inserta un nuevo nodo a la lista en el indice indicado como parametro
	public void insertAtIndex (Node newNode, int index)
	{
		Node temp;
		Node pre = head;
		
		for(int i = 0; i < index-1; i++)
			pre.next = pre;
		
		temp = pre.next;
		newNode.next = temp;
		pre.next = newNode;
	
	}

	//metodo que elimina el nodo que se encuentra en el indice indicado como parametro
	public void deleteAtIndex(int index) {

		Node pre = head, del;

		// if (index == 0) {
		// deleteAtBegin();
		// } else {

		for (int i = 0; i < index - 1; i++)
			pre = pre.next;

		del = pre.next;
		pre.next = del.next;
		del = null;
		System.gc();
		// }
	}

	//metodo que elimina el nodo que se encuentra en el inicio de la lista
	public void deleteAtBegin() {

		Node temp = head;
		while (temp.next != head)
			temp = temp.next;

		head = temp.next;
		temp = null;
		System.gc();

	}

	//metodo que elimina el nodo que se encuentra en el final de la lista
	public void deleteAtEnd() {

		Node temp = head;
		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;
		System.gc();
	}

	//metodo que retorna el nodo que se encuentra en el indice indicado como parametro
	public Node getNode(int index) throws IOException {

		if (sizeList() < index)
			return null;
		else {
			Node temp = head;
			for (int i = 0; i < index; i++)
				temp = temp.next;

			return temp;
		}

	}

	//metodo que imprime por pantalla la lista
	public void printList() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Node temp = head;
		do {

			bw.write(temp.toString());
			temp = temp.next;

		} while (temp.next != head);

		bw.write("\n\n");
		bw.flush();
	}

}
