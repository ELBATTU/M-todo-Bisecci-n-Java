package Parcial4;

public class Algoritmo_Romberg {

	public static void main(String[] args) {
		int  k = 0, j = 0, m = 0;
		double suma = 0, ha = 0, b = 0, a = 0, n = 0, h = 0;
		m = 5; //cantidad de iteraciones de k
		double [][] O =  new double [m][m];		
		a = 0; //limite inicial
		b = 5; //limite final
		k = 0; //iteracion k 
		n = 1; //cantidad de intervalos		
		//Generar los valores de la columna 1 con la formula trapezoidal		
		while(k<m){
            h = (b - a)/n;
            j = 1; 
            suma = 0;
                 while(j <= (n - 1)){
                     suma = suma + (2*(Math.pow(a+j*h, 2)+2*(a+j*h)+1));
                    j++;
            }
            O[k][0] = (suma + (Math.pow(a, 2)+2*a+1) + (Math.pow(b, 2)+2*b+1)) * (h/2); 
            n = 2 * n;
            k++;
	}		
		//Preciosar los valores aproximados de las integrales e f^(k) (x) con la extrapolación de Richardson		
		j = 1;
        while(j < m){
            k = j;
            ha = 1/((Math.pow(4, (j + 1) - 1)) - 1);
                    while(k < m){
                        O[k][j] = O[k][j-1] + (ha * (O[k][j-1]-O[k-1][j-1]));
                        k++;
           }
            j++;
	}
        System.out.println("El valor del área entre ["+ a +" - "+ b +"] = " + O[m-1][m-1]);
		System.out.println("Error absoluto = " + Math.abs(O[m-1][m-1] - O[m-1][m-2]));
		System.out.println("Error relativo = " + (Math.abs(O[m-1][m-1] - O[m-1][m-2])) /O[m-1][m-1]);
		
	}
}
