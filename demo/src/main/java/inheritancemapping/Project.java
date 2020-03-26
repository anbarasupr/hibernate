package inheritancemapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * Inheritance Types
 * 	1.SINGLE_TABLE (DEFAULT) - one table for all classes which contain all columns. not good if columns get increase 
 *  2.JOINED - create separate table for each class and maintains the referential integrity.
 *  3.TABLE_PER_CLASS - create separate table without any referential integrity and columns get duplicated in child tables (module and task table here)
 */

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) // default
//@Inheritance(strategy=InheritanceType.JOINED)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	private String projectName;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
