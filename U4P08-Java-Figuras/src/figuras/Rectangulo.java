package figuras;

public class Rectangulo extends Figuras{
	
	public double ladoX, ladoY;
	
	
	public Rectangulo(double ladoX, double ladoY) {
		super();
		this.ladoX = ladoX;
		this.ladoY = ladoY;
	}

	public double getLadoX() {
		return ladoX;
	}

	public void setLadoX(double ladoX) {
		this.ladoX = ladoX;
	}

	public double getLadoY() {
		return ladoY;
	}

	public void setLadoY(double ladoY) {
		this.ladoY = ladoY;
	}

	@Override
	public String toString() {
		return super.toString()+"Rectangulo [ladoX=" + ladoX + ", ladoY=" + ladoY + "]";
	}
	
	

}
