package all_Discs_Considered_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*@author David Viuche 
 * NRC: 6285
 * 
 * input:
3 2 1
1 2
2 2 2
1 3
4 2
2 1 1
1 3
0 0 0
output: 
3
4
3
 * */
public class Main {

	public static void main(String[] args) {
		//declaracion de las variables iniciales
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String entrada = "";
		String[] aux;
		String[] aux2;
		int d1, d2, t;
		Graph graph;

		try {
			//lectura de las entradas
			entrada = br.readLine();
			
			//ciclo principal que termina cuando se ingresan "0 0 0"
			while (!entrada.equals("0 0 0")) {

				//lectura de la cantidad de paquetes de cada disco
				aux = entrada.split(" ");

				d1 = Integer.parseInt(aux[0]);
				d2 = Integer.parseInt(aux[1]);
				
				//declaracion e inicializacion del grafo
				graph = new Graph(d1 + d2);
				
				//insercion de los discos con sus respectivas dependencias
				for (int i = 0; i < Integer.parseInt(aux[2]); i++) {
					entrada = br.readLine();
					aux2 = entrada.split(" ");

					graph.addEdge(Integer.parseInt(aux2[1]), Integer.parseInt(aux2[0]));

				}

				//impresion de la cantidad de cambios de discos utilizadas para la instalacion
				System.out.println(countDiscs(install(graph), d1));

				entrada = br.readLine();
			}

		} catch (Exception e) {

		}
	}

	//metodo que instala los discos en orden 
	public static List install(Graph graph) {

		List installedDiscs = new List();

		Graph aux = graph.clone();

		while (installedDiscs.listSize() != graph.adjList.length) {

			int min = Integer.MAX_VALUE;
			int index = 0;

			for (int i = 0; i < graph.adjList.length; i++) {

				if (aux.adjList[i].listSize() != 0)
					if (aux.adjList[i].head.valor < min) {
						min = aux.adjList[i].head.valor;
						index = i;
					}
			}

			if (min == Integer.MAX_VALUE) {

				for (int i = 0; i < graph.adjList.length; i++) {

					if (installedDiscs.isOn(i) == false) {

						installedDiscs.insertAtEnd(new Node(i));

					}

				}

			} else {
				installedDiscs.insertAtEnd(new Node(index));
				installedDiscs.insertAtEnd(new Node(min));
				aux.adjList[index].deleteAtBegin();
			}
		}
		return installedDiscs;
	}

	
	//metodo que cuenta la cantidad de cambios de discos hechos en la isntalacion
	public static int countDiscs(List installedDiscs, int start) {

		int counter = 2;
		boolean flag = false;
		boolean[] discs = new boolean[installedDiscs.listSize()];

		
		for (int i = 0; i < installedDiscs.listSize(); i++) {

			Node node = installedDiscs.getNode(i);
			
			if (node.valor == start) {
				flag = true;
			}
			if (node.valor < start) {
				flag = false;
			}
			if (node.valor > start) {
				flag = true;
			}

			discs[i] = flag;

		}

		for (int i = 0; i < discs.length - 1; i++) {

			if (discs[i] != discs[i + 1]) {
				counter++;
			}

		}

		return counter;
	}

}
