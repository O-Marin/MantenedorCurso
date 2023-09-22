package cl.omarin.facade;

import java.sql.SQLException;
import java.util.List;

import cl.omarin.daos.CursoDao;
import cl.omarin.daos.FormaDePagoDao;
import cl.omarin.daos.InscripcionDao;
import cl.omarin.entidades.CursoDTO;
import cl.omarin.entidades.FormaDePagoDTO;
import cl.omarin.entidades.InscripcionDTO;

public class Facade {
	public int registrarInscripcion(InscripcionDTO dto)
	throws SQLException, ClassNotFoundException{
		InscripcionDao dao = new InscripcionDao();
		return dao.insertInscripcion(dto);
	}
	
	public List<CursoDTO> obtenerCursos() throws SQLException, ClassNotFoundException{
		CursoDao dao = new CursoDao();
		return dao.getCursos();	
	}
	
	public List<FormaDePagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException{
		FormaDePagoDao dao = new FormaDePagoDao();		
		return dao.getFormasDePago();
	}
	
	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException{
		InscripcionDao dao = new InscripcionDao();
		return dao.getInscripcion();
		
	}
}
