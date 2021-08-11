package service;

import java.math.BigDecimal;
import dao.CoinTypes;

public class Change {
	public Change(BigDecimal amount) {
		calculate(amount.multiply(new BigDecimal(100)).intValue());
	}

	void calculate(int amount) {
		int currentAmount = amount;
		while (currentAmount >= CoinTypes.QUARTERS.value) {
			quarters++;
			currentAmount -= CoinTypes.QUARTERS.value;
		}
		while (currentAmount >= CoinTypes.DIMES.value) {
			dimes++;
			currentAmount -= CoinTypes.DIMES.value;
		}
		while (currentAmount >= CoinTypes.NICKELS.value) {
			nickles++;
			currentAmount -= CoinTypes.NICKELS.value;
		}
		while (currentAmount >= CoinTypes.PENNIES.value) {
			pennies++;
			currentAmount -= CoinTypes.PENNIES.value;
		}
	}

	int quarters = 0;
	int dimes = 0;
	int nickles = 0;
	int pennies = 0;

	public String toString() {
		return String.format("[Quarters=%d, Dimes=%d, Nickels=%d, Pennies=%d]", quarters, dimes, nickles, pennies);
	}

	public int getQuarters() {
		return quarters;
	}

	public void setQuarters(int quarters) {
		this.quarters = quarters;
	}

	public int getDimes() {
		return dimes;
	}

	public void setDimes(int dimes) {
		this.dimes = dimes;
	}

	public int getNickles() {
		return nickles;
	}

	public void setNickles(int nickles) {
		this.nickles = nickles;
	}

	public int getPennies() {
		return pennies;
	}

	public void setPennies(int pennies) {
		this.pennies = pennies;
	}
}