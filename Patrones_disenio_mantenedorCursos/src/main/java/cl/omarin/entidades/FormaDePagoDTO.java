package cl.omarin.entidades;

public class FormaDePagoDTO {
	String id_forma_pago;
	String descripcion;
	String recargo;
	
	public String getId_forma_de_pago() {
		return id_forma_pago;
	}
	public void setId_forma_pago(String id_forma_de_pago) {
		this.id_forma_pago = id_forma_de_pago;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRecargo() {
		return recargo;
	}
	public void setRecargo(String recargo) {
		this.recargo = recargo;
	}
	
	
}
