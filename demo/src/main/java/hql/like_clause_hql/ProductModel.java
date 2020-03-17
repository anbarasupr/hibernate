package hql.like_clause_hql;

import java.util.*;
import org.hibernate.*;
import entities.*;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Product> startsWith(String keyword) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select p from Product p where p.name like :keyword");
			query.setParameter("keyword", keyword + "%");
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

	public List<Product> endsWith(String keyword) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select p from Product p where p.name like :keyword");
			query.setParameter("keyword", "%" + keyword);
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

	public List<Product> contains(String keyword) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select p from Product p where p.name like :keyword");
			query.setParameter("keyword", "%" + keyword + "%");
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
