

import java.util.Iterator;
import java.util.List;

public class SavingAccount extends Account {

	private String typeOfAccount;

	public SavingAccount(double money, int period, List<Statement> statementList, String typeOfAccount) {
		super(money, period, statementList);
		this.typeOfAccount = "Saving Account";

	}

	@Override
	public String toString() {
		return "SavingAccount [typeOfAccount=" + typeOfAccount + ", getMoney()=" + getMoney() + ", getPeriod()="
				+ getPeriod() + "]";
	}

}