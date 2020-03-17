package hql.groupby_clause_hql;

import java.util.List;
import org.hibernate.*;
import entities.CategoryGroup;
import entities.HibernateUtil;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<CategoryGroup> group() {
		List<CategoryGroup> categoryGroups = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select new entities.CategoryGroup("
					+ "p.category.id as categoryId, " + "min(p.price) as minPrice, " + "max(p.price) as maxPrice, "
					+ "sum(p.quantity) as sumQuantity, " + "count(p.id) as countProduct, " + "avg(p.price) as avgPrice"
					+ ")" + "from Product p " + "group by p.category.id ");
			categoryGroups = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			categoryGroups = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return categoryGroups;
	}

}
