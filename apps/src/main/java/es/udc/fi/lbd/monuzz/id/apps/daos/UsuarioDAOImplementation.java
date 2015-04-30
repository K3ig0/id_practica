package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;
import es.udc.fi.lbd.monuzz.id.apps.model.Usuario;

@Repository
public class UsuarioDAOImplementation implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long create(Usuario miUsuario) {
		Long id;
		if (miUsuario.getIdUsuario()!=null){
			throw new RuntimeException("Usuario ya existente");
		}
		id = (Long) sessionFactory.getCurrentSession().save(miUsuario);
		return id;
	}

	@Override
	public void remove(Usuario miUsuario) {
		if (miUsuario.getIdUsuario()!=null){
			throw new RuntimeException("Usuario non existente");
		}
		sessionFactory.getCurrentSession().delete(miUsuario);	
	}

	@Override
	public void update(Usuario miUsuario) {
		if (miUsuario.getIdUsuario()!=null){
			throw new RuntimeException("Usuario non existente");
		}
		sessionFactory.getCurrentSession().save(miUsuario);	
	}

	@Override
	public Usuario findById(Long id) {
		
		return (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, id);
	}

	@Override
	public Usuario findByNombreDeUsuario(String nombreDeUsuario) {

		return (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, nombreDeUsuario);
	}

	@Override
	public List<Usuario> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery( "from " + Usuario.class.getName()).list();
	}

	@Override
	public List<Cliente> findAllClientes() {

		return sessionFactory.getCurrentSession().createQuery( "from " + Usuario.class.getName() + " where TIPO_USUARIO='CLI'").list();
	}

	@Override
	public List<Programador> findAllProgramadores() {

		return sessionFactory.getCurrentSession().createQuery( "from " + Usuario.class.getName() + " where TIPO_USUARIO='PRO'").list();
	}
}
