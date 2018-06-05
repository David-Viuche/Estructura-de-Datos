package little_Monk_and_Goblet_of_Fire_04;

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
 * E 1 1
 * E 2 1
 * E 1 2
 * D
 * D
 * 
 * Output: 1 1
 * 		   1 2
 * */

public class Main {
	public static void main(String[] args) throws IOException {
		// declaracion e inicializacion de las variables principales
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List students = new List();
		int n = 0, index = -1;
		String entrada;
		String[] aux;
		boolean flag = false;
		try {

			// lectura de la cantidad de alumnos
			n = Integer.parseInt(br.readLine());

			// ciclo principal
			for (int i = 0; i < n; i++) {

				// lectura de la entrada
				entrada = br.readLine();
				aux = entrada.split(" ");

				// verificacion de la operacion ingresada
				if (aux.length == 1) {
//					students.printList();
					Node temp3 = students.head;
					students.head = students.head.next;

					System.out.println(temp3.toString());
					// se imprime el primer estudinte en la fila
				}

				if (aux.length > 1) {
					// si la lista esta vacia se inserta en la primera posicion
					Node temp = new Node(Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
					Node temp2;
					if (students.isEmpty()) {
						students.insertAtBegin(temp);
					} else {
						// si no esta vacia se busca si en la fila hay algun estudiante de la misma
						// escuela para insertar el estudiante detras
						for (int j = students.listSize(); j >= 0; j--) {

							temp2 = students.getNode(j);
							if (temp2.school == temp.school) {

								students.insertAtIndex(temp, (students.returnIndex(temp2) + 1));
								flag = true;
								break;
							}

						}

						if (flag == false)
							students.insertAtEnd(temp);
					}

				}

			}

		} catch (Exception e) {

		}

	}
}
