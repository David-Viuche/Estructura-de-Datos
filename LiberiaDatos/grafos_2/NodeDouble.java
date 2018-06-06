package grafos_2;

public class NodeDouble {
	
	int num1;
	int num2;
	
	NodeDouble next;

	public NodeDouble (int indexNode,int indexConect) {
		this.num1 = indexNode;
		this.num2 = indexConect;
	}
	
	public String toString() {
		return num1 + " "+num2;
	}
}
