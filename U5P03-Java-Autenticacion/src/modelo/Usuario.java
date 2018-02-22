package modelo;

/**
 * @author Alumno
 *
 */
public class Usuario {
	
	private String login, password, nombre, descripcion;
	private boolean administrador;
	public Usuario(String login, String password, String nombre, String descripcion, boolean administrador) {
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.administrador = administrador;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", password=" + password + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", administrador=" + administrador + "]";
	}
	
	
	
}
