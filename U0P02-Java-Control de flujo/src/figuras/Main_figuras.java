package figuras;

public class Main_figuras {

	public static void main(String[] args) {
		
		Triangulo t1=new Triangulo(8, 15, "rojo", "Triangulo1");
		Cuadrado c1=new Cuadrado(4.2,"azul", "Cuadrado1");
		Circunferencia cir1=new Circunferencia(4.8, "verde", "circulo1");
		Circunferencia cir2=new Circunferencia(1.5, "azul", "circulo2");
		

		System.out.println(cir1.toString());
		//System.out.println("Cir1:" + cir1.calcArea());
		System.out.println(cir2.toString());
		//System.out.println("Cir2:" + cir2.calcArea());
		System.out.println(c1.toString());
		//System.out.println("c1:" + c1.calcArea());
		System.out.println(t1.toString());
		//System.out.println("t1:" + t1.calcArea());

		double areaTotal = t1.calcArea()+c1.calcArea()+cir1.calcArea()*0.5+cir2.calcArea()*0.75;
		System.out.println("Area total: " + areaTotal);
		System.out.println("Perimetro total: "+ (t1.calcPerimetro()+(2*c1.getLado())+(cir1.calcPerimetro()*0.5)+(cir2.calcPerimetro()*0.75)-(2*cir1.getRadio())-(2*cir2.getRadio())));

		
		
		GestorFiguras gestor1=new GestorFiguras();
		Circunferencia cir3=new Circunferencia(1.5, "azul", "circulo3");
		
		gestor1.anadirFigura(cir3);
		gestor1.calcularSumatorioAreas();
		gestor1.mostrarFiguras();
		gestor1.eliminarFigura(cir3);
		
		gestor1.mostrarFiguras();
	}

}