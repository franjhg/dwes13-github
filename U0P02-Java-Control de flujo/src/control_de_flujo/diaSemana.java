package control_de_flujo;
import java.util.Scanner;
public class diaSemana {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {

		String d;
		System.out.println("Introduzca un dia de la semana:");
		d=leer.nextLine();
		switch (d) {
		case "lunes": case "martes": case "miercoles": case "jueves": case "viernes":
			System.out.println(d+" es laborable");
			break;
		case "sabado": case "domingo":
			System.out.println(d+" no es laborable");
			break;
		default:
			System.out.println("Debe introducir un dia de la semana");
		}
	}
}
