package Parcial2;

import java.util.Scanner;

public class PosicionFalsa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Declaración de variables
		double a = 0,b = 0,error = 0,ca = 0,c = 0,fa,fb;
		
		//Valida convergencia
		
		fa = 1;
		fb = 1;
		
		while (fa*fb > 0) {
			System.out.println("Dame a");
			a = sc.nextDouble();
			System.out.println("Dame b");
			b = sc.nextDouble();
			fa = f(a);
			fb = f(b);
		}
		//Procedimiento iterativo de conversión a las raíces de la f(x) = 0 que cruzan el eje x
		error = 1;
		c = ((a*f(b) - b*f(a)) / (f(b)-f(a))) + 100;
		while (error > Math.pow(10, -12)) {
			ca = c;
			c = ((a*f(b) - b*f(a)) / (f(b)-f(a)));
			if (f(a)*f(c) > 0) {
				a = c;
			}
			if (f(b)*f(c) > 0) {
				b = c;
			}
			error = Math.abs(ca - c);
		}
		
		System.out.println("La raíz es: " + c);
		System.out.println("El error es: " + error);
	}
	//Declaración de la función
	public static double f(double x) {
		x = -2*Math.pow(x, 2)+x+4;
		return x;
	}

}
