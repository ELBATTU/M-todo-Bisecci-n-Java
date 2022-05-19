package Parcial3;

import java.util.Scanner;


public class MetodoGauss_Seidel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0, i =0, j = 0, k = 0, dominante = 0, R = 0;
		double denominador = 0, maximo = 0, acumulado = 0, tolerancia  = 0;
		System.out.println("Cantidad de ecuaciones");
		n = sc.nextInt();
		double [][] a =  new double [n+1][n+1];
		double [] x =  new double [n+1];
		double [] xa =  new double [n+1];
		double [] b =  new double [n+1];
		//Registra los coeficientes de las ecuaciones en a[n][n], los terminos independientes en b[n] e igualar x[i] = 0
		i = 1;
		while (i <= n) {
			System.out.println("Registrar el valor de los coeficientes de la ecuacion "+i);
			j = 1;
			while (j <= n) {
				System.out.println("a["+i+"-"+j+"]");
				a[i][j] = sc.nextDouble();
				j++;
			}
			System.out.println("Término independiente de la ecuación "+ i);
			b[i] =  sc.nextDouble();
			i++;
		}
		//Validar la convergencia
		i = 1;
		dominante = 1;
		while (i <= n && dominante == 1) {
			j = 1;
			while (j <= n) {
				if (i != j) {
					if ((a[i][i] <= a[i][j] || a[i][i] <= a[j][i]) && dominante == 1) {
						dominante = 0;
					}
				}
				j++;
			}
			i++;
		}
		i--;
		if (dominante == 0) {
			System.out.println("El coeficiente "+a[i][i]+ " de la ecuacion "+ i +" no es dominante");
			System.out.println("FIN DEL PROGRAMA");
		}
		//Calcular el valor de las variables x del sistema de ecuaciones
		maximo = 1000;
		 tolerancia  = Math.pow(10, -12);
		while (maximo >= tolerancia) {
			i = 1;
			while(i <= n) {
				xa[i] = x[i];
				i++;
			}
			i = 1;
			while (i <= n) {
				 acumulado  = 0;
				j = 1;
				while (j <= n) {
					if (i == j) {
						denominador = a[i][i];
					}else {
						acumulado = acumulado - a[i][j]*x[j];
					}
					j++;
				}
				x[i] = (b[i] + acumulado) / denominador;
				i++;
			}
		
		//Calcular el error
		maximo = 0;
		i = 1;
		while (i <= n) {
			if (maximo < Math.abs(x[i] - xa[i])) {
				maximo = Math.abs(x[i] - xa[i]);
			}
			i++;
		}
	}
		//IMPRIMIR LOS VALORES DE X
		R = 1;
		System.out.println("Los valores de ´x´ son:");
		while (R <= n) {
			System.out.print("----------------------------------\n");
			System.out.println("x"+R+" = "+x[R]+ " \nError "+maximo);
			R++;
		}
	}

}
