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

	Node head = null; // Empty List

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public void insertAtBegin(Node newNode) {
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head.back = newNode;
			head = newNode;
		}
	}

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

	public void deleteAtBegin() {

		Node temp = head;
		head = head.next;
		head.back = null;
		temp = null;
		System.gc();

	}

	public void deleteAtEnd() {

		Node temp = head;
		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;
		System.gc();
	}

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
