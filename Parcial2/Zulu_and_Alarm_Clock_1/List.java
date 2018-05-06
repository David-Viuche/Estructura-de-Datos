package Zulu_and_Alarm_Clock_1;

import java.io.*;
/*@author David Viuche 
 * NRC: 6285
 * 
 *
 * */

public class List {

	Node head = null; // Empty List

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public void insertAtBegin(Node newNode) {
		if (isEmpty()) {
			head = newNode;
		} else {
		newNode.next = head;
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
		}
	}

	public void deleteAtBegin() {

		Node temp = head;
		head = head.next;
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

		Node temp;
		Node pre = head;

		for (int i = 0; i < index - 1; i++)
			pre.next = pre;

		temp = pre.next;
		newNode.next = temp;

	}

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

//	public int returnIndex(Node nodo) {
//		Node temp = head;
//		int index = 0;
//		while (temp.school != nodo.school) {
//
//			index++;
//			temp = temp.next;
//		}
//		return index;
//	}

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
