package monk_and_Prisoner_of_Azkaban_03;

public class Node {

	/*@author David Viuche 
	 * NRC: 6285
	 */
	
	public int valor;
	public int pos;

	public Node next; // Pointer
	public Node back;
	
	public Node() {}

	public Node(int valor, int pos) {

		this.valor = valor;
		this.pos = pos;

	}

	public String toString() {
		return String.valueOf(valor)+" pos: "+pos+" ";
	}

	public Node clone() {
		Node clone = new Node(this.valor, this.pos);
		return clone;
	}
	
	

}
