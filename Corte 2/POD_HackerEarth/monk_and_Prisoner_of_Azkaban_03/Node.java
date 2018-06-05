package monk_and_Prisoner_of_Azkaban_03;

public class Node {

	/*
	 * @author David Viuche NRC: 6285
	 */

	// valores del nodo
	public int valor;
	public int pos;

	public Node next; // apuntador del nodo siguiente
	public Node back;// apuntador del nodo atras

	//contructores 
	public Node() {
	}

	public Node(int valor, int pos) {

		this.valor = valor;
		this.pos = pos;

	}

	//funcion que retorna un dato de tipo String con el valor del nodo 
	public String toString() {
		return String.valueOf(valor) + " pos: " + pos + " ";
	}

	//funcion que retorna el clon del nodo
	public Node clone() {
		Node clone = new Node(this.valor, this.pos);
		return clone;
	}

}
