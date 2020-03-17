package nativequery.join_clause;

import java.util.List;
import org.hibernate.*;

import entities.HibernateUtil;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Object[]> join() {
		List<Object[]> productJoins = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery("select p.id as id, " + "p.name as name, "
					+ "p.price as price, " + "c.id as categoryId, " + "c.name as categoryName "
					+ "from product p inner join category c " + "where p.categoryid = c.id");
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
