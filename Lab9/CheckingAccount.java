/*
 * @author https://github.com/amattu2
 * @version 0.01
 *
 * A operating class representing a checking account
 */
public class CheckingAccount extends BankAccount {
	// Class Variables
	private double FEE = 0.15;
	private String accountNumber;

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Basic class constructor.
	 * @param (String) Name
	 * @param (Double) Initial balance
	 */
	public CheckingAccount(String N, double B) {
		// Initialize BankAccount
		super(N, B);
		this.accountNumber = this.getAccountNumber() + "-10";
		this.setAccountNumber(this.accountNumber);
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Withdraw balance function
	 * @param (Double) Amount
	 */
	public boolean withdraw(double A) {
		// Checks
		if (A > this.getBalance()) { return false; }
		if (A + (this.FEE) > this.getBalance()) { return false; }

		// Variables
		boolean result = super.withdraw(A + (this.FEE));

		// Return
		return result;
	}
}
