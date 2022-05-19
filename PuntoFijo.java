package Parcial1;

import java.util.Scanner;

public class PuntoFijo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Declaración de variables
		double a = 0,b = 0,x = 0,xa = 0;
		String intervalo = "",otrointent = "",hayraiz = "";
	
		System.out.println("¿Validar que hay raiz en el intervalo?");
		intervalo = sc.nextLine();
		while (intervalo.equalsIgnoreCase("S")) {
			otrointent = "S";
			while (otrointent == "S") {
				System.out.println("Dame el valor del limite inferior");
				a = sc.nextDouble();
				System.out.println("Dame el valor del limite superior");
				b = sc.nextDouble();				
				if (f(a)*f(b) < 0) {
					hayraiz = "S";
					otrointent = "N";
				}
				if (f(a)*f(b) > 0) {
					hayraiz = "N";
					otrointent = "S";
				}
				if (f(a)*f(b) == 0) {
					if (f(a) == 0) {
						x = a;
					}else {
						x = b;
					}
					otrointent = "N";
					hayraiz = "N";
				}
			}
			if (hayraiz == "S") {
				x = (a+b)/2;
				xa = x + 100;
				while (xa - x > 1*Math.pow(10, -13)) {
					xa = x;
					x = g(x);
				}
			}
			System.out.println("La raiz está en: "+ x);
			System.out.println("La precisión es de: "+Math.abs(xa-x));
			otrointent = "N";
			System.out.println("¿Otro intervalo?\n"+intervalo);
		}
	}
	//Declaración de funciónes
	public static double f(double x) {
		x=Math.pow(x, 3)-Math.sin(x);
		return x;
	}
	public static double g(double x) {
		x = Math.pow(Math.sin(x), 0.333333);
		return x;
	}
}
