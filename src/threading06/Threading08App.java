package threading06;

import java.util.ArrayList;

public class Threading08App {

	public static void main(String[] args) {
		
		Account a = new Account(100_000, "Account A");
		Account b = new Account(100_000, "Account B");

		ArrayList<Transaction> transactionsA 
			= new ArrayList<>();
		ArrayList<Transaction> transactionsB 
			= new ArrayList<>();
		
		for (int i = 0; i < 100; i++)
		{
			transactionsA.add(new Transaction(a, b, 1_000));
			transactionsB.add(new Transaction(b, a, 1_000));
		}
		// Montag, 08 Uhr
		Thread thA = new Thread(
				new TransferService("Service 1" ,transactionsA));
		Thread thB = new Thread(
				new TransferService("Service 2" ,transactionsB));
		
		thA.start();
		thB.start();
		
		try {
			thA.join();
			thB.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(a.getAmount());
		System.out.println(b.getAmount());

	}

}
