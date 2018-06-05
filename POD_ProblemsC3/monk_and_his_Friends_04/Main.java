package monk_and_his_Friends_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*author: David Viuche
 * input 1
		 2 3
		 3 2 9 11 2
	output
		 NO
	 	 NO
		 YES
 * */

public class Main {

	public static void main(String[] args) {
		//declaracion de las variables iniciales
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String entrada = "";
		String[] aux;
		int n,m,t;
		Tree tree = new Tree();
		
		try {
			//lectura de la cantidad de casos de prueba
			t = Integer.parseInt(br.readLine());
			
			//ciclo principal
			for (int i = 0; i < t; i++) {
				
				//lectura de la cantidad de estudiantes en el salon y los que faltan por llegar
				entrada = br.readLine();
				aux = entrada.split(" ");
				
				n = Integer.parseInt(aux[0]);
				m = Integer.parseInt(aux[1]);
				
				//lectura de los estudiantes
				entrada = br.readLine();
				aux = entrada.split(" ");
				
				
				//insercion de los estudiantes que ya estan en el salon en el arbol 
				for (int j = 0; j < n; j++) 
					tree.insert(Integer.parseInt(aux[j]));
				
				//verificacion si el estudiante a ingresar ya esta de ser asi imprimir YES de lo contrario NO
				for (int j = n; j < aux.length; j++) {
					if(tree.search(Integer.parseInt(aux[j])) != null) {
						System.out.println("YES");
					}else {
						System.out.println("NO");
					}
					
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
