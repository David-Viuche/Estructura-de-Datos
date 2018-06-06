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
		// n numero de ara�as
		// x numero de ara�as que se toman
		Queue ara�as = new Queue();
		Queue ara�asEliminadas = new Queue();
		Node mayor, temp;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {

			// lectura de los valore de n y x
			entrada = br.readLine();
			aux = entrada.split(" ");

			n = Integer.parseInt(aux[0]);
			x = Integer.parseInt(aux[1]);

			// lectura de los poderes inciales de las ara�as
			entrada = br.readLine();
			aux = entrada.split(" ");

			// ingresar las ara�as a la fila
			for (int i = 1; i <= n; i++)
				ara�as.enqueue(new Node(Integer.parseInt(aux[i - 1]), i));

			//ciclo principal
			z = x;
			for (int k = 0; k < z; k++) {
				// declaracion de la ara�a mayor como la primera de la fila
				mayor = ara�as.head.clone();

				//verificacion de que hay suficientes ara�as para tomar
				if (ara�as.QueueSize() < x)
					x = ara�as.QueueSize();

				//pasar las X ara�as de la fila principal a las ara�as elminadas
				for (int i = 0; i < x; i++) {
					temp = ara�as.dequeue().clone();
					//vaidacion de la ara�a mayor 
					if (temp.power > mayor.power)
						mayor = temp;
					ara�asEliminadas.enqueue(temp);
				}
				//se agrega a la salida la ara�a de mayor poder 
				salida.append(mayor.index + " ");

				//se devuelven las ara�as eliminadas a la fila principal restando 1 de su poder
				for (int i = 0; i < x; i++) {
					temp = ara�asEliminadas.dequeue().clone();

					if (temp.index != mayor.index) {
						if (temp.power != 0) {
							temp.power = temp.power - 1;
						}
						ara�as.enqueue(temp);
					}
				}

			}

			//impresion de la salida final
			System.out.println(salida.toString());
		} catch (Exception e) {

		}
	}
}
