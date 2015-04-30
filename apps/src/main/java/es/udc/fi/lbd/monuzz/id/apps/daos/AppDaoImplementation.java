package es.udc.fi.lbd.monuzz.id.apps.daos;


import java.util.List;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;

public class AppDaoImplementation implements AppDAO {
	public Long create(App miApp) {
		//@TODO
		return null;
	}
	
	public void update (App miApp){
		//@TODO
		
	}
	
	public void remove (App miApp) {
		//@TODO
		
	}
	
	public App findById (Long id) {
		//@TODO
		return null;
	}
	
	public App findByTitulo (String miTitulo) {
		//@TODO
		return null;
	}
	
	public List<App> findAllByProgramador (Programador miProgramador) {
		//@TODO
		return null;
	}
	
	public List<App> findAllByCliente (Cliente miCliente) {
		//@TODO
		return null;
	}
	
	public List<App> findAllByCategoria (Categoria miCategoria) {
		//@TODO
		return null;
	}
	
	public List<Cliente> findAllClientes (App miApp) {
		//@TODO
		return null;
	}
}
