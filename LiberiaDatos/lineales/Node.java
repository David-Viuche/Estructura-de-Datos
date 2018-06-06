package lineales;

public class Node {

	//datos del nodo
	public String name;
	public int age;
	public int id;

	public Node next; // apuntador del nodo siguiente

	//constructores
	public Node() {}

	public Node(String name, int age, int id) {

		this.name = name;
		this.age = age;
		this.id = id;

	}

	//metodo que retorna un dato de tipo String con el valor del nodo
	public String toString() {
		return "Name: " + this.name + "\t Age: " + this.age + "\t ID: " + this.id + "\n";
	}

	//metodo que retorna el clon del nodo
	public Node clone() {
		Node clone = new Node(this.name,this.age,this.id);
		return clone;
	}
	
	

}
