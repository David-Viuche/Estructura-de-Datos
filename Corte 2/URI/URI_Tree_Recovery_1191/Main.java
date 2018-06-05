package URI_Tree_Recovery_1191;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*Author: David Viuche 
 * 
 * programa que recibe como entrada el preorden e inorden de un arbol para imprimir el postorden 
 * 
 * input: DBACEGF ABCDEFG
 * 
 * output: ACBFGED
 * */


public class Main {

	public static void main(String[] args) {

		//decalracion e inicializacion de las variables inciales
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = 0;
		String entrada;
		String[] aux;
		String  pre;
		String  in;
		String [][] matriz;
		int[] index;
		Tree temp = new Tree();
		try {
			
			//leer la entrada 
			entrada = br.readLine();
			aux = entrada.split(" ");//separar el preorden del inorden 
			
			pre = aux[0]; //guardar en la variable pre el preorden ingresado
			in = aux[1]; //guardar en la variable in el inorden ingresado
			
			//incializacion de la matriz 
			matriz = new String[pre.length()+1][pre.length()+1];
			
			//todos los elementos de la matriz son espacios vacios
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					matriz[i][j]=" ";
				}
			}
			
			//insertar en la matriz en la parte superior el inorden
			for (int i = 1; i <= matriz.length-1; i++) {
				matriz[0][i] = Character.toString(in.charAt(i-1));
			}
			
			//insertar en la parte izquierda el preorden
			for (int i = 1; i <= matriz.length-1; i++) {
				matriz[i][0] = Character.toString(pre.charAt(i-1));
			}
			
			//señalar en la matriz donde se cruzan el preorden y el inorden
			for (int i = 0; i < in.length(); i++) {
				index = index(matriz, Character.toString(in.charAt(i)));
				matriz[index[0]][index[1]] = "1";
			}
			
			//insertar en el arbol el inorden en orden desendente dependiendo de donde se intersectan 
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if(matriz[i][j]=="1") {
						temp.insert(matriz[0][j]);
					}
				}
			}
			
			//impresion por consola en postorden
			Tree.postorder(temp.root);
			
//			for (int i = 0; i < matriz.length; i++) {
//				for (int j = 0; j < matriz[i].length; j++) {
//					System.out.print(matriz[i][j]+" ");
//				}
//				System.out.println("");
//			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//metodo que retorna un vector con la posicion de la interseccion de las letras
	public static int[] index(String[][] matriz, String letra) {
		int[]ret = new int[2];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j].equals(letra)) {
					ret[0]=i;
					break;
				}
			}
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[j][i].equals(letra)) {
					ret[1]=i;
					break;
				}
			}
		}

		
		return ret;
	}
	
}


