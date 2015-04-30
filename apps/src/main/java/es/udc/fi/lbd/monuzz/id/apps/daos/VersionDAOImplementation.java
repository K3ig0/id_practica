package es.udc.fi.lbd.monuzz.id.apps.daos;


import java.util.List;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Version;

public class VersionDAOImplementation implements VersionDAO {
	public Long create(Version miVersion) {
		//@TODO
		return null;
	}
	
	public void update (Version miVersion) {
		//@TODO
		
	}
	public void remove (Version miVersion) {
		//@TODO
		
	}
	
	public Version findById (Long id) {
		//@TODO
		return null;
	}
	
	public List<Version> findAllByApp (App miApp) {
		//@TODO
		return null;
	}
	public long getNumVersiones(App miApp) {
		//@TODO
		return 0;
	}
}
