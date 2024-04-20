package threading07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private double amount;
	private String accountHolder;
	private final Lock lock = new ReentrantLock();
	
	public double getAmount()
	{
		return amount;
	}
		
	public Lock getLock() {
		return lock;
	}

	public void debit(double amount)
	{
		this.amount -= amount;
	}
	
	public Account(double amount, String accountHolder) {
		super();
		this.amount = amount;
		this.accountHolder = accountHolder;
	}
	
	public String getAccountHolder()
	{
		return accountHolder;
	}

	public void credit(double amount)
	{
		this.amount += amount;
	}
	
	public boolean hasSufficientAmount(double amount)
	{
		if (this.amount < amount)
			return false;
		else
			return true;
	}
}
