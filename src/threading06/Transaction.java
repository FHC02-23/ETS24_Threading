package threading06;

public class Transaction {
	private final Account accountDepitor;
	private final Account accountCreditor;
	private final double amount;
	
	public Transaction(Account accountDepitor, 
			Account accountCreditor, 
			double amount)
	{
		this.accountCreditor = accountCreditor;
		this.accountDepitor = accountDepitor;
		this.amount = amount;
	}
	
	public void doTransaction()
	{
		synchronized(accountCreditor) {
			System.out.println(Thread.currentThread().getId() + " > "
					+ accountCreditor.getAccountHolder() + " lock 1 succeeded, waiting for " + accountDepitor.getAccountHolder());

			synchronized(accountDepitor) {
				System.out.println(Thread.currentThread().getId() + " > " +
						accountDepitor.getAccountHolder() + "  lock 2 succeeded");

				accountDepitor.debit(amount);
				accountCreditor.credit(amount);
			}
		}

		
		System.out.println("Transfering " + amount 
				+ " from " + accountDepitor.getAccountHolder()
				+ " to " + accountCreditor.getAccountHolder());
	
	
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
