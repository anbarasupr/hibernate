package compoundprimarykey;
import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

public class Main {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Account.class);

		MetadataSources metadata = new MetadataSources(
				new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());
		metadata.addAnnotatedClass(Account.class);
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.setHaltOnError(true);
		schemaExport.setFormat(true);
		schemaExport.setDelimiter(";");
		schemaExport.setOutputFile("db-account-compound-primary-schema.sql");
		schemaExport.execute(EnumSet.of(TargetType.DATABASE, TargetType.STDOUT, TargetType.SCRIPT), SchemaExport.Action.NONE, metadata.buildMetadata());

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		CompoundKey key=new CompoundKey(1000, 10001);
		Account saving=new Account();
		saving.setJoinedAccount(true);
		saving.setBalance(5000);
		saving.setCompoundKey(key);
		saving.setAccountType("SAVING");
		
		
		key=new CompoundKey(1000, 10002);
		Account current=new Account();
		current.setJoinedAccount(false);
		current.setBalance(10000);
		current.setCompoundKey(key);
		current.setAccountType("CURRENT");
		
		session.save(saving);
		session.save(current);
		
		session.getTransaction().commit();
		session.close();
	}
}
