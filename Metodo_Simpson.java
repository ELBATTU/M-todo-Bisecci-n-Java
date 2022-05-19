package Parcial4;

public class Metodo_Simpson {

	public static void main(String[] args) {
		double k1 = 0, k2 = 0, k3 = 0, Q = 0, L = 0,j1 = 0, j2 = 0, j3 = 0, j4 = 0,integral = 0, 
				XH = 0, y = 0,a = 0, b = 0, c = 0, d = 0, m = 0, n = 0, h = 0, j = 0, x = 0, i = 0;
		
		//Asignar valores a las variables
		
		a = 0;  //limite inferior para x
		b = 5;	//Limite superior para x
		c = 0;	//Limite inferior para y
		d = 5;	//Limite superior para y
		m = 4;	//Cantidad de intervalos para x
		n = 4;	//Cantidad de intervalos para y 
		
		//Asignar el valor inicial a las variables
		
		i = 0;
		j1 = 0;
		j2 = 0;
		j3 = 0;
		j4 = 0;		
		//Inicia proceso de calculo
		
		h = (b-a) / n;
		XH = (d-c) / m;		
		while (i <= n) {
			x = a + (i * h);
			k1 = (Math.pow(x, 2) + (2*(x*c)) + 1) + (Math.pow(x, 2) + (2*(x*d)) + 1);
			k2 = 0;
			k3 = 0;
			j = 1;
			while (j <= (m-1)) {
				y = c + (j * XH);
				Q = (Math.pow(x, 2) + (2*(x*y)) + 1);
				if (j % 2 == 0) {
					k2 = k2 + Q;
				}else {
					k3 = k3 + Q;
				}
				j++;
			}
		L = (k1 + 2*k2 + 4*k3)*XH / 3;
		if (i == 0 || i == m) {
			j1 = j1 + L;
		}else {
			if (i % 2 == 0) {
				j2 = j2 + L;
			}else {
				j3 = j3 + L;
			}
		}
		i++;
	   }
		integral = ((h*(j1 + 2*j2 + 4*j3)) / 3);
		System.out.println("Valor de la integral = "+integral);
	}
}
