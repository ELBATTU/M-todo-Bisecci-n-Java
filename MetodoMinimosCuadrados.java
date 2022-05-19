package Parcial5;

import java.util.Scanner;

public class MetodoMinimosCuadrados {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Declaracion de variables
		int i,j,k,n,m,ik,jk;
		double sumak,sumaj,interpolar,akk,num_pivote;
		m = 6; //Cantidad de observaciones discretas
		double [] x =  new double [m];	
		double [] y =  new double [m];	
		n = 2; //Polinomio de segundo grado
		double [][] a =  new double [n+1][n+1];	
		
		//Capturar observaciones discretas en los vectores x[k] y y[k]
		i=0;
   	 System.out.println ("\n\nEcuacion "+(i+1));
   	 while(i<m){
	 		System.out.print ("\n X"+(i+1)+" = ");
	 		x[i]=Float.parseFloat(sc.next());
   	 	System.out.print ("\n Y"+(i+1)+" = ");
   	 	y[i]=Float.parseFloat(sc.next());
   	 	i=i+1;
   	 }	
		//Valor de x a interpolar, entre el intervalo (280,1700)
		interpolar = 800;
		//Registrar el la matriz cuadrada los valores que se calcularán por el método de mínimos cuadrados
		i = 0;
		while (i < n) {
			j = 0;
			while (j < n) {
				sumak = 0;
				k = 0;
				while (k < m) {
					sumak =sumak+Math.pow(x[k],i+j-2);			
					k++;
				}
				a[i][j] = sumak;
				j++;
			}
			k = 0;
			sumak = 0;
			while (k < m) {
				sumak =sumak+Math.pow(y[k]*x[k],i);
				k++;
			}
			a[i][j] = sumak;
			i++;
		}
		//Calcular los valores del término independiente y los coeficientes, a del polinomio para interpolar un valor de x dentro del intervalo
		//(a,b) por el método de Gauss-Jordan
		j = 0;
		//Calcula los valores del renglón pivote
		while (j < n) {
			jk = 0;
			akk = a[j][j];
			while (jk < (n+1)) {
				a[j][jk] = a[j][jk]/akk;
				jk++;
			}
			//Calcula los valores de la matriz identidad y los valores de a
			ik = 0;
			while (ik < n) {
				if (ik != j) {
					jk = 0;
					num_pivote = -(a[ik][j]);
					while (jk < (n+1)) {
						a[j][jk] = num_pivote*a[j][jk]+a[ik][jk];
						jk++;
					}
				}
				ik++;
			}
			j++;
		}
		//Calcular el error absoluto de E |f(x) - p(x)|
		j = 0;
		sumaj = 0;
		while (j < (n+1)) {
			ik = 0;
			interpolar = x[j];
			sumak = 0;
			while (ik < (n+1)) {
				sumak = sumak+a[ik][n]*Math.pow(interpolar, i);
				ik++;
			}
			sumaj = sumaj + Math.abs(sumak - y[j]);
			j++;
		}
		System.out.println("El error absoluto entre f(x) y p(x) = "+ sumaj);
		//Interpolar el valor de x dentro del intervalo (a,b)
		interpolar = 800;
		ik = 0;
		sumak = 0;
		while (ik < (n+1)) {
			sumak = sumak+a[ik][n]*Math.pow(interpolar, ik);
			ik++;
		}
		System.out.println("La interpolacion de "+ interpolar + " = " + sumak);
	}

}
