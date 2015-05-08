package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;
import es.udc.fi.lbd.monuzz.id.apps.model.TipoApp;
import es.udc.fi.lbd.monuzz.id.apps.model.Usuario;

@Repository
public class UsuarioDAOImplementation implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(value="miTransactionManager")
	public Long create(Usuario miUsuario) {
		Long id;
		/*if (miUsuario.getIdUsuario()!=null){
			throw new DataIntegrityViolationException("Usuario ya existente");
		}*/
		id = (Long) sessionFactory.getCurrentSession().save(miUsuario);
		return id;
	}

	@Transactional(value="miTransactionManager")
	public void remove(Usuario miUsuario) {
		if (miUsuario.getIdUsuario()==null){
			throw new RuntimeException("Usuario no existente");
		}
		sessionFactory.getCurrentSession().delete(miUsuario);
	}

	@Transactional(value="miTransactionManager")
	public void update(Usuario miUsuario) {
		if (miUsuario.getIdUsuario()==null){
			throw new RuntimeException("Usuario no existente");
		}
		sessionFactory.getCurrentSession().update(miUsuario);
	}

	@Transactional(value="miTransactionManager")
	public Usuario findById(Long id) {
		
		return (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, id);
	}

	@Transactional(value="miTransactionManager")
	public Usuario findByNombreDeUsuario(String nombreDeUsuario) {

		Query q = sessionFactory.getCurrentSession().createQuery("from " + Usuario.class.getName() + " where usuario=:nombreDeUsuario");
		q.setString("nombreDeUsuario",nombreDeUsuario);
		return (Usuario) q.uniqueResult();
	}

	@Transactional(value="miTransactionManager")
	public List<Usuario> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery( "from " + Usuario.class.getName()).list();
	}

	@Transactional(value="miTransactionManager")
	public List<Cliente> findAllClientes() {

		return sessionFactory.getCurrentSession().createQuery( "from " + Usuario.class.getName() + " where TIPO_USUARIO='CLI'").list();
	}

	@Transactional(value="miTransactionManager")
	public List<Programador> findAllProgramadores() {

		return sessionFactory.getCurrentSession().createQuery( "from " + Usuario.class.getName() + " where TIPO_USUARIO='PRO'").list();
	}
}
