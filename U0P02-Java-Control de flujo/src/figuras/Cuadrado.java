package figuras;

public class Cuadrado extends Figuras{
	
	private double lado;
	
	public Cuadrado(double lado) {
		this.lado=lado;
	}
	
	public double calcArea() {
		return lado*lado;
	}
	
	public double calcPerimetro() {
		return lado*4;
	}

	
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}
	
	

}
