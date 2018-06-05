package URI_BST_Operations_1200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*Author: David Viuche 
 * 
 * Clase que crea un arbol binario con las letras del abecedario 
 * input:
 *  I c
	I f
	I a
	I h
	INFIXA
	PREFIXA
	POSFIXA
	P z
	P h
	I g
	INFIXA
	
	output:
	a c f h
	c a f h
	a h f c
	z nao existe
	h existe
	a c f g h 
 * */

public class Main {
	public static void main(String[] args) {
		// Declaracion variables iniciales y arbol binario principal
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String entrada = "";
		String[] aux;

		Tree treeLetters = new Tree();

		try {
			// leer la primera entrada
			entrada = br.readLine();

			// bucle para ejecutar hasta que la entrada sea una linea en blanco
			while (!entrada.equals("")) {

				// verificacion si la entrada es de tamaño 3 para saber si es un recorrido del
				// arbol
				// o si es una operacion de busqueda o insercion
				if (entrada.length() == 3) {
					// convertir la entrada a un arreglo quitando los espacios en blanco
					aux = entrada.split(" ");

					// verificacion de la operacion a realizar (I insertar P buscar)
					if (aux[0].equals("I")) {
						// se llama la funcion insertar del arbol principal y se pasa como parametro la
						// letra a insertar
						treeLetters.insert(aux[1]);
					} else if (aux[0].equals("P")) {
						// se llama la funcion buscar del arbol principal y se pasa como parametro la
						// letra a buscar
						treeLetters.search(aux[1]);
						System.out.print("\n");
					}
				} else {
					// se verifica que recorrido se va a realizar y se llama la funcion correspondiente
					if (entrada.equals("INFIXA")) {
						//se llama la funcion inorden del arbol principal 
						Tree.inorder(treeLetters.root);
						System.out.print("\n");
					} else if (entrada.equals("PREFIXA")) {
						//se llama la funcion preorden del arbol principal
						Tree.preorder(treeLetters.root);
						System.out.print("\n");
					} else if (entrada.equals("POSFIXA")) {
						//se llama la funcion postorden del arbol principal
						Tree.postorder(treeLetters.root);
						System.out.print("\n");
					}

				}
				//se lee la siguiente entrada 
				entrada = br.readLine();
			}
		} catch (Exception e) {
		}

	}

}
