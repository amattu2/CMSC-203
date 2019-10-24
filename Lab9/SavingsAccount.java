/*
 * @author https://github.com/amattu2
 * @version 0.01
 *
 * A operating class representing a savings account
 */
public class SavingsAccount extends BankAccount {
	// Class Variables
	private double rate = 0.0025;
	private int savingsNumber = 0;
	private String accountNumber;

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Basic class constructor.
	 * @param (String) Name
	 * @param (Double) Initial balance
	 */
	public SavingsAccount(String N, double B) {
		// Initialize BankAccount
		super(N, B);
		this.accountNumber = super.getAccountNumber();
		this.setAccountNumber(this.accountNumber);
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Basic class constructor, copy one account to another.
	 * @param (BankAccount) Account
	 * @param (Double) Initial balance
	 */
	public SavingsAccount(BankAccount A, double B) {
		// Initialize BankAccount
		super(A, B);
		this.savingsNumber++;
		this.accountNumber = super.getAccountNumber();
		this.setAccountNumber(this.accountNumber);
	}


	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Calculate monthly interest
	 */
	public void postInterest() {
		this.setBalance((this.getBalance() * this.rate) + this.getBalance());
	}

	/*
	 * @author https://github.com/amattu2
	 * @version 0.01
	 *
	 * Determine current account number
	 */
	public String getAccountNumber()
	{
		return this.accountNumber + "-" + savingsNumber;
	}
}
