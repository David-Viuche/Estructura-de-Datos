package mirror_Image_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * Author: David Viuche
 * 
 * input: 
10 8
1 2 R
1 3 L
2 4 R
2 5 L
3 6 R
3 7 L
5 8 R
5 9 L
7 10 R
2
5
3
6
1
10
9
4

output: 
3
6
2
5
1
-1
-1
7
 * */

public class Main {

	public static void main(String[] args) {
		// declaracion de variables iniciales
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String entrada = "";
		String[] aux;
		int n, q;
		Tree tree = new Tree();
		tree.root = new Node(1);
		try {

			// lectura de los datos n y q
			entrada = br.readLine();
			aux = entrada.split(" ");

			n = Integer.parseInt(aux[0]) - 1;
			q = Integer.parseInt(aux[1]);

			// ciclo para leer las entradas de las operaciones de insercion
			for (int i = 0; i < n; i++) {
				// lectura de la entrada
				entrada = br.readLine();
				aux = entrada.split(" ");
				// insercion en el arbol
				tree.insertMirror(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), aux[2], tree.root);
			}

			// ciclo para la lectura de los nodos a encontrar el nodod espejo
			for (int i = 0; i < q; i++) {
				// lectura de la entrada
				entrada = br.readLine();
				// llamada al metodo que retorna el nodo espejo
				tree.mirrorNode(Integer.parseInt(entrada),tree.root);

			}

			// Tree.preorder(tree.root);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
