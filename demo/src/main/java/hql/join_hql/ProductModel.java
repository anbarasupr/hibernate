package hql.join_hql;

import java.util.List;
import org.hibernate.*;

import entities.HibernateUtil;
import entities.ProductJoin;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<ProductJoin> join() {
		List<ProductJoin> productJoins = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery(
					"select new entities.ProductJoin(p.id, p.name, p.price, p.category.id, p.category.name) from Product p, Category c where p.category = c");
			productJoins = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			productJoins = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return productJoins;
	}

}
