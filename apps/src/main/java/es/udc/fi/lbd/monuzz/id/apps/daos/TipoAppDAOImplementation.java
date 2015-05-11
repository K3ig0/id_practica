package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.udc.fi.lbd.monuzz.id.apps.model.TipoApp;

@Repository
public class TipoAppDAOImplementation implements TipoAppDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//@Transactional(value="miTransactionManager")
	public Long create(TipoApp miTipo) {
		Long id = (Long) sessionFactory.getCurrentSession().save(miTipo);
		return id;
	}

	//@Transactional(value="miTransactionManager")
	public void remove(TipoApp miTipo) {

		sessionFactory.getCurrentSession().delete(miTipo);
	}

	//@Transactional(value="miTransactionManager")
	public TipoApp findById(Long Id) {
		
		return (TipoApp) sessionFactory.getCurrentSession().get(TipoApp.class, Id);
	}

	//@Transactional(value="miTransactionManager")
	public TipoApp findByNombre(String nombre) {
		Query q = sessionFactory.getCurrentSession().createQuery("from " + TipoApp.class.getName() + " where nombre=:nombre");
		q.setString("nombre",nombre);
		return (TipoApp) q.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	//@Transactional(value="miTransactionManager")
	public List<TipoApp> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery( "from " + TipoApp.class.getName() + " order by nombre").list();
	}

}
