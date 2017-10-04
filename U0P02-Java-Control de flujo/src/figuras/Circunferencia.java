package figuras;

public class Circunferencia extends Figuras{

	private double radio;
	private static double pi=3.14;
	
	public Circunferencia(double radio) {
		this.radio=radio;
	}
	
	public double calcArea() {
		return Math.PI*Math.pow(radio, 2);	
	}
	public double calcPerimetro() {
		return 2*pi*radio;
		
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return super.toString()+
 "Circunferencia [radio=" + radio + "]";
	}
	
	
}
