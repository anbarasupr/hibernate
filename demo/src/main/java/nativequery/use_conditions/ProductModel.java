package nativequery.use_conditions;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.*;

import entities.HibernateUtil;
import entities.Product;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Product> between(BigDecimal min, BigDecimal max) {
		List<Product> products = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session
					.createNativeQuery("select * from product where price between :min and :max", Product.class);
			query.setParameter("min", min);
			query.setParameter("max", max);
			products = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

}
