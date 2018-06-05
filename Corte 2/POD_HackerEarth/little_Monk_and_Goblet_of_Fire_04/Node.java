package little_Monk_and_Goblet_of_Fire_04;

public class Node {

	// valores del nodo
	public int school;
	public int number;

	public Node next; // apuntador del nodo siguiente

	// constructores
	public Node() {
	}

	public Node(int school, int number) {

		this.school = school;
		this.number = number;

	}

	//metodo que retorna un dato de Tipo String con el valor del nodo
	public String toString() {
		return " " + String.valueOf(school) + " - " + String.valueOf(number);
	}

	//metodo que retorna el clon del nodo actual
	public Node clone() {
		Node clone = new Node(this.school, this.number);
		return clone;
	}

}
