package cl.omarin.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.omarin.entidades.CursoDTO;
import cl.omarin.entidades.FormaDePagoDTO;
import cl.omarin.facade.Facade;

@WebServlet("/preInscripcion")
public class PreInscripcion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		
		try {
			List<CursoDTO> cursos = facade.obtenerCursos();
			List<FormaDePagoDTO> formasPago = facade.obtenerFormasDePago();
			
			request.setAttribute("cursos", cursos);
			request.setAttribute("formasPago", formasPago);
			request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
