package figuras;

public class Main_figuras {

	public static void main(String[] args) {
		
		Triangulo t1=new Triangulo(8, 15);
		Cuadrado c1=new Cuadrado(4.2);
		Circunferencia cir1=new Circunferencia(4.8);
		Circunferencia cir2=new Circunferencia(1.5);
		
	
		
		System.out.println(t1.calcArea()+c1.calcArea()+(cir1.calcArea()/2)+((3*cir2.calcArea())/4));
		System.out.println(t1.calcPerimetro()+(2*c1.getLado())+(cir1.calcPerimetro()/2)+((3*cir2.calcPerimetro())/4)-(2*cir1.getRadio())-(2*cir2.getRadio()));

		System.out.println(cir1.toString());
		System.out.println(cir2.toString());
		System.out.println(c1.toString());
		System.out.println(t1.toString());
		
		
	}

}
