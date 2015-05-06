package es.udc.fi.lbd.monuzz.id.apps.daos;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;
@Repository
public class AppDaoImplementation implements AppDAO {

	@Transactional(value="miTransactionManager")
	public Long create(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public void update(App miApp) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(value="miTransactionManager")
	public void remove(App miApp) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(value="miTransactionManager")
	public App findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public App findByTitulo(String miTitulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public List<App> findAllByProgramador(Programador miProgramador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public List<App> findAllByCliente(Cliente miCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public List<App> findAllByCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public List<Cliente> findAllClientes(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

}
