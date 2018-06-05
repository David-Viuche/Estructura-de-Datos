package mirror_Image_01;

/*
 * author: David Viuche
 * */

public class Node {

	//valor del nodo
	int value;

	//hijos de la derecha e izquierda
	Node right = null;
	Node left = null;

	//constructor
	public Node(int value) {

		this.value = value;
	}

	//metodo que retorna un dato de tipo String con el valor del nodo
	public String toString() {
		return "Valor: " + this.value;
	}
	
	//metodo que retorna un clon del nodo
	public Node clone() {
		Node clone = new Node(this.value);
		return clone;
	}
}
