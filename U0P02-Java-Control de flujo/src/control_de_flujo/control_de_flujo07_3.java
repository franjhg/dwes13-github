package control_de_flujo;
import java.util.Scanner;
public class control_de_flujo07_3 {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {
		int a;
		System.out.println("Introduzca un numero:");
		a=leer.nextInt();
		int acum=a;
		for (int i=a-1;i>=1;i--) {
			acum=acum*i;
			
		}
		System.out.println("El factorial de "+a+" es "+acum);
	}

}
