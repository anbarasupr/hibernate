// Create class MyLog.java will log all the Hibernate save, update or delete operations
package interceptors_events_audit_log;

import java.io.Serializable;
import java.util.*;
import java.text.*;
import org.hibernate.*;
import org.hibernate.type.Type;
import entities.Category;

public class MyLog extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy h:m:s");

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (entity instanceof Category) {
			Category category = (Category) entity;
			System.out.println("Add new category: " + category.getName() + " on " + simpleDateFormat.format(new Date()));
			return true;
		}
		return false;
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (entity instanceof Category) {
			System.out.println("Delete category successful on " + simpleDateFormat.format(new Date()));
		}
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		if (entity instanceof Category) {
			System.out.println("Update category successful on " + simpleDateFormat.format(new Date()));
			return true;
		}
		return false;
	}

}
