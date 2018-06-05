package monk_and_Chamber_of_Secrets_02;

public class Node {

	// Valores de los nodos
	public int power;
	public int index;

	public Node next; // apuntador del nodo siguiente

//	constructores
	public Node() {}

	public Node(int power, int index) {

		this.power = power;
		this.index = index;

	}

	//metodo que retorna un dato de Tipo String con el valor del nodo
	public String toString() {
		return String.valueOf(power)+" i: "+String.valueOf(index)+" ";
	}

	//metodo que retorna el clon del nodo actual
	public Node clone() {
		Node clone = new Node(this.power, this.index);
		return clone;
	}
	
	

}
