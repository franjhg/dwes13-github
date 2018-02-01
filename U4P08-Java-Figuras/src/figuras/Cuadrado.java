package figuras;

public class Cuadrado extends Figuras{

	public double lado;
	
	
	public Cuadrado(double lado) {
		super();
		this.lado = lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return super.toString()+  "Cuadrado [lado=" + lado + "]";
	}
	
	
	
}
