package estructurasURI;


import java.io.*;

public class URI1022 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );

		

		try
		{
			int cases = Integer.parseInt(br.readLine());
			int n=0, d=0;
			
			for(int i = 0; i < cases; i++)
			{
				String[] expression = br.readLine().split(" ");
				
				switch(expression[3].charAt(0))
				{
					case '+': //Sum: (N1*D2 + N2*D1) / (D1*D2)
					{
						n = ( (Integer.parseInt(expression[0]) * Integer.parseInt(expression[6]))
							 + (Integer.parseInt(expression[4]) * Integer.parseInt(expression[2])) );
						d = Integer.parseInt(expression[2]) * Integer.parseInt(expression[6]);
						bw.write(simplificar(n,d));
						bw.flush();
					}	
					break;
					
					case '-': //Resta: (N1*D2 - N2*D1) / (D1*D2)
					{
						n = ( (Integer.parseInt(expression[0]) * Integer.parseInt(expression[6]))
							 - (Integer.parseInt(expression[4]) * Integer.parseInt(expression[2])) );
						d = Integer.parseInt(expression[2]) * Integer.parseInt(expression[6]);
						bw.write(simplificar(n,d));
						bw.flush();
					}	
					break;
					
					case '*': //Multiplicacion (N1*N2) / (D1*D2)
					{
						n = ( (Integer.parseInt(expression[0]) * Integer.parseInt(expression[4])));
						d = Integer.parseInt(expression[2]) * Integer.parseInt(expression[6]);
						bw.write(simplificar(n,d));
						bw.flush();
					}	
					break;
					
					case '/': //División: (N1/D1) / (N2/D2), esto es (N1*D2)/(N2*D1)
					{
						n = ( (Integer.parseInt(expression[0]) * Integer.parseInt(expression[6])));
						d = Integer.parseInt(expression[2]) * Integer.parseInt(expression[4]);
						bw.write(simplificar(n,d));
						bw.flush();
					}	
					break;
				}
			}
		}
		catch(Exception ex) {}
		
	}
	
	public static String  simplificar(int n, int d) {
		return n+" / "+d + " = " +(n/MCD_Euclides(n, d)+ " / " + (d/MCD_Euclides(n, d)));
	}
	
	public static int MCD_Euclides(int a, int b){
	    while(b != 0){
	         int t = b;
	         b = a % b;
	         a = t;
	    }
	    return a;
	}

}

