package URI_BST_Operations_1200;

/*Author: David Viuche 
 * 
 * Nodo del Arbol binario implementado para funcionar con letras
 * */

public class Node {

	//valor del nodo
	int value;

	//hijo de la derecha
	Node right = null;
	//hijo de la izquierda
	Node left = null;

	//constructor del nodo recibe como parametro el valor del nodo
	public Node(int value) {

		this.value = value;
	}

	//retorna un dato de tipo String con el valor del nodo
	public String toString() {
		return "Valor: " + this.value;
	}
	
	//crea un clon del nodo y lo retorna 
	public Node clone() {
		Node clone = new Node(this.value);
		return clone;
	}
}
