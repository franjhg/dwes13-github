package figuras;

public class Elipse extends Figuras{

	public double radioX, radioY;
	
	public Elipse(double radioX, double radioY) {
		super();
		this.radioX = radioX;
		this.radioY = radioY;
	}

	public double getRadioX() {
		return radioX;
	}

	public void setRadioX(double radioX) {
		this.radioX = radioX;
	}

	public double getRadioY() {
		return radioY;
	}

	public void setRadioY(double radioY) {
		this.radioY = radioY;
	}

	@Override
	public String toString() {
		return super.toString()+ "Elipse [radioX=" + radioX + ", radioY=" + radioY + "]";
	}
	
	
}
