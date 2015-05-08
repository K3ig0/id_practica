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
		Long id;
		/*if (miCategoria.getIdCategoria()!=null){
			throw new RuntimeException("Categoría ya existente");
		}*/
		id = (Long) sessionFactory.getCurrentSession().save(miCategoria);
		return id;
	}

	@Transactional(value="miTransactionManager")
	public void remove(Categoria miCategoria) {
		/*if (miCategoria.getIdCategoria()==null){
			throw new RuntimeException("Categoría no existente");
		}*/
		sessionFactory.getCurrentSession().delete(miCategoria);				
	}

	@Transactional(value="miTransactionManager")
	public void update(Categoria miCategoria) {
		/*if (miCategoria.getIdCategoria()==null){
			throw new RuntimeException("Categoría no existente");
		}*/
		sessionFactory.getCurrentSession().save(miCategoria);			
	}

	@Transactional(value="miTransactionManager")
	public Categoria findById(Long idCategoria) {
		/*if (idCategoria==null){
			throw new RuntimeException("Categoría no existente");
		}*/
		return (Categoria) sessionFactory.getCurrentSession().get(Categoria.class, idCategoria);
	}

	@Transactional(value="miTransactionManager")
	public Categoria findByNombre(String nombreCategoria) {
		/*if (nombreCategoria==null){
			throw new RuntimeException("Categoría no existente");
		}*/
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
		/*if (miCategoria==null){
			throw new RuntimeException("Categoría no existente");
		}*/
		Long id=miCategoria.getIdCategoria();
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
