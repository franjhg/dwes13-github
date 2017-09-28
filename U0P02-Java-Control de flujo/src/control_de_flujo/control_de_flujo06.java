package control_de_flujo;
import java.util.Scanner;
public class control_de_flujo06 {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {
		
		int a,b;
		
		System.out.println("Introduzca un numero del 1 al 10:");
		a=leer.nextInt();
		System.out.println("Introduzca otro numero;");
		b=leer.nextInt();
		
		while(a<b) {
			System.out.println("*");
			a+=1;
		}
		if(a==b||a>b) {
			System.out.println(a+"---"+b);
		}
	}

}
