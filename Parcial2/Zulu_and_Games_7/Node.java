package Zulu_and_Games_7;

/*@author David Viuche 
 * NRC: 6285
 * 
 */

public class Node {

	//atributos del objeto Node
	int valueLow;
	int valueHigth;
	Node next;

	//constructor que tiene como parametro el valor del Nodo a instanciar
	public Node(int valueLow, int valueHigth) {
		super();
		this.valueLow = valueLow;
		this.valueHigth = valueHigth;
	}

	//metodo que retorna un String con el valor del Nodo
	public String toString() {
		return  "("+this.valueLow+" "+this.valueHigth+") ";
	}

	//metodo que retorna un nodo que tiene los mismos atributos que el original
	public Node clone() {
		Node clone = new Node(this.valueLow,this.valueHigth);
		return clone;
	}

}
