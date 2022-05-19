package Parcial3;

import java.util.Scanner;

public class MetodoEliminacionGaussiana {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//DECLARACIÓN DE VARIABLES
		int i=0,n=0,ik=0,jk=0,R=0,C=0,j = 0;
		double num_pivote,acumula;
	
		System.out.println("Cantidad de ecuaciones");
		n = sc.nextInt();
		//TAMAÑO DE LA MATRIZ Y VECTOR
		double [][] A =  new double [n+1][n+1];
		double [] B = new double [n+1];		
		i = 1;
		//LLENADO DE LA MATRIZ Y VECTOR
		while (i <= n) {
			j = 1;
			while (j <= n) {
				System.out.println("Ingresa el valor para la matriz ["+i+"]["+j+"]");
				A[i][j] = sc.nextInt();
				j = j+ 1;
			}
			System.out.println("Ingresa el valor para el vector ["+i+"]");
			B[i] = sc.nextInt();
			i = i+ 1;
		}
		//TRANSFORMACIÓN DE LA MATRIZ CUADRADA A TRIANGULAR
		i = 1;
		while (i <= n) {
			ik = i + 1;
			while(ik <= n) {
				jk = i;
				num_pivote = (-A[ik][i]) / A[i][i];
				while (jk <= n) {
					A[ik][jk] = (num_pivote*A[i][jk])+A[ik][jk];
					jk = jk + 1;
				}
				B[ik] = num_pivote*B[i] + B[ik];
				ik = ik + 1;
			}
			i = i + 1;
		}
		//CALCULAR LOS VALORES DE X A PARTIR DE LA MATRIZ TRIANGULAR
		R = n;
		while (R >= 1) {
			C = R + 1;
			acumula = 0;
			while (C <= n) {
				acumula = acumula + (A[R][C]*B[C]);
				C = C + 1;
			}
			B[R] = (B[R] - acumula) / A[R][R];
			R = R - 1;			 
		}
		//IMPRIMIR LOS VALORES DE X
		R = 1;
		System.out.println("Los valores de ´x´ son:");
		while (R <= n) {
			System.out.println("x"+R+" = "+B[R]);
			R = R + 1;
		}
	}
}