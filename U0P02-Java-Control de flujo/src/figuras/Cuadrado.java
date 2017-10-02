package figuras;

public class Cuadrado {
	
	private int lado;
	
	public Cuadrado(int lado) {
		this.lado=lado;
	}
	
	public int area(int lado) {
		return lado*lado;
	}
	
	public int perimetro(int lado) {
		return lado*4;
	}

	
	
	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}
	
	

}
