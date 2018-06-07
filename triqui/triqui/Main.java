package triqui;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		int[][] bor = { { -1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		Node board1 = new Node(bor);

		Graph graph = new Graph();
		List temp;
		int flag = 1;

		temp = board1.listTriquiSucessor(flag);
		graph.insertNodes(temp.head);

		for (int j = 0; j < 40320; j++) {

			int i;
			for (i = 1; i <= temp.listSize(); i++) {
				graph.addEdge(temp.head, temp.getNode(i));
			}

			if (flag == 1) {
				flag = -1;
			} else if (flag == -1) {
				flag = 1;
			}
			
			temp = new List();
			temp = graph.listNodes.getNode(j+1).listTriquiSucessor(flag);
			graph.insertNodes(temp.head.next);

			
		}

//		graph.listNodes.printlnList();
		System.out.println("\nfinal\n");
//		graph.adjList.printlnList();

	}

}
