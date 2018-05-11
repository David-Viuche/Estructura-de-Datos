package Zulu_and_Games_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {

		String[] aux; // arreglo para la interpretacion de las entradas
		String entrada; // variable donde se almacena la entrada
		List niveles = new List();// lista de los niveles ingresados
		int n, sum = 0, mayor = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			// leer entrada (N° de niveles)
			entrada = br.readLine();
			n = Integer.parseInt(entrada);

			// leer niveles bajos
			entrada = br.readLine();
			aux = entrada.split(" ");

			for (int i = 0; i < aux.length; i++)
				niveles.insertAtEnd(new Node(Integer.parseInt(aux[i]), 0));

			// leer niveles altos
			entrada = br.readLine();
			aux = entrada.split(" ");

			for (int i = 0; i < aux.length; i++)
				niveles.getNode(i).valueHigth = Integer.parseInt(aux[i]);

			// recorrer la lista para hacer las combinaciones
			for (int i = 0; i < niveles.listSize() + 1; i++) {

				for (int j = i; j < niveles.listSize() + 1; j++) {

					if (j != i) {
						// verificar si se intersectan los niveles
						if (intersection(niveles.getNode(i).clone().valueLow, niveles.getNode(i).clone().valueHigth,
								niveles.getNode(j).clone().valueLow, niveles.getNode(j).clone().valueHigth) == false) {

							// encontrar el mayor de cada combinacion
							if (niveles.getNode(i).clone().valueHigth >= niveles.getNode(j).clone().valueHigth) {
								sum = sum + niveles.getNode(i).clone().valueHigth;
							} else {
								sum = sum + niveles.getNode(j).clone().valueHigth;
							}
						}
					}
				}
			}
			System.out.println(sum);
		} catch (Exception e) {

		}

	}

	public static boolean intersection(int low1, int higth1, int low2, int higth2) {

		if (higth1 <= low2) {
			return false;
		} else {

			return true;
		}
	}
}

