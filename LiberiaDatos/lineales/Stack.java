package lineales;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Stack {

	Node head = null; // nodo principal de la Pila

	//metodo para verificar si la pila esta vacia
	public boolean isEmpty() {
		return head == null ? true : false;
	}

	//metodo para insertar en la parte superior de la pila
	public void push(Node newNode) {
		newNode.next = head;
		head = newNode;
	}

	//metodo para eliminar de la parte suerior de la pila
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

	public static void main(String[] args) {

		Stack stundets = new Stack();

		stundets.push(new Node("inicio", 23, 2313135));
		stundets.push(new Node("segundo", 21, 2313135));
		stundets.push(new Node("tercero", 22, 2313135));
		
		System.out.println();

	}

}
