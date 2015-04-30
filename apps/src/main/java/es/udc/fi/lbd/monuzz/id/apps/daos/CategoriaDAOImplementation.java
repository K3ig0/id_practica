package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.List;

import es.udc.fi.lbd.monuzz.id.apps.model.*;

public class CategoriaDAOImplementation implements CategoriaDAO {
	public Long create(Categoria miCategoria) {
		//@TODO
		return null;
	}
	
	public void remove (Categoria miCategoria) {
		//@TODO
		
	}
	
	public void update (Categoria miCategoria) {
		//@TODO
		
	}
	
	public Categoria findById (Long idCategoria) {
		//@TODO
		return null;
	}
	
	public Categoria findByNombre (String nombreCategoria) {
		//@TODO
		return null;
	}
	public List<Categoria> findFirstLevel() {
		//@TODO
		return null;
	}
	
	public List<Categoria> findSubcategories(Categoria miCategoria) {
		//@TODO
		return null;
	}
	
	public Long getNumApps(Categoria miCategoria) {
		//@TODO
		return null;
	}
	public List<App> getApps(Categoria miCategoria) {
		//@TODO
		return null;
	}
	
}
