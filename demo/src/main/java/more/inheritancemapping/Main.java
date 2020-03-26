package more.inheritancemapping;

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

		Configuration config = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Project.class)
				.addAnnotatedClass(Module.class).addAnnotatedClass(Task.class);

		MetadataSources metadata = new MetadataSources(
				new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());
		metadata.addAnnotatedClass(Project.class);
		metadata.addAnnotatedClass(Module.class).addAnnotatedClass(Task.class);
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.setHaltOnError(true);
		schemaExport.setFormat(true);
		schemaExport.setDelimiter(";");
		schemaExport.setOutputFile("src/main/resources/sql/generated/db-inheritance-table-per-class-schema.sql");
		schemaExport.execute(EnumSet.of(TargetType.DATABASE, TargetType.STDOUT, TargetType.SCRIPT),
				SchemaExport.Action.NONE, metadata.buildMetadata());

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Project project = new Project();
		project.setProjectName("Hibernate Lessons");

		Module module = new Module();
		module.setProjectName("Spring Lessons");
		module.setModuleName("AOP");

		Task task = new Task();
		task.setProjectName("Java Lessons");
		task.setModuleName("Collections");
		task.setTaskName("ArrayList");

		session.save(project);
		session.save(module);
		session.save(task);
		session.getTransaction().commit();
		session.close();
	}
}
