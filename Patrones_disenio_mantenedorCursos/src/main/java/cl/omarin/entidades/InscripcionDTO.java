package cl.omarin.entidades;

public class InscripcionDTO {
	int id_inscription;
	String nombre;
	String celular;
	String id_curso;
	String id_forma_de_pago;
	
	public int getId_inscription() {
		return id_inscription;
	}
	public void setId_inscription(int id_inscription) {
		this.id_inscription = id_inscription;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getId_curso() {
		return id_curso;
	}
	public void setId_curso(String id_curso) {
		this.id_curso = id_curso;
	}
	public String getId_forma_de_pago() {
		return id_forma_de_pago;
	}
	public void setId_forma_de_pago(String id_forma_de_pago) {
		this.id_forma_de_pago = id_forma_de_pago;
	}
	
	
	
}
