package Parcial4;

public class DerivadaExtrapolacionRichadson {

	public static void main(String[] args) {
		//Declaracion de variables y arreglo
		int x = 0, m = 0, i = 0, j = 0;
		double xmash, xmenosh, k, h;
		
		x = 5; //punto x
		h = 0.2; //paso
		m = 4; //cantidad de iteraciones
		
		double [][] N =  new double [m+1][m+1];
		//Aproximar m valores de la dervivada con la fórmula centrada
		i = 1; //renglon
		j = 1; //columna
		while (i <= m) { 
			k =  (Math.pow(2, (i-1)))/(2*h);
			xmash = x + (h / (Math.pow(2, (i-1))));
			xmenosh = x - (h / (Math.pow(2, (i-1))));
			N[i][j] = k*((Math.pow(xmash, 2) + 2*xmash + 1) - (Math.pow(xmenosh, 2) - 2*xmenosh - 1));
			i++;
		}
		//Precisar el valor aproximado de la derivada, por lo mucho 10^-10
		j++;
		while (j <= m) {
			i = j;
			k = 1/((Math.pow(4, (j-1)))-1);
			while (i <= m) {
				N[i][j] = N[i][j-1] + (k*(N[i][j-1] - N[i-1][j-1]));
				i++;
			}
			j++;
		}
		//Desplegar el valor de la derivada y el error
		System.out.println("RESULTADO DE LA DERIVADA\n");
		System.out.println("f´("+x+") = " + N[m][m]);
		System.out.println("Error = " + Math.abs(N[m][m] - N[m][m-1]));
	}
}
