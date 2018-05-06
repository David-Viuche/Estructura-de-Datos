package monk_and_Philosophers_Stone_01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*@author David Viuche 
 * NRC: 6285
 
 * */

public class Stack {

	Node head = null; // Empty List

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public void push(Node newNode) {
		newNode.next = head;
		head = newNode;
	}

	public Node pop() {

		Node temp = head;
		head = head.next;

		return temp;

	}


	public int StackSize() {
		Node temp = head;
		int counter = 1;
		while (temp.next != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}

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
