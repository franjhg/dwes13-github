package figuras;

public class Problema {
	
	private double radio1, radio2;
	private int lado, base, altura;
	
public Problema();

	/*Triangulo t1=new Triangulo(8, 15);
	Cuadrado c1=new Cuadrado(4.2);
	Circunferencia cir1=new Circunferencia(4.8);
	Circunferencia cir2=new Circunferencia(1.5);*/

	
	public double area(Triangulo t, Cuadrado c, Circunferencia cir1, Circunferencia cir2) {
		return (t.area()+c.area()+(cir1.area()/2)+((3*cir2.area())/4));
	}
	public double perimetro(Triangulo t, Cuadrado c, Circunferencia cir1, Circunferencia cir2) {
		return (t.perimetro()+(2*c.getLado())+(cir1.perimetro()/2)+((3*cir2.perimetro())/4)-(2*cir1.getRadio())-(2*cir2.getRadio()));
	}
}
