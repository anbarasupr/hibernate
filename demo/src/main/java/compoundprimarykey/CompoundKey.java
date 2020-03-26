package compoundprimarykey;

import java.io.Serializable;

import javax.persistence.Embeddable;

/*
 * Similiar to two classes combining to one table
 */

@Embeddable
public class CompoundKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private int accountId;
	private int userId;

	public CompoundKey(int accountId, int userId) {
		super();
		this.accountId = accountId;
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
