package control_de_flujo;
import java.util.Scanner;
public class control_de_flujo03 {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {
		int a, acum=0;
		
		do {
		System.out.println("Introduzca un numero menor de 50:");
		a=leer.nextInt();
		acum+=a;
		}while (acum<50);
		System.out.println("La suma de los numeros es "+acum);
	}

}
