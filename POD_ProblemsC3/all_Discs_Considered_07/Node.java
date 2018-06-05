package all_Discs_Considered_07;

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

	//metodo que retorna un dato de tipo String con el valor del nodo
	public String toString() {
		return String.valueOf(valor)+" ";
	}

	//metodo que retorna un clon del nodo
	public Node clone() {
		Node clone = new Node(this.valor);
		return clone;
	}
	
	

}
