package threading07;

public class Transaction {
	private final Account accountDepitor;
	private final Account accountCreditor;
	private final double amount;
	
	public Transaction(Account accountDepitor, Account accountCreditor, double amount)
	{
		this.accountCreditor = accountCreditor;
		this.accountDepitor = accountDepitor;
		this.amount = amount;
	}
	
	public void doTransaction()
	{
		accountCreditor.credit(amount);
		accountDepitor.debit(amount);
		
		System.out.println("Transfering " + amount + " from " + accountDepitor.getAccountHolder() + " to " + accountCreditor.getAccountHolder());
	}

	public Account getAccountDepitor() {
		return accountDepitor;
	}

	public Account getAccountCreditor() {
		return accountCreditor;
	}

	public double getAmount() {
		return amount;
	}
}
