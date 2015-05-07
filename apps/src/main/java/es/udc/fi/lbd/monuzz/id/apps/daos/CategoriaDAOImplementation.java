package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.Usuario;
@Repository
public class CategoriaDAOImplementation implements CategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(value="miTransactionManager")
	public Long create(Categoria miCategoria) {
		Long id;
		if (miCategoria.getIdCategoria()!=null){
			throw new RuntimeException("Categoría ya existente");
		}
		id = (Long) sessionFactory.getCurrentSession().save(miCategoria);
		return id;
	}

	@Transactional(value="miTransactionManager")
	public void remove(Categoria miCategoria) {
		if (miCategoria.getIdCategoria()==null){
			throw new RuntimeException("Categoría no existente");
		}
		sessionFactory.getCurrentSession().delete(miCategoria);				
	}

	@Transactional(value="miTransactionManager")
	public void update(Categoria miCategoria) {
		if (miCategoria.getIdCategoria()==null){
			throw new RuntimeException("Categoría no existente");
		}
		sessionFactory.getCurrentSession().save(miCategoria);			
	}

	@Transactional(value="miTransactionManager")
	public Categoria findById(Long idCategoria) {

		return (Categoria) sessionFactory.getCurrentSession().get(Categoria.class, idCategoria);
	}

	@Transactional(value="miTransactionManager")
	public Categoria findByNombre(String nombreCategoria) {
		Query q = sessionFactory.getCurrentSession().createQuery("from " + Categoria.class.getName() + " where nombre=:nombreCategoria");
		q.setString("nombreCategoria",nombreCategoria);
		return (Categoria) q.uniqueResult();
	}

	@Transactional(value="miTransactionManager")
	public List<Categoria> findFirstLevel() {

		return sessionFactory.getCurrentSession().createQuery("from " + Categoria.class.getName() + " where id_categoria_madre is null").list();
	}

	@Transactional(value="miTransactionManager")
	public List<Categoria> findSubcategories(Categoria miCategoria) {
		Long id=miCategoria.getIdCategoria();
		Query q = sessionFactory.getCurrentSession().createQuery(
				"with recursive rcat as ( "+
					"select * "+				
						"from categoria " + Categoria.class.getName() +
						" where id_categoria=:id "+
				"union "+
					"select s.id_categoria, s.nombre, s.id_categoria_madre "+
						"from categoria s join rcat r on (s.id_categoria_madre = r.id_categoria)) "+
				"select * from rcat offset 1");
		q.setString("id",id.toString());
		return (List<Categoria>) q.list();
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
