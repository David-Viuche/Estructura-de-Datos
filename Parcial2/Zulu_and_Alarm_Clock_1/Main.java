package Zulu_and_Alarm_Clock_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*@author David Viuche 
 * NRC: 6285
 * Date: 04-05-2018
 */
public class Main {
	//listas circulares para manejar horas, minutos, segundos
	static ListaCircular Hours = new ListaCircular();
	static ListaCircular Minutes = new ListaCircular();
	static ListaCircular Seconds = new ListaCircular();

	public static void main(String[] args) throws IOException {
		//metodos para llenar las listas circulares de horas, minutos, segundos de 0-23 o de 0-59 segun corresponda
		for (int i = 0; i < 24; i++)
			Hours.insertAtEnd(new Node(i));

		for (int i = 0; i < 60; i++)
			Minutes.insertAtEnd(new Node(i));

		for (int i = 0; i < 60; i++)
			Seconds.insertAtEnd(new Node(i));

		
		String[] aux;	//arreglo para la interpretacion de las entradas
		String entrada;	//variable donde se almacena la entrada
		Clock[] clocks;	//arreglo de relojes
		Clock[] alarms; //arreglo de alarmas
		List menorAlarms;//lista de la suma de posisicones para poner las alarmas en los relojes 
		int t, n, k, disH, disM, disS, menor;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			//leer entrada (N° casos de prueba)
			entrada = br.readLine();
			aux = entrada.split(" ");
			//guardar el numero de casos de prueba
			t = Integer.parseInt(aux[0]);

			//leer entrada (N° relojes y N° alarmas para leer)
			entrada = br.readLine();
			aux = entrada.split(" ");

			//guarda N° relojes y N° alarmas para leer
			n = Integer.parseInt(aux[0]);
			k = Integer.parseInt(aux[1]);

			menorAlarms = new List();
//			for (int i = 0; i < k; i++) {
//				menorAlarms.insertAtEnd(new Node(0));
//			}

			//ciclo que controla el numero de casos a testear
			for (int h = 0; h < t; h++) {

				clocks = new Clock[n];//inicializacion de la cantidad de relojes 
				//ciclo para interpretar la entrada en String y guardar la informacion el el objeto clock correspondiente
				for (int i = 0; i < n; i++) {
					entrada = br.readLine();
					aux = entrada.split(":");
					Clock tempC = new Clock(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]),
							Integer.parseInt(aux[2]));
					clocks[i] = tempC;
				}

				alarms = new Clock[k];//inicializacion de la cantidad de alarmas 
				//ciclo para interpretar la entrada en String y guardar la informacion el el objeto clock correspondiente
				for (int i = 0; i < k; i++) {
					entrada = br.readLine();
					aux = entrada.split(":");
					Clock tempC = new Clock(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]),
							Integer.parseInt(aux[2]));
					alarms[i] = tempC;
				}

				//ciclos para poner en el reloj correspondiente ela hora indicada en cada alarma
				for (int i = 0; i < clocks.length; i++) { //ciclo que recorre los relojes
					menor = 1000;
					for (int j = 0; j < k; j++) {//ciclo que recorre las alarmas
						//variables que guardan las diferencia de horas, minutos, segundos para cada reloj y cada alarma
						disH = (Hours.returnDistance(Hours.getNode(clocks[i].horaActual),
								Hours.getNode(alarms[j].horaActual)));
						disM = (Minutes.returnDistance(Minutes.getNode(clocks[i].minutoActual),
								Minutes.getNode(alarms[j].minutoActual)));
						disS = (Seconds.returnDistance(Seconds.getNode(clocks[i].segundoActual),
								Seconds.getNode(alarms[j].segundoActual)));
//						if(disH + disM + disS < menor) {
//							menor = disH + disM + disS;
//							menorAlarms.insertAtIndex(new Node(menor),j );
//						}
						menorAlarms.insertAtEnd(new Node(disH + disM + disS));/*inserta en el arreglo de diferencia de horas la suma de 
						//														las diferencias entre relojes y alarmas*/
					}
					

				}
			}
			menorAlarms.printList();

		} catch (Exception e) {

		}

	}

}
