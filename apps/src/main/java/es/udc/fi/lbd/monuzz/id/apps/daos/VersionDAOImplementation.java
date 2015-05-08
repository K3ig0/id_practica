package es.udc.fi.lbd.monuzz.id.apps.daos;


import java.util.List;

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
	
	@Transactional(value="miTransactionManager")
	public Long create(Version miVersion) {
		Long id;
		if (miVersion.getIdVersion()!=null){
			throw new RuntimeException("Versión ya existente");
		}
		id = (Long) sessionFactory.getCurrentSession().save(miVersion);
		return id;
	}

	@Transactional(value="miTransactionManager")
	public void update(Version miVersion) {
		sessionFactory.getCurrentSession().update(miVersion);
		
	}

	@Transactional(value="miTransactionManager")
	public void remove(Version miVersion) {
		if (miVersion.getIdVersion()==null){
			throw new RuntimeException("Versión no existente");
		}
		sessionFactory.getCurrentSession().delete(miVersion);
	}

	@Transactional(value="miTransactionManager")
	public Version findById(Long id) {
		return (Version) sessionFactory.getCurrentSession().get(Version.class, id);
	}

	@Transactional(value="miTransactionManager")
	public List<Version> findAllByApp(App miApp) {
		return miApp.getVersiones();
	}

	@Transactional(value="miTransactionManager")
	public long getNumVersiones(App miApp) {
		return miApp.getVersiones().size();
	}
}
