package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
@Repository
public class CategoriaDAOImplementation implements CategoriaDAO {

	@Transactional(value="miTransactionManager")
	public Long create(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public void remove(Categoria miCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(value="miTransactionManager")
	public void update(Categoria miCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(value="miTransactionManager")
	public Categoria findById(Long idCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public Categoria findByNombre(String nombreCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public List<Categoria> findFirstLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public List<Categoria> findSubcategories(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public Long getNumApps(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public List<App> getApps(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
