package control_de_flujo;
import java.util.Scanner;
public class control_de_flujo05 {
static Scanner leer=new Scanner(System.in);

	public static void main(String[] args) {
		
		int m, a;
		boolean b=true, bis=false;
		
		System.out.println("Introduzca un mes");
		m=leer.nextInt();
		while (b==true){
			try {
				
				//m=leer.nextInt();
				if((m>=1)&&(m<=12)) {
					System.out.println("OK");
					b=false;
				}else {
					System.out.println("de 1..12");
					m=leer.nextInt();
				}
				}
				catch(Exception e) {
					System.out.println("Debe ser un numero");
					System.out.println("Introduzca un numero 1..12");
					leer=new Scanner(System.in);
				}
		}
		
		System.out.println("Introduzca un año:");
		a=leer.nextInt();
			if(a%4==0) {
				bis=true;
			}
		switch(m) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("30");
			break;
		case 2:
			if(bis==true) {
				System.out.println("29");
			}else {
				System.out.println("28");
				
			}
			break;
		}
	}

}
