package cl.omarin.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cl.omarin.entidades.InscripcionDTO;

public class InscripcionDao {
	
	public int insertInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException{
				
		int max=0;
		
		String consultaProximoId = " select max(id_inscripcion) + 1 from inscripcion";
		// query que insertara el valor
		String insertarInscripcion = " insert into inscripcion(id_inscripcion,nombre,celular"
				+ "id_curso, id_forma_pago)" + " values(?,?,?,?,?)";
		
		//conexion a la base de datos y ejecucion de la sentencia
		String consultaSql = " select id_forma_pago, descripcion from forma_pago";
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
				stmt2.setString(3, dto.getCelular());
				stmt2.setString(4, dto.getId_curso());
				stmt2.setString(5, dto.getId_forma_de_pago());
				
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
	
	public List<InscripcionDTO> getInscripcion(){
		return null;
		
	}
}
