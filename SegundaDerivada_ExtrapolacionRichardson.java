package Parcial4;

public class SegundaDerivada_ExtrapolacionRichardson {

	public static void main(String[] args) {
		int i = 0,j = 0,m = 0,x = 0;
		double h = 0,xmash = 0,xmenosh = 0,k = 0;
		m = 4;
		double [][] N =  new double [m+1][m+1];
		x = 5;	//valor de x
		h = 0.2; //paso inicial
		
		//Aproxima el valor en x de la segunda derivada de f(x) con la fórmula centrada
		i = 1; //Posicion del renglón
		j = 1; // Posicion de la columna en el arreglo
		while (i <= m) {
			k = (h / (Math.pow(2, i-1)));	//paso
			xmash = x + k;
			xmenosh = x - k;
			N[i][j] = ((((Math.pow(xmash, 2)) + (2*xmash) + 1) + (((Math.pow(xmenosh, 2)) + (2*xmenosh) + 1)) 
					- (2 * ((Math.pow(x, 2)) + (2*x) + 1))) / (Math.pow(k, 2)));
			i++;
		}
		//Precisa con las aproximaciones de la segunda derivada de f(X) en el punto x con la extrapolacion de Richardson
		j++;
		while (j <= m) {
			i = j;
			k = 1 / ((Math.pow(4, (j-1))) - 1);
			while (i <= m) {
				N[i][j] = N[i][j-1] + k * (N[i][j-1] - N[i-1][j-1]);
				i++;
			}
			j++;
		}
		//Despliega la precision del valor en x de la segunda derivada de f(x) con 10^-10
		System.out.println("RESULTADO DE LA SEGUNDA DERIVADA\n");
		System.out.println("f´´("+x+") = "+N[m][m]);
		System.out.println("Error "+Math.abs(N[m][m] - N[m][m-1]));
	}

}
