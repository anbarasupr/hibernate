package interceptors_events_audit_log;

import org.hibernate.*;
import entities.*;

public class Main {

	public static void main(String[] args) {

		try {
			Session session = HibernateUtil.getSessionFactory().withOptions().interceptor(new MyLog()).openSession();
			Transaction transaction = session.beginTransaction();

			Category addCategory = new Category();
			addCategory.setName("Category 4");
			session.save(addCategory);

			Category updatedCategory = (Category) session.createQuery("from Category where id = :id")
					.setParameter("id", 7).getSingleResult();
			updatedCategory.setName("Category 5");
			session.update(updatedCategory);

			Category deletedCategory = (Category) session.createQuery("from Category where id = :id")
					.setParameter("id", 7).getSingleResult();
			session.delete(deletedCategory);

			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
