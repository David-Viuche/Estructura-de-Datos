package little_Monk_and_Goblet_of_Fire_04;

import java.io.*;
/*@author David Viuche 
 * NRC: 6285
 * 
 * 
 * */

public class List {

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
		head = newNode;
		}
	}
	
//	public int checkSchool(int num) {
//		int ret = -1;
//		
//		Node temp = head;
//		while (temp.next != null) {
//			temp = temp.next;
//			if(temp.school==num)
//				ret = 1;
//		}
//		
//		return ret;
//	}
	
//	public void insert(Node newNode) {
//		if (isEmpty()) {
//			head = newNode;
//		} else {
//			if(checkSchool(newNode.school)==-1) {
//				insertAtEnd(newNode);
//			}else {
//			
//			Node temp = head;
//			while (temp.school != newNode.school)
//				temp = temp.next;
//			
//			insertAtIndex(newNode, (returnIndex(temp)+1));
//			}
//		}
//	}

	//funcion que inserta un nodo al final de la lista
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

	//funcion que elimina un nodo al principio de la lista
	public void deleteAtBegin() {

		Node temp = head;
		head = head.next;
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

		Node temp;
		Node pre = head;

		for (int i = 0; i < index - 1; i++)
			pre.next = pre;

		temp = pre.next;
		newNode.next = temp;

	}

	//funcion que elimina un nodo en el indice especificado
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

	public int listSize() {
		Node temp = head;
		int counter = 0;
		while (temp.next != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}

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

	public int returnIndex(Node nodo) {
		Node temp = head;
		int index = 0;
		while (temp.school != nodo.school) {

			index++;
			temp = temp.next;
		}
		return index;
	}

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
	
//	public Node pop() {
//		Node temp = head;
//		deleteAtIndex(0);
//		return temp;
//	}
	

	

}
