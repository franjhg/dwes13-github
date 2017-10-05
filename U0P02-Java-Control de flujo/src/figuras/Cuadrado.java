package figuras;
public class Cuadrado extends Figuras{
	
	private double lado;
	
	public Cuadrado(double lado,String color, String titulo) {
		super.setColor(color);
		super.setTitulo(titulo);
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

	
	public String toString() {
		return super.toString()+ "Cuadrado [lado=" + lado + "]";
	}
}