package twoclassestoonetable;
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

		Configuration config = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Customer.class);

		MetadataSources metadata = new MetadataSources(
				new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());
		metadata.addAnnotatedClass(Customer.class);
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.setHaltOnError(true);
		schemaExport.setFormat(true);
		schemaExport.setDelimiter(";");
		schemaExport.setOutputFile("db-customer-embedded-schema.sql");
		schemaExport.execute(EnumSet.of(TargetType.DATABASE, TargetType.STDOUT, TargetType.SCRIPT), SchemaExport.Action.BOTH, metadata.buildMetadata());

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Customer customer = new Customer();
		customer.setCustomerName("anbu");
		
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setCustomerAddress("100 New Jersey");
		customerDetail.setCreditScore(780);
		customerDetail.setRewardPoints(10000);
		
		customer.setCustomerDetail(customerDetail);

		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}
}
