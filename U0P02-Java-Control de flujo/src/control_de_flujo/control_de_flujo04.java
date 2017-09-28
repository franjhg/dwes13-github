package control_de_flujo;
import java.util.Scanner;

public class control_de_flujo04 {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {
	
		int a;
		boolean b=true;
		System.out.println("Introduzca un numero 1..10");
		while (b==true){
	/*	try {
		System.out.println("Introduzca un numero");
		a=leer.nextInt();
		b=false;
		System.out.println("Adios");
		}
		catch(Exception e) {
			System.out.println("No es numero");
			leer=new Scanner(System.in);
		}*/
			try {
			//System.out.println("Introduzca un numero 1..10");
			a=leer.nextInt();
			if((a>=1)&&(a<=10)) {
				System.out.println("OK");
				b=false;
			}else {
				System.out.println("de 1..10");
			
			}
			}
			catch(Exception e) {
				System.out.println("Debe ser un numero");
				System.out.println("Introduzca un numero 1..10");
				leer=new Scanner(System.in);
			}
		}
	}
}
