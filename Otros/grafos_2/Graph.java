package grafos_2;

import java.io.IOException;

public class Graph {

	public int nNodes;
	public List listNodes;
	public ListDouble adjList;

	public Graph() {
		listNodes = new List();
		adjList = new ListDouble();
	}

	public void addEdge(Node node, Node conect) {

//		System.out.print(this.listNodes.returnIndex(node));
//		System.out.print("\t"+this.listNodes.returnIndex(conect)+"\n");
		this.adjList.insertAtEnd(new NodeDouble(this.listNodes.returnIndex(node),this.listNodes.returnIndex(conect)));
		
		if(listNodes.isOn(node)==false) {
			listNodes.insertAtEnd(node);
		}
		
		if(listNodes.isOn(conect)==false) {
			listNodes.insertAtEnd(conect);
		}
	}

	public void insertNodes(Node node) {
		this.listNodes.head = node;
	}
	
	public void printGraph(Graph graph) throws IOException {

		for (int i = 0; i < graph.nNodes; i++) {

			System.out.println("Adjacency list of node " + i);

			// graph.adjList[i].printlnList();

			System.err.println("--------------------------------\n");
		}
	}
}
