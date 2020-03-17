package nativequery.groupby_clause;

import java.util.List;
import org.hibernate.*;

import entities.HibernateUtil;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Object[]> groupBy() {
		List<Object[]> categoryGroupBy = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session
					.createNativeQuery("select categoryid, " + "sum(quantity), " + "max(price), " + "min(price), "
							+ "count(id), " + "avg(price) " + "from product " + "group by categoryid");
			categoryGroupBy = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			categoryGroupBy = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return categoryGroupBy;
	}

}
