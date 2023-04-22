package threading07;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TransferService implements Runnable {

	private ArrayList<Transaction> transactions;
	private String serviceName;
	private static Object lockObject = new Object();
	
	public TransferService(String serviceName, ArrayList<Transaction> transactions)
	{
		this.transactions = transactions;
		this.serviceName = serviceName;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < transactions.size(); i++) {

			Transaction transaction = transactions.get(i);
			System.out.println(serviceName + " waiting for " + transaction.getAccountCreditor().getAccountHolder());
			try {
				if (transaction.getAccountCreditor()
						.getLock().tryLock(50, TimeUnit.MILLISECONDS)) {

					System.out.println(serviceName + " waiting for " + transaction.getAccountDepitor().getAccountHolder());
					if(transaction.getAccountDepitor()
							.getLock().tryLock(50, TimeUnit.MILLISECONDS)) {

						if (transaction.getAccountDepitor().hasSufficientAmount(transaction.getAmount())) {

							transaction.doTransaction();
						}
						// Depitor wieder freigeben
						transaction.getAccountDepitor().getLock().unlock();
					}
					else {
						System.out.println(serviceName + " lock for " + transaction.getAccountDepitor().getAccountHolder() + " not possible!");
						i--;
					}
					
					// Creditor wieder freigeben
					transaction.getAccountCreditor().getLock().unlock();
				}
				else {
					System.out.println(serviceName + " lock for " + transaction.getAccountCreditor().getAccountHolder() + " not possible!");
					i--;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	

	}

}
