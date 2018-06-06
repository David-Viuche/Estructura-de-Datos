package lineales;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ListaCircular {
	
	Node head = null;/// Nodo principal de la lista
	
	// metodo que verifica si la lsta esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}

	// metodo que inserta un nuevo nodo en la lista en la parte de inicial
	public void insertAtBegin(Node newNode) {
		
		if(isEmpty()) {
			head = newNode.clone();
			head.next = head;
		}else {
		
		newNode.next = head;
		
		Node temp = head;
		while (temp.next != head)
			temp = temp.next;
		
		temp.next = newNode;
		newNode.next = head;
		head = temp;
		
		}
	}

	// metodo que inserta un nodo al final de la lista
	public void insertAtEnd(Node newNode) {

		if (isEmpty()) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != head)
				temp = temp.next;

			newNode.next = temp.next;
			temp.next = newNode;
		}
	}
	
	// metodo que inserta un nodo en el indice especificado
	public void insertAtIndex(Node newNode, int index) {

		Node temp;
		Node pre = head;

		for (int i = 0; i < index - 1; i++)
			pre.next = pre;

		temp = pre.next;
		newNode.next = temp;
		pre.next = newNode;

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
		pre.next = del.next;
		del = null;
		System.gc();
		 }
	}
	
	// metodo que eliminia un nodo del principio de la lista
	public void deleteAtBegin() {

		Node temp = head;
		while (temp.next != head)
			temp = temp.next;
		
		head = temp.next;
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
	
	//metodo que imprime la lista por consola
	public void printList() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Node temp = head;
		while (temp.next != head) {
			bw.write(temp.toString());
			temp = temp.next;
		}
		bw.write("\n\n");
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		ListaCircular students = new ListaCircular();

		students.insertAtBegin(new Node("Pedro", 22, 123456));
		students.insertAtBegin(new Node("Juan", 25, 65498));
		students.insertAtBegin(new Node("Paula", 26, 251368));
		students.insertAtIndex((new Node("maria", 27, 251368)), 1);

		students.insertAtEnd(new Node("Pepe", 20, 323143));

		students.printList();

	}

}
