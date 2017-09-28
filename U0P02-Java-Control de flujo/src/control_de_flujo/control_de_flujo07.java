package control_de_flujo;
import java.util.Scanner;
public class control_de_flujo07 {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {
		int a, acum;
		int b;
		System.out.println("Introduzca un numero:");
		a=leer.nextInt();
		b=a-1;
		acum=a;
		do {
			acum=acum*b;
			b-=1;
			}while(b!=1);
			
		System.out.println("El factorial de "+a+" es "+acum);

	}

}
