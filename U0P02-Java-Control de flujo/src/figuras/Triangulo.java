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

	
	
	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLado1() {
		return lado1;
	}

	public void setLado1(int lado1) {
		this.lado1 = lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public void setLado2(int lado2) {
		this.lado2 = lado2;
	}

	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + ", lado1=" + lado1 + ", lado2=" + lado2 + "]";
	}
	
	
}
