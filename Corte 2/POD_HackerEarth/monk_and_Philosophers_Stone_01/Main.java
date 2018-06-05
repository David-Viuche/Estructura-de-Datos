package monk_and_Philosophers_Stone_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*@author David Viuche 
 * NRC: 6285
 * 
 * Input: 
  4
  3 1 1 4
  6 7
  Harry
  Harry
  Harry
  Remove
  Remove
  Harry
 * 
 * Output: 2
 * */
public class Main {

	public static void main(String[] args) {

		// declaracion e inicializacion de las variables principales
		int n = 0, x, q, counter = 0;
		Stack monkBag = new Stack();
		Queue harryBag = new Queue();
		String entrada;
		String[] aux;
		Node temp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {

			// lectura de la primera entrada
			n = Integer.parseInt(br.readLine());
			entrada = br.readLine();
			aux = entrada.split(" ");
			// llena la bolsa de harry con los valores ingresados
			for (int i = 0; i < aux.length; i++)
				harryBag.enqueue(new Node(Integer.parseInt(aux[i])));

			// lee los valore de x y q
			entrada = br.readLine();
			aux = entrada.split(" ");

			q = Integer.parseInt(aux[0]);
			x = Integer.parseInt(aux[1]);

			// bucle que se repite q veces para leer las operaciones a realizar
			for (int i = 0; i < q; i++) {
				// lectura de la entrada de la operacion
				entrada = br.readLine();

				// desicion de la operacion a realizar
				if (entrada.equals("Harry")) {
					// se quita una moneda de harry y se pone en la bolsa de monk y se incrementa el
					// contador
					temp = harryBag.dequeue();
					counter = counter + temp.valor;
					monkBag.push(temp);

				} else if (entrada.equals("Remove")) {
					// se retira la ultima moneda agregada de la bolsa de monk y se decrementa el
					// contador
					temp = monkBag.pop();
					counter = counter - temp.valor;
				}
				// se verifica si el contador es igual a x de serlo se imprime la cantidad de
				// monedas en la bolsa de monk y acaba el ciclo y el programa
				if (counter == x) {

					System.out.println(monkBag.StackSize());

					break;
				}
			}

		} catch (Exception e) {

		}
	}
}
