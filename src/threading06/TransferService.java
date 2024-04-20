package threading06;

import java.util.ArrayList;

public class TransferService implements Runnable {

	private ArrayList<Transaction> transactions;
	private String serviceName;
	
	public TransferService(String serviceName,
			ArrayList<Transaction> transactions)
	{
		this.transactions = transactions;
		this.serviceName = serviceName;
	}
	
	@Override
	public void run() {

		System.out.println(serviceName + " runs in " + Thread.currentThread().getId());
		
		for (Transaction transaction : transactions) {
			if (transaction.getAccountDepitor()
					.hasSufficientAmount(transaction.getAmount())) {

				transaction.doTransaction();
			}
		}
	}

}
