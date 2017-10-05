package figuras;

import java.util.ArrayList;

public class GestorFiguras {
	
	private ArrayList <Figuras> listaFiguras;
	
	/** Constructor que inicializa el ArrayList de Objetos de la clase Figura **/
	public GestorFiguras() {
		this.listaFiguras=new ArrayList<Figuras>();
	}
	
	/**
	 *  Metodo que recibe un objeto de la clase Figura y lo anade a la lista
	 * @param 
	 **/
	public void anadirFigura(Figuras f) {
		listaFiguras.add(f);
	}
	/** Metodo que recibe un objeto de la clase Figura y lo elimina de la lista
	 *  @param
	 *  **/
	public void eliminarFigura(Figuras f) {
		listaFiguras.remove(f);
	}
	/** Metodo que muestra las objetos de la lista 
	 * **/
	public void mostrarFiguras() {
		for (Figuras f : listaFiguras) {
			System.out.println(f.toString());
		}
	}
	/** Metodo que muestra la suma de las areas de los objetos de la lista 
	 * **/
	public void calcularSumatorioAreas() {
		double acum=0;
		for (Figuras f : listaFiguras) {
			acum+=f.calcArea();
			System.out.println("La suma de las areas de todas las figuras es "+acum);
		}
	}

	
}
