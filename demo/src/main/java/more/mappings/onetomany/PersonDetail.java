package more.mappings.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personDetailId_PK")
	private int personDetailId;
	private String address;
	private String job;
	private double income;

	// for bi directional which means, while retrieving PersonDetail, we have to
	// know which person the detail belongs to
	// mappedBy is for bidirectional, it contains the reference attribute name which
	// we given in Person class to get the PersonDetail instance
	@OneToOne(mappedBy = "personDetail", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Person person;

	public int getPersonDetailId() {
		return personDetailId;
	}

	public void setPersonDetailId(int personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
