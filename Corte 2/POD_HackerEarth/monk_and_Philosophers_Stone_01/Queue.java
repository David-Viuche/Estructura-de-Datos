package monk_and_Philosophers_Stone_01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;



public class Queue {

	Node head = null; // Empty List

	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
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
	
	public Node dequeue() {

		Node temp = head;
		head = temp.next;

		return temp;
	}

	
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
