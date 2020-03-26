package more.compoundprimarykey;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Similiar to two classes combining to one table
 */

@Entity
public class Account {
	@Id
	private CompoundKey compoundKey;
	private int balance;
	private String accountType;
	private boolean isJoinedAccount;

	public CompoundKey getCompoundKey() {
		return compoundKey;
	}

	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isJoinedAccount() {
		return isJoinedAccount;
	}

	public void setJoinedAccount(boolean isJoinedAccount) {
		this.isJoinedAccount = isJoinedAccount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
