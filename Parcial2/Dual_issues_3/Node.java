package Dual_issues_3;



/*@author David Viuche 
 * NRC: 6285
 * Date: 04-05-2018
 */

public class Node {

	//atributos del objeto Node
	int value;
	Node next;

	//constructor que tiene como parametro el valor del Nodo a instanciar
	public Node(int value) {

		this.value = value;
	}

	//metodo que retorna un String con el valor del Nodo
	public String toString() {
		return  this.value+" ";
	}
	
	//metodo que retorna un nodo que tiene los mismos atributos que el original
	public Node clone() {
		Node clone = new Node(this.value);
		return clone;
	}

}
