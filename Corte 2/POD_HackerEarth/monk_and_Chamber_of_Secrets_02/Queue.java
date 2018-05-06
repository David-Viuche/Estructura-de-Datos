package monk_2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/*@author David Viuche 
 * NRC: 6285
 * 
 * Input: 
 * 6 5
 * 1 2 2 3 4 5
 * 
 * Output: 5 6 4 1 2 
 * */

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

	

//	public Node mayor() {
//		Queue queue = new Queue();
//		queue.head = head;
//		Node mayor = queue.head.clone();
//		Node temp;
//		int n = queue.QueueSize();
//
//		for (int i = 0; i < n; i++) {
//
//			temp = queue.dequeue().clone();
//			if (temp.power > mayor.power)
//				mayor = temp;
//
//		}
//
//		return mayor;
//	}

//	public int getIndex(int initialPower) {
//		Queue queue = new Queue();
//		queue.head = head;
//
//		int n = queue.QueueSize(), index = 0;
//
//		for (int i = 1; i <= n; i++) {
//
//			if (queue.dequeue().initialPower == initialPower) {
//				index = i;
//				break;
//			}
//		}
//
//		return index;
//	}
}
