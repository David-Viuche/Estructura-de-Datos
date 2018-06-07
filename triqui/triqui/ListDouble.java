package triqui;


import java.io.*;

public class ListDouble {

	NodeDouble head = null; // Empty List

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public void insertAtBegin(NodeDouble newNodeDouble) {
		newNodeDouble.next = head;
		head = newNodeDouble;
	}

	public void insertAtEnd(NodeDouble newNodeDouble) {

		if (isEmpty()) {
			head = newNodeDouble;
		} else {
			NodeDouble temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = newNodeDouble;
		}
	}

	public void deleteAtBegin() {

		NodeDouble temp = head;
		head = head.next;
		temp = null;
		System.gc();

	}

	public void deleteAtEnd() {

		NodeDouble temp = head;
		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;
		System.gc();
	}


	public int listSize() {
		NodeDouble temp = head;
		int counter = 0;
		while (temp.next != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}

	public NodeDouble getNodeDouble(int index) {

		if (listSize() < index)
			return null;
		else {
			NodeDouble pre = head;
			for (int i = 0; i < index; i++)
				pre = pre.next;
			return pre;
		}
	}



	public void printlnList() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		NodeDouble temp = head;
		while (temp != null) {
			
			bw.write(temp.toString());
			bw.write("\n");
			temp = temp.next;
		}
		bw.write("\n\n");
		bw.flush();
		
	}

	

}

