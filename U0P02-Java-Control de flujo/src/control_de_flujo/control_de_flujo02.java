package control_de_flujo;
import java.util.Scanner;
public class control_de_flujo02 {
	static Scanner leer=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadena, resultado="";
		System.out.println("Vamos a introducir cinco cadenas");
		
		for(int i=0;i<5;i++) {
			System.out.println("Introduzca una cadena:");
			cadena=leer.next();
			resultado+=cadena;
		}
		System.out.println(resultado);
	}
}
