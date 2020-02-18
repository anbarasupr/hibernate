package use_date_hql;

import java.util.List;
import org.hibernate.*;
import entities.*;

public class InvoiceModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Invoice> findByDate(int year, int month, int day) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery(
					"from Invoice where year(dateCreated) = :year and month(dateCreated) = :month and day(dateCreated) = :day ");
			query.setParameter("year", year);
			query.setParameter("month", month);
			query.setParameter("day", day);
			invoices = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

}
