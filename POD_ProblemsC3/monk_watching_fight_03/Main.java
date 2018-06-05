package monk_watching_fight_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * author: David Viuche
 *input  4
		 2 1 3 4
  output
  		 3
 * */

public class Main {

	public static void main(String[] args) {
		//declaracion de las variables iniciales
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String entrada = "";
		String[] aux;
		int n;
		Tree tree = new Tree();
		
		try {
			//lectura de la cantidad de nodos a insertar
			n = Integer.parseInt(br.readLine());
			
			//lectura de los nodos a ingresar
			entrada = br.readLine();
			aux = entrada.split(" ");
			
			//insercion de los nodos en el arbol
			for (int i = 0; i < aux.length; i++) {
				tree.insert(Integer.parseInt(aux[i]));
			}
			
			//impresion de la altura del arbol creado
			System.out.println(tree.nodeHeigth(tree.search(Integer.parseInt(aux[0])))+1);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
