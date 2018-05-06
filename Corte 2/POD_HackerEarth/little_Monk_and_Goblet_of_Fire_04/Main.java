package little_Monk_and_Goblet_of_Fire_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List students = new List();
		int n = 0, index = -1;
		String entrada;
		String[] aux;
		boolean flag = false;
		try {

			n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {

				entrada = br.readLine();
				aux = entrada.split(" ");

				if (aux.length == 1) {
					students.printList();
					Node temp3 = students.head;
					students.head = students.head.next;

					System.out.println(temp3.toString());
				}

				if (aux.length > 1) {
					Node temp = new Node(Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
					Node temp2;
					if (students.isEmpty()) {
						students.insertAtBegin(temp);
					} else {

						for (int j = students.listSize(); j >= 0; j--) {
							
							temp2 = students.getNode(j);
							if(temp2.school == temp.school) {
								
								students.insertAtIndex(temp, (students.returnIndex(temp2)+1));
								flag = true;
								break;
							}
							
						}
						
						if(flag == false) 
							students.insertAtEnd(temp);
					}

				}

			}
			
		} catch (Exception e) {

		}

	}
}
