package listadobles;

import java.io.*;

public class ListDoble {

	Node head = null; // Nodo principal de la lista

	// metodo que verifica si la lista esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}

	// metodo que inserta un nuevo nodo en la lista en la parte inicial
	public void insertAtBegin(Node newNode) {
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head.back = newNode;
			head = newNode;
		}
	}

	// metodo que inserta un nodo al final de la lista
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

	// metodo que eliminia un nodo del principio de la lista
	public void deleteAtBegin() {

		Node temp = head;
		head = head.next;
		head.back = null;
		temp = null;
		System.gc();

	}

	// metodo que eliminia un nodo del final de la lista
	public void deleteAtEnd() {

		Node temp = head;
		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;
		System.gc();
	}

	// metodo que inserta un nodo en el indice especificado
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

	// metodo que elimina un nodo en el indice especificado
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

	//metodo que retorna el tamaño de la lista
	public int listSize() {
		Node temp = head;
		int counter = 0;
		while (temp.next != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
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

	public static void main(String[] args) throws IOException {

		ListDoble students = new ListDoble();

		students.insertAtBegin(new Node("Pedro", 22, 123456));
		students.insertAtBegin(new Node("Juan", 25, 65498));
		students.insertAtBegin(new Node("Paula", 26, 251368));

		students.insertAtEnd(new Node("Pepe", 20, 323143));
		students.printList();
		System.out.println(students.listSize());
		students.insertAtIndex((new Node("maria", 27, 251368)), 3);
		students.printList();
		System.out.println(students.listSize());

		// students.deleteAtBegin();
		// students.deleteAtEnd();
		students.deleteAtIndex(4);

		students.printList();
		System.out.println(students.listSize());

	}

}
