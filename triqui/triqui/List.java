package triqui;
import java.io.*;


public class List {

	Node head = null; // Empty List

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public void insertAtBegin(Node newNode) {
		newNode.next = head;
		head = newNode;
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


	public int listSize() {
		Node temp = head;
		int counter = 1;
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

	//metodo que verifica si un nodo ya esta en la lista
		public boolean isOn(Node node) {
			boolean flag = false;
			
			Node temp = head;
			
			while(temp != null){
				if(temp.equals(node)) {
					flag = true;
				}
				temp = temp.next;
			}
			
			return flag;
		}

	public void printlnList() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Node temp = head;
		while (temp != null) {
			
			bw.write(temp.toString());
			bw.write("\n");
			temp = temp.next;
		}
		bw.write("\n\n");
		bw.flush();
		
	}

	public int returnIndex(Node nodo) {
		Node temp = head;
		int index = 0;
		while (temp !=  nodo ) {

			index++;
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		return index;
	}
	

}
