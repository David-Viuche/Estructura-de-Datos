package Dual_issues_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {

		String[] aux; // arreglo para la interpretacion de las entradas
		String entrada; // variable donde se almacena la entrada
		List array;// lista de la permutacion de n
		List arrayPrimos;// lista de salida
		int t, n;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			// leer entrada (N° casos de prueba)
			entrada = br.readLine();
			aux = entrada.split(" ");
			// guardar el numero de casos de prueba
			t = Integer.parseInt(aux[0]);

			// ciclo que controla el numero de casos a testear
			for (int h = 0; h < t; h++) {

				// inicializacion de las listas
				array = new List();
				arrayPrimos = new List();

				// leer entrada (tamaño de la lista a ingresar)
				entrada = br.readLine();

				// guarda N° de enteros a ingresar
				n = Integer.parseInt(entrada);

				// leer entrada de los elementos ingresados
				entrada = br.readLine();
				aux = entrada.split(" ");

				// ciclo para guardar todos los elementos del arreglo de numeros ingresados
				for (int i = 0; i < n; i++)
					array.insertAtEnd(new Node(Integer.parseInt(aux[i])));

				// ciclo para insertar en el arrayPrimos todos los numeros primos encontrados en
				// el array
				for (int i = 0; i < n; i++) {

					if (esPrimo(array.getNode(i).value) == 1)
						arrayPrimos.insertAtEnd(array.getNode(i).clone());

				}
				//evalua si existen numeros primos en el arrayPrimos
				if (arrayPrimos.isEmpty()) {
					System.out.println("\n-1");//si no hay se imprime por pantalla -1
				} else {
					//de lo contrario se veirifica si solo hay un numero primo de no ser asi 
					int mayor = 0;
					int mul;
					if(arrayPrimos.listSize()==1) {
						//ciclos para hacer la multiplicacion entre los numeros primos y encuentra la mayor multiplicacion 
						for (int i = 0; i < arrayPrimos.listSize(); i++) {
							for (int j = 0; j < arrayPrimos.listSize(); j++) {
								mul = (arrayPrimos.getNode(i).value)*(arrayPrimos.getNode(j).value);
								if(mul >= mayor) {
									mayor = mul;
								}
							}
						}
					}else {
						//si solo hay un numero primo la mayor multiplicacion va a ser el mismo al cuadrado
						mayor = (arrayPrimos.head.value)*(arrayPrimos.head.value);
					}
					//se imprime la mayor multiplicacion entre numeros primos
					System.out.println(mayor);
				}

			}

		} catch (Exception e) {

		}

	}

	//metodo que retorna 1 si el numero ingresado como parametro es primo de lo contrario retorna 0
	public static int esPrimo(int num) {
		if (num == 1) {
			return 0;
		} else {
			int num2 = num - 1;

			while ((num % num2) != 0)
				num2--;

			if (num2 == 1)
				return 1;

			else
				return 0;

		}
	}
}
