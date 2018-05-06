package monk_and_Philosophers_Stone_01;

public class Node {

	/*@author David Viuche 
	 * NRC: 6285
	 */
	
	public int valor;

	public Node next; // Pointer

	public Node() {}

	public Node(int valor) {

		this.valor = valor;
		

	}

	public String toString() {
		return String.valueOf(valor)+" ";
	}

	public Node clone() {
		Node clone = new Node(this.valor);
		return clone;
	}
	
	

}
