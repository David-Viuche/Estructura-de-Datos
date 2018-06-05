package monk_and_Prisoner_of_Azkaban_03;

import java.io.*;

/*@author David Viuche 
 * NRC: 6285
 * 
 * Input: 
 * 5
 * 5 4 1 3 2
 * 
 * Output: -2 0 6 1 3 
 * */

public class ListDoble {

	Node head = null; //nodo principal de la lista

	//funcion que verifica si la lista esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}

	//funcion que inserta un nodo al principio de la lista
	public void insertAtBegin(Node newNode) {
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head.back = newNode;
			head = newNode;
		}
	}

	//funcion que inserta un nodo al final de la lista
	public void insertAtEnd(Node newNode) {

		if (isEmpty()) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = newNode;
			newNode.back = temp;
		}
	}

	//funcion que elimina un nodo al principio de la lista
	public void deleteAtBegin() {

		Node temp = head;
		head = head.next;
		head.back = null;
		temp = null;
		System.gc();

	}

	//funcion que elimina un nodo al final de la lista
	public void deleteAtEnd() {

		Node temp = head;
		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;
		System.gc();
	}

	//funcion que inserta un nodo en el indice especificado
	public void insertAtIndex(Node newNode, int index) {
		if (index == 0) {
			insertAtBegin(newNode);
		} else {

			Node temp;
			Node pre = head;

			for (int i = 0; i < index - 1; i++)
				pre = pre.next;

			temp = pre.next;
			newNode.next = temp;
			temp.back = newNode;
			pre.next = newNode;
			newNode.back = pre;

		}
	}

	//funcion que elimina un nodo en el indice especificado
	public void deleteAtIndex(int index) {

		Node pre = head, del;

		if (index == 0) {

			deleteAtBegin();

		} else {

			for (int i = 0; i < index - 1; i++)
				pre = pre.next;

			del = pre.next;

			if (del.next == null) {

				deleteAtEnd();

			} else {

				pre.next = del.next;
				del.next.back = pre;
				del = null;
				System.gc();

			}
		}
	}

	//funcion que retorna el tamaño de la lista
	public int listSize() {
		Node temp = head;
		int counter = 0;
		while (temp.next != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}

	//funcion que retorna el nodo en el indice especificado
	public Node getNode(int index) {

		if (listSize() < index)
			return null;
		else {
			Node pre = head;
			for (int i = 0; i < index; i++)
				pre = pre.next;
			return pre;
		}
	}

	//funcion que imprime por consola la lista por consola 
	public void printList() throws IOException {
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
