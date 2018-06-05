package monk_and_Chamber_of_Secrets_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {

		// declaracion e inicializacion de las variables principales
		StringBuilder salida = new StringBuilder();
		String[] aux;
		String entrada;
		int n, x, z;
		// n numero de arañas
		// x numero de arañas que se toman
		Queue arañas = new Queue();
		Queue arañasEliminadas = new Queue();
		Node mayor, temp;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {

			// lectura de los valore de n y x
			entrada = br.readLine();
			aux = entrada.split(" ");

			n = Integer.parseInt(aux[0]);
			x = Integer.parseInt(aux[1]);

			// lectura de los poderes inciales de las arañas
			entrada = br.readLine();
			aux = entrada.split(" ");

			// ingresar las arañas a la fila
			for (int i = 1; i <= n; i++)
				arañas.enqueue(new Node(Integer.parseInt(aux[i - 1]), i));

			//ciclo principal
			z = x;
			for (int k = 0; k < z; k++) {
				// declaracion de la araña mayor como la primera de la fila
				mayor = arañas.head.clone();

				//verificacion de que hay suficientes arañas para tomar
				if (arañas.QueueSize() < x)
					x = arañas.QueueSize();

				//pasar las X arañas de la fila principal a las arañas elminadas
				for (int i = 0; i < x; i++) {
					temp = arañas.dequeue().clone();
					//vaidacion de la araña mayor 
					if (temp.power > mayor.power)
						mayor = temp;
					arañasEliminadas.enqueue(temp);
				}
				//se agrega a la salida la araña de mayor poder 
				salida.append(mayor.index + " ");

				//se devuelven las arañas eliminadas a la fila principal restando 1 de su poder
				for (int i = 0; i < x; i++) {
					temp = arañasEliminadas.dequeue().clone();

					if (temp.index != mayor.index) {
						if (temp.power != 0) {
							temp.power = temp.power - 1;
						}
						arañas.enqueue(temp);
					}
				}

			}

			//impresion de la salida final
			System.out.println(salida.toString());
		} catch (Exception e) {

		}
	}
}
