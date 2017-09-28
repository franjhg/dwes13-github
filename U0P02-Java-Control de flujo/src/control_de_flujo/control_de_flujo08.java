package control_de_flujo;
import java.util.Scanner;
public class control_de_flujo08 {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {
		
		int op;
		do {
		System.out.println("Elija una opcion:");
		System.out.println("1. Coches");
		System.out.println("2. Motos");
		System.out.println("3. Camiones");
		
		op=leer.nextInt();
		}while(op!=3);
		switch(op) {
		case 1:
			System.out.println("1. Electricos");
			System.out.println("2. Diesel");
			System.out.println("3. Gasolina");
			System.out.println("4. Volver al menu principal");
			break;
		case 2:
			System.out.println("1. Gasolina");
			System.out.println("2. Electrica");
			System.out.println("3. Volver al menu principal");
			break;
		case 3:
			System.out.println("1. Diesel");
			System.out.println("2. Gasolina");
			System.out.println("3. Volver al menu principal");
			break;
		default:
			System.out.println("Opcion del 1 al 3");
			break;
		}
		
			
		
		
	}

}
