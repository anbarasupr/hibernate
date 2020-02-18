package between_clause_hql;
import java.math.BigDecimal;
import java.util.*;
import org.hibernate.*;
import entities.*;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Product> between(BigDecimal min, BigDecimal max) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session
					.createQuery("select p from Product p where p.price >= :min and p.price <= :max");
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
