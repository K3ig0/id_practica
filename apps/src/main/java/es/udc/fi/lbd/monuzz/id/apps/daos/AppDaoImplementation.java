package es.udc.fi.lbd.monuzz.id.apps.daos;


import java.util.List;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;

public class AppDaoImplementation implements AppDAO {

	@Override
	public Long create(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(App miApp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(App miApp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public App findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public App findByTitulo(String miTitulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<App> findAllByProgramador(Programador miProgramador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<App> findAllByCliente(Cliente miCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<App> findAllByCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAllClientes(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

}
