package monk_and_Philosophers_Stone_01;

public class Node {

	/*@author David Viuche 
	 * NRC: 6285
	 */
	
	//valor del nodo
	public int valor;

	public Node next; // apuntador del nodo siguiente

	//constructores 
	public Node() {}

	public Node(int valor) {

		this.valor = valor;
		

	}

	//funcion que retorna el valor del nodo en forma de String
	public String toString() {
		return String.valueOf(valor)+" ";
	}

	//metodo que retorna un nuevo objeto con el mismo valor del nodo
	public Node clone() {
		Node clone = new Node(this.valor);
		return clone;
	}
	
	

}
