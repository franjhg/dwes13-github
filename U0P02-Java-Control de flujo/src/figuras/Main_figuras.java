package figuras;

public class Main_figuras {

	public static void main(String[] args) {
		
		Triangulo t1=new Triangulo(8, 15);
		Cuadrado c1=new Cuadrado(4.2);
		Circunferencia cir1=new Circunferencia(4.8);
		Circunferencia cir2=new Circunferencia(1.5);
		
		Problema p=new Problema(cir1, cir2, c1, t1);
		
		System.out.println(p.area(t1, c1, cir1, cir2));
		System.out.println(p.perimetro(t1, c1, cir1, cir2));

	}

}
