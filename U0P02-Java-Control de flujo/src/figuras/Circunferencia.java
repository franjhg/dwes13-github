package figuras;

public class Circunferencia {

	private double radio;
	private static double pi=3.14;
	
	public Circunferencia(double radio) {
		this.radio=radio;
	}
	
	public double area() {
		return 2*pi*radio;
	}
	public double perimetro() {
		return pi*Math.pow(radio, 2);
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + "]";
	}
	
	
}
