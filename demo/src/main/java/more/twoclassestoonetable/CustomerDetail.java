package more.twoclassestoonetable;

import javax.persistence.Embeddable;

/*
 * Combine Tow or More classes to one table using Embeddable
 */

@Embeddable
public class CustomerDetail {

	private String customerAddress;
	private int creditScore;
	private int rewardPoints;

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

}
