package hql.projection_hql;

import java.util.List;
import org.hibernate.*;

import entities.HibernateUtil;
import entities.ProductEntity;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<ProductEntity> projection() {
		List<ProductEntity> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session
					.createQuery("select new entities.ProductEntity(p.id, p.name, p.price) from Product p");
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
