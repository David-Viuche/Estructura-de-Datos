package arboles;

public class Node {

	int value;//valor del nodo

	Node right = null;//apuntador del hijo derecho
	Node left = null;//apuntador del hijo izquierdo

	//contructor
	public Node(int value) {

		this.value = value;
	}

	//metood que retorna un dato de tipo String con el valor del nodo
	public String toString() {
		return "Valor: " + this.value;
	}
	
	
	//metodo que retorna el clon del nodo
	public Node clone() {
		Node clone = new Node(this.value);
		return clone;
	}
}
