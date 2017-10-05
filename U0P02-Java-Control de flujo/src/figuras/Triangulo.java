package figuras;

public class Triangulo extends Figuras{

	private double base, altura;
	
	public Triangulo(double base, double altura ,String color, String titulo) {
		super.setColor(color);
		super.setTitulo(titulo);
		this.base=base;
		this.altura=altura;
	
	}
	
	public double calcArea() {
		return (base*altura)/2.0;
	}
	
	public double calcPerimetro() {
		return  (base+altura+(Math.sqrt((Math.pow(base, 2))+(Math.pow(altura, 2)))));
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	
	public String toString() {
		return super.toString()+"Triangulo [base=" + base + ", altura=" + altura + "]";
	}

	


	
	
	
	
}
