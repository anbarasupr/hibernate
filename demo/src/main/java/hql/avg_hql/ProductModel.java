package hql.avg_hql;

import org.hibernate.*;

import entities.HibernateUtil;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Double avg() {
		Double result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select avg(p.price) from Product p");
			result = (Double) query.getResultList().get(0);
			transaction.commit();
		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

}
