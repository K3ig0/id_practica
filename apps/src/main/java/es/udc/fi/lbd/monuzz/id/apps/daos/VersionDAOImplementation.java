package es.udc.fi.lbd.monuzz.id.apps.daos;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Version;
@Repository
public class VersionDAOImplementation implements VersionDAO {

	@Transactional(value="miTransactionManager")
	public Long create(Version miVersion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public void update(Version miVersion) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(value="miTransactionManager")
	public void remove(Version miVersion) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(value="miTransactionManager")
	public Version findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public List<Version> findAllByApp(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value="miTransactionManager")
	public long getNumVersiones(App miApp) {
		// TODO Auto-generated method stub
		return 0;
	}
}
