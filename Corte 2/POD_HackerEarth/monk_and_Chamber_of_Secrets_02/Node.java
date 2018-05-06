package monk_2;

public class Node {

	// Student
	public int power;
	public int index;

	public Node next; // Pointer

	public Node() {}

	public Node(int power, int index) {

		this.power = power;
		this.index = index;

	}

	public String toString() {
		return String.valueOf(power)+" i: "+String.valueOf(index)+" ";
	}

	public Node clone() {
		Node clone = new Node(this.power, this.index);
		return clone;
	}
	
	

}
