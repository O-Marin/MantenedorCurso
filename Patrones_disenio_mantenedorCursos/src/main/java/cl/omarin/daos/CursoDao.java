package cl.omarin.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.omarin.entidades.CursoDTO;

public class CursoDao {

	public List<CursoDTO> getCursos() throws SQLException, ClassNotFoundException {

		// crear lista de objetos que devolveran los resultados
		List<CursoDTO> listaDeCursos = new ArrayList<CursoDTO>();

		// consulta a la base de datos
		String consultaSql = " select id_curso, descripcion, precio from curso";

		// conexion a la base de datos y ejecucion de la sentencia
		try {
			// class that implements java.sql.driver in mysql connector/j is
			// com.mysql.cj.jdbc.Driver.

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/curso";
			
			Connection conexion = DriverManager.getConnection(url, "root", "password");;
			PreparedStatement stmt = conexion.prepareStatement(consultaSql);
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				CursoDTO cursoDto = new CursoDTO();

				cursoDto.setIdCurso(resultado.getString("id_curso"));
				cursoDto.setDescripcion(resultado.getString("descripcion"));
				cursoDto.setPrecio(resultado.getInt("precio"));
				listaDeCursos.add(cursoDto);
				
				
			}
			// aca se hace algo con la conexion
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listaDeCursos;

	}
}
