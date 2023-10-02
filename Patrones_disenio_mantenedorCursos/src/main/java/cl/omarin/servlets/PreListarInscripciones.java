package cl.omarin.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.omarin.entidades.InscripcionDTO;
import cl.omarin.facade.Facade;

//este servlet recibe la informacion de una form
@WebServlet("/preListarInscripciones")
public class PreListarInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
    


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		List<InscripcionDTO> listaInscripcionesAlumno = null;
		
		try {
			listaInscripcionesAlumno = facade.obtieneInscripciones();
			System.out.println(listaInscripcionesAlumno);
			request.setAttribute("listaInscripcionesAlumno", listaInscripcionesAlumno);
			request.getRequestDispatcher("listarInscripciones.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
