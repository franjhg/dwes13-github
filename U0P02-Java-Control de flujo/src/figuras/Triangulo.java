package figuras;

public class Triangulo {

	private int base, altura, lado1, lado2;
	
	public Triangulo(int base, int altura, int lado1, int lado2) {
		this.base=base;
		this.altura=altura;
		this.lado1=lado1;
		this.lado2=lado2;
	}
	
	public int area(int base, int altura) {
		return (base+altura)/2;
	}
	
	public int perimetro(int base, int lado1, int lado2) {
		return base+lado1+lado2;
	}

	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + ", lado1=" + lado1 + ", lado2=" + lado2 + "]";
	}
	
	
}
