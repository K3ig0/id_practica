package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;
import es.udc.fi.lbd.monuzz.id.apps.model.Usuario;

@Repository
public class AppDaoImplementation implements AppDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(value = "miTransactionManager")
	public Long create(App miApp) {
		Long id;
		id = (Long) sessionFactory.getCurrentSession().save(miApp);
		return id;
	}

	@Transactional(value = "miTransactionManager")
	public void update(App miApp) {
		sessionFactory.getCurrentSession().update(miApp);
	}

	@Transactional(value = "miTransactionManager")
	public void remove(App miApp) {
		sessionFactory.getCurrentSession().delete(miApp);
	}

	@Transactional(value = "miTransactionManager")
	public App findById(Long id) {
		return (App) sessionFactory.getCurrentSession().get(App.class, id);
	}

	@Transactional(value = "miTransactionManager")
	public App findByTitulo(String miTitulo) {
		Query q = sessionFactory.getCurrentSession().createQuery("from " + App.class.getName() + " where id_tipo_app=:titulo");
		q.setString("titulo",miTitulo);
		return (App) q.uniqueResult();
	}

	@Transactional(value = "miTransactionManager")
	public List<App> findAllByProgramador(Programador miProgramador) {
		return sessionFactory.getCurrentSession().createQuery( "from " + App.class.getName() + " where id_usuario="+miProgramador.getIdUsuario()).list();
	}

	@Transactional(value = "miTransactionManager")
	public List<App> findAllByCliente(Cliente miCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value = "miTransactionManager")
	public List<App> findAllByCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value = "miTransactionManager")
	public List<Cliente> findAllClientes(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

}
