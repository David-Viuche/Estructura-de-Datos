package all_Discs_Considered_07;

import java.io.*;
/*@author David Viuche 
 * NRC: 6285
 * 
 * 
 * */

public class List {

	Node head = null; // nodo principal de la lista

	//metodo para verificar si la lista esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}

	//metodo que inserta un nodo en la lista por la parte inicial de la lista
	public void insertAtBegin(Node newNode) {
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	//metodo que inserta un nodo en la lista por la parte final de la lista
	public void insertAtEnd(Node newNode) {

		if (isEmpty()) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = newNode;
		}
	}

	//metodo que elimina un nodo de la parte inicial de la lista
	public void deleteAtBegin() {

		Node temp = head;
		head = head.next;
		temp = null;
		System.gc();

	}

	//metodo que elimina un nodo de la parte final de la lista
	public void deleteAtEnd() {

		Node temp = head;
		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;
		System.gc();
	}

	//metodo que inserta en el indice especificado un nodo
	public void insertAtIndex(Node newNode, int index) {

		Node temp;
		Node pre = head;

		for (int i = 0; i < index - 1; i++)
			pre.next = pre;

		temp = pre.next;
		newNode.next = temp;

	}

	//metodo que elimina en el indice especificado un nodo
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

	//metodo que retorna el tamaño de la lista 
	public int listSize() {
		if (isEmpty()) {
			return 0;
		} else {
			Node temp = head;
			int counter = 1;
			while (temp.next != null) {
				temp = temp.next;
				counter++;
			}
			return counter;
		}
	}

	//metodo que retorna el nodo en el indice especeficado
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


//metodo que imprime la lista por consola 
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
	
	//metodo que verifica si un nodo ya esta en la lista
	public boolean isOn(int valor) {
		boolean flag = false;
		
		Node temp = head;
		Node result = null;
		
		while(temp != null){
			if(temp.valor == valor) {
				flag = true;
			}
			temp = temp.next;
		}
		
		return flag;
	}
	

}
