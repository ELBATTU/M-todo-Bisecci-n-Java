package Parcial5;

import java.util.Scanner;

public class InterpolacionPorElPolinomioDeNewton {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//declaracion de variables
		int m, i, j, r, c;
		double s, mult;
		
		//declarar arreglo
		m = 6;
		double [][] x =  new double [m-1][m];	
		System.out.println("Algoritmo Polinomio de Newton\n--------------------------------------\n");
		//capturar datos observados de "x" y "y"
		i = 0;
		while (i < (m-1)) {
			System.out.println("Ingrese el valor de X ["+i+",0]");
			x[i][0] = Double.parseDouble(sc.next());
			System.out.println("Ingrese el valor de Y ["+i+",1]");
			x[i][1] = Double.parseDouble(sc.next());
			i++;
		}
		System.out.println("Ingrese el valor de X a interpolar");
		c = Integer.parseInt(sc.next());
		j = 2;
		i = 100;
		mult = 1;
		s = x[0][1];
		//procedimiento para el calculo para interpolar x
		while (j <= i) {
			i = j-1;
			r = i;
			mult = mult * (c-x[i-1][0]);
			s = s + mult * ((x[i][j-1] - x[i-1][j-1]) / (x[i][0] - x[i-r][0]));
				while (i < (m-1)) {
					x[i][j] = (x[i][j-1] - x[i-1][j-1]) / (x[i][0] - x[i-r][0]);
					i++;
				}
				j++;
		}
		//Desplegar el resultado final
		System.out.println("\nRESULTADO\n-------------------------------");
		System.out.println("Valor interpolado de: "+c);
		System.out.println("f("+c+") = "+s+"\n");
		for (int y = 0; y < (m-1); y++) {
			for (int a = 0; a < 2; a++) {
				System.out.print("[ "+x[y][a] + " ]");
			}
			System.out.println(" ");
		}				
	}
}
