package cl.omarin.entidades;

public class FormaDePagoDTO {
	String id_forma_pago;
	String descripcion;
	String recarga;
	
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
	public String getRecarga() {
		return recarga;
	}
	public void setRecarga(String recargo) {
		this.recarga = recargo;
	}
	
	
}
