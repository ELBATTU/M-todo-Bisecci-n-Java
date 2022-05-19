package Parcial1;
import java.util.Scanner;

public class Biseccion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a,b,c = 0,FC,Fxa,Fxb;
		int opcion= 0, SN=0;
		
		System.out.println("¿Validar convergencia?\n1: Si\n2: No");
		opcion = sc.nextInt();
		while(opcion == 1) {
			 System.out.println("Limite inferior del intervalo A");
			 a = sc.nextDouble();
			 System.out.println("Limite superior del intervalo B");
			 b = sc.nextDouble();
			 if (f(a)*f(b) >= 0) {
				 System.out.println("No hay raiz entre el intervalo");
				 System.out.println("\n¿Deseas continuar?\n1: Si\n2: No");
				 opcion = sc.nextInt();
			 }else {
				 System.out.println("¿Iniciar proceso iterativo?\n1: Si\n2: No");
				 SN = sc.nextInt();
				 if(SN == 1) {
					 FC = 100;
					 while(FC > Math.pow(10, -12)) {
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
					 
					 System.out.println("\n¿Deseas continuar?\n1: Si\n2: No");
					 opcion = sc.nextInt();
				 }
			 }	
		}
	}
	public static double f(double x) {
		//double ec = (x-1);
		//x=Math.pow(ec, 3)-1;
		x = Math.pow(x, 3)+Math.pow(Math.E, x)-4*x-1;
		return x;
	}
}
