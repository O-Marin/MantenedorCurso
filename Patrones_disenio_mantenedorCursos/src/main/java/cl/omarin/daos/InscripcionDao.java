package cl.omarin.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.omarin.entidades.InscripcionDTO;

public class InscripcionDao {
	
	public int insertInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException{
				
		int max=0;
		
		//elige el id siguiente al ultimo
		String consultaProximoId = " select max(id_inscripcion) + 1 from curso.inscripcion";
		// query que insertara el valor
		String insertarInscripcion = " insert into curso.inscripcion(id_inscripcion,nombre,celular"
				+ "id_curso, id_forma_pago)" + " values(?,?,?,?,?)";
		
		//conexion a la base de datos y ejecucion de la sentencia
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/curso";
		Connection conexion = DriverManager.getConnection(url, "root", "password");
		
		
		try {
			//consultando cual es el proximo id
			PreparedStatement stmt1 = conexion.prepareStatement(consultaProximoId);
			//inserta la inscripcion que esta en el dto
			PreparedStatement stmt2 = conexion.prepareStatement(insertarInscripcion);
			
			//guardo el id en resultado
			ResultSet resultado = stmt1.executeQuery();
			if(resultado.next()) {
				//dado el id que sigue
				max = resultado.getInt("id_inscripcion");
				
				stmt2.setInt(1, max);
				stmt2.setString(2, dto.getNombre());
				stmt2.setInt(3, dto.getTelefono());
				stmt2.setString(4, dto.getId_curso());
				stmt2.setString(5, dto.getId_forma_pago());
				
				if(stmt2.executeUpdate() != 1) {
					throw new RuntimeException("A ocurrido un error inesperado");
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("A ocurrido un error inesperado" + ex);
			

		}
		return max;
		
	}
	
	public List<InscripcionDTO> getInscripcion() throws ClassNotFoundException, SQLException{
		List<InscripcionDTO> inscripciones = new ArrayList<InscripcionDTO>();
		String consultaSql = " select * from curso.inscripcion";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/curso";
		Connection conexion = DriverManager.getConnection(url, "root", "password");
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(consultaSql);
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				InscripcionDTO inscripcion = new InscripcionDTO();
				inscripcion.setId_curso(resultado.getString("id_curso"));
				inscripcion.setId_inscription(resultado.getInt("id_inscripcion"));
				inscripcion.setNombre(resultado.getString("nombre"));
				inscripcion.setTelefono(resultado.getInt("telefono"));
				inscripcion.setId_forma_pago(resultado.getString("id_forma_pago"));
				inscripciones.add(inscripcion);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return inscripciones;
		
	}
}
