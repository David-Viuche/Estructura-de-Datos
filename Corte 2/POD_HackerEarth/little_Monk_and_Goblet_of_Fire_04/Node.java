package little_Monk_and_Goblet_of_Fire_04;

public class Node {

	// Student
	public int school;
	public int number;

	public Node next; // Pointer

	public Node() {}

	public Node(int school, int number) {

		this.school = school;
		this.number = number;

	}

	public String toString() {
		return " "+String.valueOf(school)+" - "+String.valueOf(number);
	}

	public Node clone() {
		Node clone = new Node(this.school, this.number);
		return clone;
	}
	
	

}
