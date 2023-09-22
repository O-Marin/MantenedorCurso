package cl.omarin.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.omarin.entidades.FormaDePagoDTO;

public class FormaDePagoDao {

	public List<FormaDePagoDTO> getFormasDePago() throws SQLException, ClassNotFoundException {
		// creamos la lista de objetos que devolveran los resultados
		List<FormaDePagoDTO> listaDeCursos = new ArrayList<FormaDePagoDTO>();

		// creamos la consulta a la base de datos
		String consultaSql = " select id_forma_pago, descripcion from forma_pago";
		Class.forName("com.mysql.cj.jdbc.Driver");
		

		String url = "jdbc:mysql://localhost:3306/curso";
		Connection conexion = DriverManager.getConnection(url, "root", "password");
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(consultaSql);

			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				FormaDePagoDTO formaPago = new FormaDePagoDTO();
				formaPago.setId_forma_pago(resultado.getString("id_forma_pago"));
				formaPago.setDescripcion(resultado.getString("descripcion"));
				formaPago.setRecargo(resultado.getString("recargo"));
				listaDeCursos.add(formaPago);
			}
		} catch (Exception ex) {
			ex.printStackTrace();

			

		}
		return listaDeCursos;
	}
}
