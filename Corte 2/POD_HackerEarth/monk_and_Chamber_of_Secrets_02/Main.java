package monk_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {

		StringBuilder salida = new StringBuilder();
		String[] aux;
		String entrada;
		int n, x,z;
		Queue arañas = new Queue();
		Queue arañasEliminadas = new Queue();
		Node mayor, temp;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {

			entrada = br.readLine();
			aux = entrada.split(" ");

			n = Integer.parseInt(aux[0]);
			x = Integer.parseInt(aux[1]);

			entrada = br.readLine();
			aux = entrada.split(" ");

			for (int i = 1; i <= n; i++)
				arañas.enqueue(new Node(Integer.parseInt(aux[i - 1]), i));
			z = x; 
			for (int k = 0; k < z; k++) {

				mayor = arañas.head.clone();

				if (arañas.QueueSize() < x)
					x = arañas.QueueSize();

				for (int i = 0; i < x; i++) {
					temp = arañas.dequeue().clone();
					if (temp.power > mayor.power)
						mayor = temp;
					arañasEliminadas.enqueue(temp);
				}

				salida.append(mayor.index + " ");

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

			System.out.println(salida.toString());
		} catch (Exception e) {

		}
	}
}
