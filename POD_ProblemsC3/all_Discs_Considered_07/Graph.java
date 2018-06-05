package all_Discs_Considered_07;
import java.io.IOException;
/*@author David Viuche 
 * NRC: 6285
 */


public class Graph {
	
	//cantidad de nodos y vector de nodos 
	public int nNodes;
	public List[] adjList ;
	
	//constructures
	public Graph (List[] adjList) {
		this.adjList = adjList; 
	}
	
	public Graph (int nNodes)
	{
		this.nNodes = nNodes;
		
		adjList = new List [nNodes];
		
		for(int i = 0; i < nNodes; i++)
			adjList[i] = new List();
	}
	
	//metodo que agrega una arista entre dos nodos
	public void addEdge ( int nList , int dest ) {
		
		Node newNode = new Node(dest-1);
		
		this.adjList[nList-1].insertAtEnd(newNode);
	}
	
	//metodo que imprime el grafo 
	 public void printGraph(Graph graph) throws IOException
	 {       
		 for(int i = 0; i < graph.nNodes; i++)
		 {
			 System.out.println("list node "+ i);
			 System.out.print("head");
			 
			 for(int j = 0; j < graph.adjList[i].listSize(); j++)
				 System.out.print(" -> "+graph.adjList[i].getNode(j).valor);
			   
			 System.out.println("\n");
		 }
	 }
	 
	 //metodo que clona un grafo y lo retorna 
	 public Graph clone() {
		 return new Graph(this.adjList);
	 }
}
