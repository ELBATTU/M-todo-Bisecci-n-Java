package Parcial1;

import java.util.Scanner;

public class MetodoNewton {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Declaración de variables
		double converge = 0, x = 0, xo = 0, xa = 0, error = 0;
		String sn = "";
		//Validación de convergencia
		converge = 2;
		System.out.println("¿Deseas validar la convergencia?");
		sn = sc.nextLine();
			while (converge >= 1 && sn.equalsIgnoreCase("S")) {
				System.out.println("Dame el valor inicial");
				xo = sc.nextDouble();
				converge = f(xo)*f2(xo)/Math.pow(f1(xo), 2);
				if (converge >= 1) {
					sn = "N";
					System.out.println("No converge");
					System.out.println("¿Otro xo? "+sn);
				}
			}
			//Proceso de iteraciones
			if (sn.equalsIgnoreCase("S")) {
				error = 2;
				while (error > 1*Math.pow(10, -12)) {
					xa = xo;
					xo = xo-f(xo)/f1(xo);
					error = xa -xo;
				}
				System.out.println("La raíz es: "+xo);
			}
	}
	//Declaración de funciónes
		public static double f(double x) {
			x=3*Math.pow(x, 3)-12*Math.pow(x, 2);
			return x;
		}
		public static double f1(double x) {
			x=3*Math.pow(x, 2)+4*x;
			return x;
		}
		public static double f2(double x) {
			x=6*x+4;
			return x;
		}

}
