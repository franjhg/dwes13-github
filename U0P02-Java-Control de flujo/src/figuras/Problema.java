package figuras;

public class Problema {
	
	private  Circunferencia cir1;
	private  Circunferencia cir2;
	private Cuadrado c;
	private Triangulo t;
	
	
public Problema(Circunferencia cir1, Circunferencia cir2, Cuadrado c, Triangulo t) {
	this.cir1=cir1;
	this.cir2=cir2;
	this.c=c;
	this.t=t;
}

	

	
	public double area(Triangulo t, Cuadrado c, Circunferencia cir1, Circunferencia cir2) {
		return (t.area()+c.area()+(cir1.area()/2)+((3*cir2.area())/4));
	}
	public double perimetro(Triangulo t, Cuadrado c, Circunferencia cir1, Circunferencia cir2) {
		return (t.perimetro()+(2*c.getLado())+(cir1.perimetro()/2)+((3*cir2.perimetro())/4)-(2*cir1.getRadio())-(2*cir2.getRadio()));
	}
}
