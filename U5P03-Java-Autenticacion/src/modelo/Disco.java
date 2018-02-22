package modelo;

public class Disco {

	
	public String IdDisco, Autor,Titulo, imagen;
	
	
	
	public Disco(String idDisco, String  autor, String titulo, String imagen) {
		this.IdDisco = idDisco;
		this.Autor = autor;
		this.Titulo = titulo;
		this.imagen = imagen;
	}



	public String getIdDisco() {
		return IdDisco;
	}



	public void setIdDisco(String idDisco) {
		IdDisco = idDisco;
	}



	public String getAutor() {
		return Autor;
	}



	public void setAutor(String autor) {
		Autor = autor;
	}



	public String getTitulo() {
		return Titulo;
	}



	public void setTitulo(String titulo) {
		Titulo = titulo;
	}



	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	@Override
	public String toString() {
		return "Disco [IdDisco=" + IdDisco + ", Autor=" + Autor + ", Titulo=" + Titulo + ", imagen=" + imagen + "]";
	}

	
	
}