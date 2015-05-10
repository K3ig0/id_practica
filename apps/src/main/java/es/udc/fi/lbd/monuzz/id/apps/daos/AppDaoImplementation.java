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

@Repository
public class AppDaoImplementation implements AppDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(value = "miTransactionManager")
	public Long create(App miApp) {
		Long id = (Long) sessionFactory.getCurrentSession().save(miApp);
		return id;
	}

	@Transactional(value = "miTransactionManager")
	public void update(App miApp) {
		sessionFactory.getCurrentSession().update(miApp);
	}

	@Transactional(value = "miTransactionManager")
	public void remove(App miApp) {
		sessionFactory.getCurrentSession().delete(miApp);
		sessionFactory.getCurrentSession().clear();
	}

	@Transactional(value = "miTransactionManager")
	public App findById(Long id) {
		return (App) sessionFactory.getCurrentSession().get(App.class, id);
	}

	@Transactional(value = "miTransactionManager")
	public App findByTitulo(String miTitulo) {
		Query q = sessionFactory.getCurrentSession().createQuery("from " + App.class.getName() + " where titulo=:titulo");
		q.setString("titulo",miTitulo);
		return (App) q.uniqueResult();
	}

	@Transactional(value = "miTransactionManager")
	public List<App> findAllByProgramador(Programador miProgramador) {
		
		return sessionFactory.getCurrentSession().createQuery("from " + App.class.getName() + " where id_programador="+miProgramador.getIdUsuario()).list();
	}

	@Transactional(value = "miTransactionManager")
	public List<App> findAllByCliente(Cliente miCliente) {
		Long id = miCliente.getIdUsuario();
		Query q = sessionFactory.getCurrentSession().createQuery("select a from App a where id_app in (select r.idApp from Cliente c join c.apps r where c.idUsuario = :id)");
		q.setLong("id", id);

		return q.list();
	}

	@Transactional(value = "miTransactionManager")
	public List<App> findAllByCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value = "miTransactionManager")
	public List<Cliente> findAllClientes(App miApp) {
		Long id = miApp.getIdApp();
		Query q = sessionFactory.getCurrentSession().createQuery("select c from Cliente c join c.apps r where r.idApp=:id");
		q.setLong("id", id);

		return q.list();
	}

}
