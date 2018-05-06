package monk_and_Philosophers_Stone_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*@author David Viuche 
 * NRC: 6285
 * 
 * Input: 
 * 4
 * 3 1 1 4
 * 6 7
 * Harry
 * Harry
 * Harry
 * Remove
 * Remove
 * Harry
 * 
 * Output: 2
 * */
public class Main {

	public static void main(String[] args) {

		int n = 0, x, q, counter = 0;
		Stack monkBag = new Stack();
		Queue harryBag = new Queue();
		String entrada;
		String[] aux;
		Node temp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {

			n = Integer.parseInt(br.readLine());
			entrada = br.readLine();
			aux = entrada.split(" ");

			for (int i = 0; i < aux.length; i++)
				harryBag.enqueue(new Node(Integer.parseInt(aux[i])));

			entrada = br.readLine();
			aux = entrada.split(" ");

			q = Integer.parseInt(aux[0]);
			x = Integer.parseInt(aux[1]);

			for (int i = 0; i < q; i++) {

				entrada = br.readLine();

				if (entrada.equals("Harry")) {
					temp = harryBag.dequeue();
					counter = counter + temp.valor;
					monkBag.push(temp);

				} else if (entrada.equals("Remove")) {
					temp = monkBag.pop();
					counter = counter - temp.valor;
				}

				if (counter == x) {
//					bw.write(monkBag.StackSize());
					
					System.out.println(monkBag.StackSize());
//					bw.flush();
					break;
				}
			}

		} catch (Exception e) {

		}
	}
}
