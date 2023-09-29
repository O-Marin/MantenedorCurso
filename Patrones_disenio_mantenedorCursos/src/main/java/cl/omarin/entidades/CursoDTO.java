package cl.omarin.entidades;

public class CursoDTO {
	String id_curso;
	String descripcion;
	int precio;
	
	
	public String getIdCurso() {
		return id_curso;
	}
	public void setIdCurso(String idCurso) {
		this.id_curso = idCurso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
