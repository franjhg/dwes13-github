package figuras;

public class Circunferencia extends Figuras{

	public double radio;
	
	public Circunferencia(double radio) {
		super();
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return super.toString()+"Circunferencia [radio=" + radio + "]";
	}
	
	
	
}
