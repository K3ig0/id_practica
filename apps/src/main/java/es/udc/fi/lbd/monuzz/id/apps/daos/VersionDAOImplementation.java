package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Version;

@Repository
public class VersionDAOImplementation implements VersionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(value = "miTransactionManager")
	public Long create(Version miVersion) {

		Long id = (Long) sessionFactory.getCurrentSession().save(miVersion);
		return id;
	}

	@Transactional(value = "miTransactionManager")
	public void update(Version miVersion) {

		sessionFactory.getCurrentSession().update(miVersion);
	}

	@Transactional(value = "miTransactionManager")
	public void remove(Version miVersion) {

		sessionFactory.getCurrentSession().delete(miVersion);
	}

	@Transactional(value = "miTransactionManager")
	public Version findById(Long id) {

		return (Version) sessionFactory.getCurrentSession().get(Version.class,id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "miTransactionManager")
	public List<Version> findAllByApp(App miApp) {
		Query q = sessionFactory.getCurrentSession().createQuery("from " + Version.class.getName() + " v where v.app=:app order by fecha_publicacion desc");
		q.setEntity("app", miApp);
		return q.list();
	}

	@Transactional(value = "miTransactionManager")
	public long getNumVersiones(App miApp) {

		return miApp.getVersiones().size();
	}
}
