package figuras;

import java.util.ArrayList;

public class GestorFiguras extends Figuras{
	
	private ArrayList <Figuras> listaFiguras;
	
	public GestorFiguras() {/**Constructor que inicializa el ArrayList de Objetos de la clase Figura**/
		this.listaFiguras=new ArrayList<Figuras>();
	}
	
	public void anadirFigura(Figuras f) {/**Metodo que recibe un objeto de la clase çfigura y lo añade a la lista**/
		listaFiguras.add(f);
	}
	public void eliminarFigura(Figuras f) {/**Metodo que recibe un objeto de la clase çfigura y lo elimina de la lista**/
		listaFiguras.remove(f);
	}
	public void mostrarFiguras() {/**Metodo que muestra las objetos de la lista**/
		for (Figuras f : listaFiguras) {
			System.out.println(f.toString());
		}
	}
	public void calcularSumatorioAreas() {/**Metodo que muestra la suma de las areas de los objetos de la lista**/
		double acum=0;
		for (Figuras f : listaFiguras) {
			acum+=f.calcArea();
			System.out.println("La suma de las areas de todas las figuras es "+acum);
		}
	}

	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}
}
