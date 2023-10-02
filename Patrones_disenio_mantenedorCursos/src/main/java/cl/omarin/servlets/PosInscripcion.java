package cl.omarin.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.omarin.entidades.InscripcionDTO;
import cl.omarin.facade.Facade;

@WebServlet("/posInscripcion")
public class PosInscripcion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtener datos del formulario
		String nombre = request.getParameter("nombre");
		String strTelefono = request.getParameter("telefono");
		String idCurso = request.getParameter("idCurso");
		String idFormaPago = request.getParameter("idFormaPago");
		int telefono = Integer.valueOf(strTelefono);
		
		Facade facade = new Facade();
		InscripcionDTO dto = new InscripcionDTO();
		
		dto.setNombre(nombre);
		dto.setTelefono(telefono);
		dto.setId_curso(idCurso);
		dto.setId_forma_pago(idFormaPago);
		
		//invocar Facade para procesar inscripcion
		int idInscripcion = 0;
		try{
			idInscripcion = facade.registrarInscripcion(dto);
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("telefono", strTelefono);
		request.setAttribute("idCurso", idCurso);
		request.setAttribute("idFormaPago", idFormaPago);
		
		request.setAttribute("idInscripcion", idInscripcion);
		
		request.getRequestDispatcher("/preConfirmacion").forward(request, response);
	}
}
