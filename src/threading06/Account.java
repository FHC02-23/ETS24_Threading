package threading06;

public class Account {
	private double amount;
	private String accountHolder;
	
	public Account(double amount, String accountHolder) {
		super();
		this.amount = amount;
		this.accountHolder = accountHolder;
	}
	
	public String getAccountHolder()
	{
		return accountHolder;
	}
	public double getAmount()
	{
		return amount;
	}

	public void credit(double amount)
	{
		this.amount += amount;
	}
	public void debit(double amount)
	{
		this.amount -= amount;
	}
	
	public boolean hasSufficientAmount(double amount)
	{
		if (this.amount < amount)
			return false;
		else
			return true;
	}
}
