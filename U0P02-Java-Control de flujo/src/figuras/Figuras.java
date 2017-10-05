package figuras;

public abstract class Figuras {

	private String titulo;
	private String color;
	

	public abstract double calcArea();
	public abstract double calcPerimetro();
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Figuras [titulo=" + titulo + ", color=" + color + "]";
	}
	
	

}


