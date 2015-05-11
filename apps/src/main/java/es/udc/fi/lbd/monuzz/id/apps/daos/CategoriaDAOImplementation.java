package es.udc.fi.lbd.monuzz.id.apps.daos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
@Repository
public class CategoriaDAOImplementation implements CategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(value="miTransactionManager")
	public Long create(Categoria miCategoria) {
		Long id = (Long) sessionFactory.getCurrentSession().save(miCategoria);
		return id;
	}

	@Transactional(value="miTransactionManager")
	public void remove(Categoria miCategoria) {

		sessionFactory.getCurrentSession().delete(miCategoria);	
	}

	@Transactional(value="miTransactionManager")
	public void update(Categoria miCategoria) {

		sessionFactory.getCurrentSession().update(miCategoria);			
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

		return sessionFactory.getCurrentSession().createQuery("from " + Categoria.class.getName() + " where id_categoria_madre is null order by nombre").list();
	}

	@Transactional(value="miTransactionManager")
	public List<Categoria> findSubcategories(Categoria miCategoria) {
		// Subcategorías directas (1 nivel)
		
		Query q = sessionFactory.getCurrentSession().createQuery("from " + Categoria.class.getName() + " c where id_categoria_madre is not null and c.madre = :m order by nombre");
		q.setEntity("m", miCategoria);
		return q.list();
		// N niveles 
/*		Long id=miCategoria.getIdCategoria();
		String q_str = 
				"with recursive rcat as ( "+
					"select * "+				
						"from categoria "+
						" where id_categoria = ?"+
				"union "+
					"select s.id_categoria, s.nombre, s.id_categoria_madre "+
						"from categoria s join rcat r on (s.id_categoria_madre = r.id_categoria)) "+
				"select * from rcat order by rcat.nombre offset 1";
		
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(q_str);
		q.setLong(0,id);
		q.addEntity(Categoria.class);
		List subCategorias_list = q.list();
		List<Categoria> subCategorias = new ArrayList <>();
		
		for (Iterator iterator = subCategorias_list.iterator(); iterator.hasNext();) {
			Categoria subCat = (Categoria) iterator.next();
			subCategorias.add(subCat);
		}
		 return subCategorias;
*/	}

	@Transactional(value="miTransactionManager")
	public Long getNumApps(Categoria miCategoria) {
		
		Query q = sessionFactory.getCurrentSession().createQuery("select count(*) from " + App.class.getName() + " a where a.categoria = :c");
		q.setEntity("c", miCategoria);
		return (Long) q.uniqueResult();
	}

	@Transactional(value="miTransactionManager")
	public List<App> getApps(Categoria miCategoria) {
		Query q = sessionFactory.getCurrentSession().createQuery("from " + App.class.getName() + " a where a.categoria = :c");
		q.setEntity("c", miCategoria);
		return q.list();
	}

}
