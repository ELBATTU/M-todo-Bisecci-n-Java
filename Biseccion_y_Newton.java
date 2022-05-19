package Parcial2;

import java.util.Scanner;

public class Biseccion_y_Newton {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a,b,c = 0,FC;
		double converge = 0, xo = 0, xa = 0, error = 0;
		String opcion= "", SN="",sm="";
		System.out.println("---------------------------------------------------------");
		System.out.println("MÉTODO DE BISECCIÓN");
		System.out.println("---------------------------------------------------------\n");
		System.out.println("¿Validar convergencia?");
		opcion = sc.nextLine();
		while(opcion.equalsIgnoreCase("S")) {
			 System.out.println("Limite inferior del intervalo A");
			 a = sc.nextDouble();
			 System.out.println("Limite superior del intervalo B");
			 b = sc.nextDouble();
			 if (f(a)*f(b) >= 0) {
				 System.out.println("No hay raiz entre el intervalo\nIntentalo de nuevo\n");
			 }else {
				 System.out.println("¿Iniciar proceso iterativo?");
				 SN = sc.next();
				 if(SN.equalsIgnoreCase("S")) {
					 FC = 100;
					 while(FC > 1*Math.pow(10, -12)) {
						 c = (a+b)/2;
						 FC = f(c);
						 if(f(a)*FC < 0) {
							 b=c;
						 }
						if (FC*f(b) < 0) {
							 a=c;
						}						
					 }
					 System.out.println("La raiz esta en x = "+ c);
					 System.out.println("f(" + c + ") = "+ FC);
					 opcion = "N";
					 System.out.println("\nFIN DEL MÉTODO DE BISECCIÓN\n");
				 }
			 }	
		}
		System.out.println("---------------------------------------------------------");
		System.out.println("MÉTODO DE NEWTON");
		 System.out.println("---------------------------------------------------------\n");
		//Validación de convergencia
			converge = 2;
			System.out.println("¿Deseas validar la convergencia?");
			sm = sc.next();
				while (converge >= 1 && sm.equalsIgnoreCase("S")) {
					System.out.println("Dame el valor inicial");
					xo = sc.nextDouble();
					converge = f(xo)*f2(xo)/Math.pow(f1(xo), 2);
					if (converge >= 1) {
						sm = "N";
						System.out.println("No converge");
						System.out.println("¿Otro xo? "+sm);
					}
				}
				//Proceso de iteraciones
				if (sm.equalsIgnoreCase("S")) {
					error = 2;
					while (error > 1*Math.pow(10, -12)) {
						xa = xo;
						xo = xo-f(xo)/f1(xo);
						error = xa -xo;
					}
					System.out.println("La raíz es: "+xo);
				}
				System.out.println("\nFIN DEL MÉTODO DE NEWTON");
	}
	//Declaración de funciones
	public static double f(double x) {
		x = 3*Math.pow(x, 3)+16*Math.pow(x, 2)-12*Math.log(x)-16;
		return x;
	}
	public static double f1(double x) {
		x=9*Math.pow(x, 2)+32/x;
		return x;
	}
	public static double f2(double x) {
		x=18*x+32+12/Math.pow(x, 2);
		return x;
	}

}
