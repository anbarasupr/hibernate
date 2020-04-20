package more.mappings.onetoone;

import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

public class MainTransaction {

	public static void main(String[] args) {
		
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg3.xml")
		        // "jdbc" is the default, but for explicitness
		        .applySetting( AvailableSettings.TRANSACTION_COORDINATOR_STRATEGY, "jta" )
		        .build();

		Metadata metadata = new MetadataSources( serviceRegistry )
				.addAnnotatedClass(Person.class).addAnnotatedClass(PersonDetail.class)
		        .getMetadataBuilder()
		        .build();

		SessionFactory factory = metadata.getSessionFactoryBuilder()
		        .build();
		
		
//		Configuration config = new Configuration().configure("hibernate.cfg3.xml")
//				.addAnnotatedClass(Person.class).addAnnotatedClass(PersonDetail.class);
//
//		MetadataSources metadata = new MetadataSources(
//				new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());
//		metadata.addAnnotatedClass(Person.class).addAnnotatedClass(PersonDetail.class);
//		SchemaExport schemaExport = new SchemaExport();
//		schemaExport.setHaltOnError(true);
//		schemaExport.setFormat(true);
//		schemaExport.setDelimiter(";");
//		schemaExport.setOutputFile("src/main/resources/sql/generated/mappings/db-onetoone-schema.sql");
//		schemaExport.execute(EnumSet.of(TargetType.DATABASE, TargetType.STDOUT, TargetType.SCRIPT),
//				SchemaExport.Action.NONE, metadata.buildMetadata());

//		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		PersonDetail personDetail=new PersonDetail();
		personDetail.setAddress("101 New Jersey");
		personDetail.setJob("SAD");
		personDetail.setIncome(10000);
		
		Person person=new Person();
		person.setPersonName("anbu");
		person.setPersonDetail(personDetail);

		session.save(person);
		
		// no need if we set cascadeType
		//session.save(personDetail);
		
		session.getTransaction().commit();
		session.close();
	}
}
