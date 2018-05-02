

import java.util.List;

public class FlexibleSavingAccount extends Account {

	private String typeOfAccount;

	public FlexibleSavingAccount(double money, int period,
			List<Statement> statementList, String typeOfAccount) {
		super(money, period, statementList);
		this.typeOfAccount = "Saving Account";

	}

	@Override
	public String toString() {
		return "SavingAccount [typeOfAccount=" + typeOfAccount +", getMoney()=" + getMoney() + ", getPeriod()=" + getPeriod() + "]";
	}
	

}