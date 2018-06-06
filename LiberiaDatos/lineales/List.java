package lineales;
import java.io.*;

public class List {

	Node head = null; // Nodo principal de la lista

	// metodo que verifica si la lsta esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}

	// metodo que inserta un nuevo nodo en la lista en la parte de arriba
	public void insertAtBegin(Node newNode) {
		newNode.next = head;
		head = newNode;

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
		}
	}

	// metodo que eliminia un nodo del principio de la lista
	public void deleteAtBegin() {

		Node temp = head;
		head = head.next;
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

		Node temp;
		Node pre = head;

		for (int i = 0; i < index - 1; i++)
			pre.next = pre;

		temp = pre.next;
		newNode.next = temp;

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

	//metodo que busca un nodo en la lista
	public int searchAtName(String name) {

		int index = 0;
		Node temp = head;
		int ind = -1;

		do {
			if (temp.name == name) {
				ind = index;
			}
			temp = temp.next;
			index++;

		} while (temp.next != null);

		return ind;
	}

	//metodo que actualiza el nodo indicado 
	public void updateAgeAtIndex(int age, int index) {

		Node pre = head;

		for (int i = 0; i <= index - 1; i++)
			pre = pre.next;

		pre.age = (age);

	}

//	public void ordenarLista() {
//
//		Node temp = head;
//		Node pre;
//		do {
//			pre = temp.next;
//			if (temp.age < pre.age) {
//
//				temp.next = pre;
//
//			}
//
//			temp = temp.next;
//		} while (temp.next != null);
//
//	}

	//metodo que invierte el orden de la lista
	public void reverse() {

		Stack tempList = new Stack();
		Node temp = head;

		while (temp != null) {

			tempList.push(temp.clone());
			temp = temp.next;

		}
		head = tempList.head;
	}

	/*
	 * public void quicksort() throws IOException { List leftset = new List(); List
	 * rightset = new List(); leftset.head = new Node(); rightset.head = new Node();
	 * 
	 * int right = 0; int left = 0;
	 * 
	 * Node temp = head; Node pivot = temp;
	 * 
	 * while (temp.next != null) { temp = temp.next; right++; }
	 * 
	 * while (left != right) { if (returnNodeAtIndex(right).getAge() >
	 * pivot.getAge()) { leftset.insertAtBegin(returnNodeAtIndex(right)); left++; }
	 * else { rightset.insertAtEnd(returnNodeAtIndex(right)); right--; }
	 * 
	 * if(returnNodeAtIndex(left).getAge() < pivot.getAge()) {
	 * rightset.insertAtEnd(returnNodeAtIndex(left)); right--; }else {
	 * leftset.insertAtBegin(returnNodeAtIndex(right)); left++; }
	 * 
	 * }
	 * 
	 * 
	 * leftset.printList(); rightset.printList();
	 * 
	 * // leftset.insertAtEnd(pivot); // leftset.insertAtEnd(rightset.head);
	 * 
	 * }
	 */

	//implementacion del ordenamiento quicksort con listas
	public void quicksort() throws IOException {

		if (!isEmpty()) {
			List leftset = new List();
			List rightset = new List();

			Node pivot = head;
			Node temp = head.next;

			while (temp != null) {

				if (temp.age < pivot.age) {
					leftset.insertAtEnd(temp.clone());
				} else {
					rightset.insertAtEnd(temp.clone());
				}
				temp = temp.next;
			}

			// System.out.println("---"+pivot.toString());
			//
			// leftset.printList();
			// rightset.printList();

			leftset.quicksort();
			rightset.quicksort();

			pivot.next = rightset.head;
			leftset.insertAtEnd(pivot);
			head = leftset.head;

		}
	}

	// public Node binarySearch() {
	// int max = listSize(), min =0;
	// int middle = (max - min)/2;
	// //overleaft
	// while() {
	//
	// }
	//
	// return null;
	// }

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

	//metodo que retorna el nodo en el indice especificado
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

	//metodo que retorna el indice del nodo especificado
	public int returnIndex(Node nodo) {
		Node temp = head;
		int index = 0;
		while (temp != nodo) {

			index++;
			temp = temp.next;
		}
		return index;
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

		List students = new List();

		students.insertAtBegin(new Node("Pedro", 22, 123456));
		students.insertAtBegin(new Node("Juan", 25, 65498));
		students.insertAtBegin(new Node("Paula", 26, 251368));
		students.insertAtIndex((new Node("maria", 27, 251368)), 1);

		students.insertAtEnd(new Node("Pepe", 20, 323143));

		students.printList();
		// System.out.println("\n reverse");
		// students.deleteAtBegin();
		// students.deleteAtEnd();

		// students.deleteAtIndex(4);

		// System.out.println(students.searchAtName("Paula"));

		// students.updateAgeAtIndex(30, 3);

		// students.reverse();
		System.out.println("----------");
		students.quicksort();

		// for (int j = students.listSize(); j >= 0; j--) {
		//
		// System.out.println(students.getNode(j).toString());
		//
		// }

		students.printList();

		System.out.println(esPrimo(1));

	}

	//metodo para saber si un nuemro es primo
	public static int esPrimo(int num) {
		int num2 = num - 1;

		while ((num % num2) != 0)
			num2--;

		if (num2 == 1)
			return 1;

		else
			return 0;

	}
}
