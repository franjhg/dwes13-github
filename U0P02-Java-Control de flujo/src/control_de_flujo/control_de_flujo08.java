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
		
		switch(op) {
		case 1:
			do {
				int op1;
			System.out.println("1. Electricos");
			System.out.println("2. Diesel");
			System.out.println("3. Gasolina");
			System.out.println("4. Volver al menu principal");
			op1=leer.nextInt();
			switch(op1) {
			case 1:System.out.println("COCHES/ELECTRICOS");
				break;
			case 2:System.out.println("COCHES/DIESEL");
				break;
			case 3:System.out.println("COCHES/GASOLINA");
				break;
			case4:
				break;
			}
			
			}while();
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
		
		}while(op!=3);	
		
		
	}

}

/*public static void ejercicio8() {
		int opcion1, opcion2, lado, base, altura, area, perimetro;

		do {

			System.out.println("Elige una opcion\n"
					+ "1. Calcular Ã¡reas.\n"
					+ "2. Calcular perÃ­metros.\n"
					+ "3. Salir.");
			opcion1=validarValoresEntero(1, 3);

			switch (opcion1) {
			case 1:
				do {
					System.out.println("Elige una opciÃ³n\n"
							+ "1. Ã�rea del cuadrado.\n"
							+ "2. Ã�rea del rectangulo.\n"
							+ "3. Volver.");
					opcion2=validarValoresEntero(1, 3);

					switch (opcion2) {
					case 1:
						System.out.println("Introduce el lado del cuadrado:");
						lado=validarEntero();
						area=(int)Math.pow(lado, 2);
						System.out.println("El Ã¡rea del cuadrado de lado "+lado+" es: "+area+".");
						break;
					case 2:
						System.out.println("Introduce la base del rectÃ¡ngulo:");
						base=validarEntero();
						System.out.println("Introduce la altura del rectÃ¡ngulo:");
						altura=validarEntero();
						area=base*altura;
						System.out.println("El Ã¡rea del rectÃ¡ngulo de base "+base+" y altura "+altura+" es: "+area+".");
						break;

					default:
						break;
					}
				}while(opcion2!=3);
				break;
			case 2:
				do {
					System.out.println("Elige una opciÃ³n\n"
							+ "1. PerÃ­metro del cuadrado.\n"
							+ "2. PerÃ­metro del rectangulo.\n"
							+ "3. Volver.");
					opcion2=validarValoresEntero(1, 3);

					switch (opcion2) {
					case 1:
						System.out.println("Introduce el lado del cuadrado:");
						lado=validarEntero();
						perimetro=lado*4;
						System.out.println("El perÃ­metro del cuadrado de lado "+lado+" es: "+perimetro+".");
						break;
					case 2:
						System.out.println("Introduce la base del rectÃ¡ngulo:");
						base=validarEntero();
						System.out.println("Introduce la altura del rectÃ¡ngulo:");
						altura=validarEntero();
						perimetro=(base+altura)*2;
						System.out.println("El perÃ­metro del rectÃ¡ngulo de base "+base+" y altura "+altura+" es: "+perimetro+".");
						break;

					default:
						break;
					}
				}while(opcion2!=3);

				break;
			default:
				break;

			}
		}while(opcion1!=3);
	}*/
