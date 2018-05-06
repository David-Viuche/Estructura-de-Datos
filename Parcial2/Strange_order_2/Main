package Strange_order_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		String entrada; // variable donde se almacena la entrada
		List arrayA = new List();// lista de la permutacion de n
		List arrayB = new List();// lista de salida
		long n;// variable para guardar el numero ingresado
		Node mayor;// nodo para almacenar temporalmente el nodo mayor de la lista original

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// leer entrada n
			entrada = br.readLine();
			n = Integer.parseInt(entrada);

			// llenar la lista con la permutacion del numero ingresado
			for (int i = 1; i <= n; i++) {
				arrayA.insertAtBegin(new Node(i));
			}
			
			//ciclo que controla las iteraciones totales 
			while (!arrayA.isEmpty()) {

				mayor = arrayA.getNode(arrayA.returnMayorIndex());//guarda en el Nodo mayor el nodo de mayor valor de la lista original
				arrayA.deleteAtIndex(arrayA.returnMayorIndex());// elimina de la lista original el nodo mayor
				arrayB.insertAtEnd(mayor.clone());//inserta en el final de la lista de salida el nodo mayor de la primera

				if (!arrayA.isEmpty()) {
					for (int i = 0; i <= arrayA.listSize(); i++) {//ciclo para recorrer las lista y hacer el MCD

						if (MCD_Euclides(mayor.value, arrayA.getNode(i).value) != 1) {//condicional que verifica el MCD entre mayor y cada nodo de la lista original
							arrayB.insertAtEnd(arrayA.getNode(i).clone());//si la condicion anterior es diferente de 1 inserta al final al nodo que este comparando de la lista original
							arrayA.deleteAtIndex(arrayA.returnIndex(arrayA.getNode(i)));//borra de la lista original el nodo insertado
						}
					}
				}

			}
			arrayB.printList();//imprime la salida

		} catch (Exception e) {

		}

	}

	//metodo que retorna el minimo comun divisor entre dos numeros 
	public static int MCD_Euclides(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

}
