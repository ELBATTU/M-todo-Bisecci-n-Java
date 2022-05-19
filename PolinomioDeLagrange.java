package Parcial5;

public class PolinomioDeLagrange {

	public static void main(String[] args) {
		//Declaracion de variables
		int n, i, j;
		double c, num, acum;
		n = 4; //Observaciones discretas. No hay funcion
		n = n - 1; //Polinomio de segundo grado
		//Declaracion de arreglos
		double [] x =  new double [4];
		double [] y =  new double [4];		
		//Capturar las observaciones discretas
		x[0] = 3;
		x[1] = 4;
		x[2] = 5;	
		x[3] = 7;
		y[0] = 2;
		y[1] = 5;
		y[2] = -3;	
		y[3] = -4;
		//Valor a interpolar
		c = 1;		
		//Inicia procedimiento para aproximar la interpolacion de x por el polinomio Pn(x)
		i = 0;
		acum = 0;
		while (i <= n) {
			j = 0;
			num = 1;
			while (j <= n) {
				if (i != j) {
					num = num * ((c - x[j]) / (x[i] - x[j]));
					System.out.println(num);
				}
				j++;
			}
			acum = acum + num * y[i];
			i++;
		}		
		//Desplegar el valor de interpolacion de x
		System.out.println("--------------------------------------");
		System.out.println("ALGORITMO DE POLINOMIO DE LAGRANGE");
		System.out.println("--------------------------------------\n");
		System.out.println("######################################");
		System.out.println("\t\tDATOS:\n");		
		System.out.println("Los valores de ''X'' son:\n");
		for (int k = 0; k < x.length; k++) {
			System.out.println("X["+k+"] = "+x[k]);
		}
		System.out.println("\nLos valores de ''Y'' son:\n");
		for (int k = 0; k < y.length; k++) {
			System.out.println("Y["+k+"] = "+y[k]);
		}				
		System.out.println("\nEl valor a interpolar es: "+c);
		System.out.println("######################################");
		System.out.println("\n--------------------------------------");
		System.out.println("\t\tRESULTADO\n");;
		System.out.println("La interpolación de Pn("+c+") = " + acum);
		System.out.println("--------------------------------------");
	}
}
