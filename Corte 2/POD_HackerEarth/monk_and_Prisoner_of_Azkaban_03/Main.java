package monk_and_Prisoner_of_Azkaban_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*@author David Viuche 
 * NRC: 6285
 * 
 * Input: 
 * 5
 * 5 4 1 3 2
 * 
 * Output: -2 0 6 1 3 
 * */
public class Main {
	public static void main(String[] args) throws IOException {

		//declaracion e inicializacion de las variables iniciales
		int n = 0;
		ListDoble array = new ListDoble();
		String entrada;
		String[] aux;
		int x = 0, y = 0;
		StringBuilder salida = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {

			//lectura del tamaño del arreglo
			n = Integer.parseInt(br.readLine());
			
			//lectura del arreglo
			entrada = br.readLine();
			aux = entrada.split(" ");

			//insercion del arrelgo en la lista doble
			for (int i = n - 1; i >= 0; i--)
				array.insertAtBegin(new Node(Integer.parseInt(aux[i]), (i + 1)));

			//bucle principal
			for (int i = 0; i < n; i++) {

				//se obtiene cada nodo 
				Node temp = array.getNode(i);
				Node temp2 = temp;

				//se busca el mayor de los nodos a la izquierda
				while (temp2 != null) {
					if (temp2.valor > temp.valor)
						break;
					temp2 = temp2.back;
				}
				
				//si el nodo mayor es nulo no existe  x = -1 
				if(temp2 == null) 
					x = -1;
				else
					x = temp2.pos;
				
				temp2 = temp;
				
				//se busca el mayor de los nodos a la derecha
				while (temp2 != null) {
					if (temp2.valor > temp.valor)
						break;
					temp2 = temp2.next;
				}
				
				//si el nodo mayor es nulo no existe y = -1 
				if(temp2 == null) 
					y = -1;
				else
					y = temp2.pos;
				
				//se suma x+y 
				salida.append((x+y)+" ");
//				System.out.println("x: "+x+"   y: "+y);
			}

			//impresion de los resultados
			System.out.println(salida.toString());
			
		} catch (Exception e) {

		}
	}
}
