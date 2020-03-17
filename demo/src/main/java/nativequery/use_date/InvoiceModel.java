package nativequery.use_date;

import java.util.List;
import org.hibernate.*;
import entities.*;

public class InvoiceModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Invoice> findLast7Days() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"select * from invoice where dateCreated >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)", Invoice.class);
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

	public List<Invoice> findLastWeek() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"SELECT * FROM invoice WHERE dateCreated >= curdate() - INTERVAL DAYOFWEEK(curdate()) + 6 DAY AND dateCreated < curdate() - INTERVAL DAYOFWEEK(curdate()) - 1 DAY",
					Invoice.class);
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

	public List<Invoice> findThisWeek() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"SELECT * FROM invoice WHERE YEARWEEK(dateCreated) = YEARWEEK(NOW())", Invoice.class);
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

	public List<Invoice> findThisMonth() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"SELECT * FROM invoice WHERE MONTH(dateCreated) = MONTH(CURRENT_DATE()) AND YEAR(dateCreated) = YEAR(CURRENT_DATE())",
					Invoice.class);
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

	public List<Invoice> findLastMonth() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"SELECT * FROM invoice WHERE dateCreated >= CONCAT(LEFT(NOW() - INTERVAL 1 MONTH,7),'-01') AND dateCreated <= NOW() - INTERVAL 1 MONTH",
					Invoice.class);
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

	public List<Invoice> findLast30Days() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"select * from invoice where dateCreated >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)", Invoice.class);
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

	public List<Invoice> findThisQuarter() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"select * from invoice where quarter(dateCreated) = quarter(curdate())", Invoice.class);
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

	public List<Invoice> findLastQuarter() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"SELECT * from invoice where dateCreated >= quarter(curdate() - INTERVAL 1 QUARTER)",
					Invoice.class);
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

	public List<Invoice> findLast90Days() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"select * from invoice where dateCreated >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)", Invoice.class);
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

	public List<Invoice> findThisYear() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"select * from invoice where year(dateCreated) = year(curdate())", Invoice.class);
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

	public List<Invoice> findLastYear() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"SELECT * from invoice where dateCreated >= quarter(curdate() - INTERVAL 1 YEAR)", Invoice.class);
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

	public List<Invoice> findLast365Days() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery(
					"select * from invoice where dateCreated >= DATE_SUB(CURDATE(), INTERVAL 365 DAY)", Invoice.class);
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
