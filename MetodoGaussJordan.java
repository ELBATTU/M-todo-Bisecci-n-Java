package Parcial3;

import java.util.Scanner;

public class MetodoGaussJordan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Declaración de variables
		int J = 0,N = 0,JK = 0, IK = 0,R = 0,C = 0;
		double num_pivote = 0, akk = 0, acumula = 0;
		// Tamaño de la matriz
		System.out.println("Cantidad de ecuaciones");
		N = sc.nextInt();
		double [][] A =  new double [N+1][N+1];
		double [] B = new double [N+1];	
		// Registra los valores de la matriz ampliada
		J = 1;
		//LLENADO DE LA MATRIZ Y VECTOR
		while (J <= N) {
			JK = 1;
			while (JK <= N) {
				System.out.println("Ingresa el valor para la matriz ["+J+"]["+JK+"]");
				A[J][JK] = sc.nextDouble();
				JK++;
			}
			System.out.println("Ingresa el valor para el vector ["+J+"]");
			B[J] = sc.nextDouble(); 
			J++;
		}
		//Obtener la matriz identidad y los valores de las variables x
		J = 1;
		while (J <= N) {
			//Calcular los valores del renglón pivote
			JK = 1;
			akk = A[J][J];
			while (JK <= N) {
				A[J][JK] = A[J][JK]/akk;
				JK++;
			}
			B[J] = B[J]/akk;
			//Calcular los valores de la matriz identidad y los valores del vector B
			IK = 1;
			while (IK <= N) {
				if (IK != J) {
					JK = 1;
					num_pivote = -A[IK][J];
					while (JK <= N) {
						A[IK][JK] = num_pivote*A[J][JK] + A[IK][JK];
						JK++;
					}
					B[IK] =  num_pivote*B[J] + B[IK];
				}
				IK++;
			}
			J++;
		}
		//CALCULAR LOS VALORES DE X A PARTIR DE LA MATRIZ TRIANGULAR
				R = N;
				while (R >= 1) {
					C = R + 1;
					acumula = 0;
					while (C <= N) {
						acumula += (A[R][C]*B[C]);
						C++;
					}
					B[R] = (B[R] - acumula) / A[R][R];
					R = R - 1;			 
				}
				//IMPRIMIR LOS VALORES DE X
				R = 1;
				System.out.println("Los valores de ´x´ son:");
				while (R <= N) {
					System.out.println("x"+R+" = "+B[R]);
					R = R + 1;
				}
    }

}
