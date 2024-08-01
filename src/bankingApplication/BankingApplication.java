package bankingApplication;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		double withdrawalAmount = 0;
		double accountBalance = 500;
		double depositAmount = 0;
		int operator = 0;
		
		Scanner inputScanner =  new Scanner(System.in);
		System.out.println("|Banking Application|");
		
		do {
		
			System.out.println("Deposit(1), Withdraw(2), Balance(3), Exit(0): ");
		
			operator = inputScanner.nextInt();
		
			if (operator == 1) {
				System.out.print("Deposit amount: ");
				depositAmount = inputScanner.nextDouble();
				accountBalance =  deposit(depositAmount, accountBalance);
				balance(accountBalance);
			} else if(operator == 2) {
				System.out.print("Withdrawal amount: ");
				withdrawalAmount = inputScanner.nextDouble();
				accountBalance = withdraw(withdrawalAmount, accountBalance);
				balance(accountBalance);
			} else if(operator == 3) {
				balance(accountBalance);	
			} else if(operator == 0) {
				System.out.println("Good Bye!");
			} else {
				System.out.println("Invalid Entry");
			}
			
			System.out.println();
			
		} while (operator != 0);
		
		inputScanner.close();
	}

	private static void balance(double accountBalance) {
		
		DecimalFormat formatter = new DecimalFormat("#0.00"); 
		System.out.print("Available Balance 3$");
		System.out.println(formatter.format(accountBalance));
	}

	private static double withdraw(double withdrawalAmount, double accountBalance) {
		
		if (withdrawalAmount < accountBalance ) {
			System.out.println("Withdrawal successful!");
			return accountBalance - withdrawalAmount;
		} else {
			System.out.println("Withdrwal amount exceeds current balance.");
		}
		return accountBalance;
	}

	private static double deposit(double depositAmount, double accountBalance) {
		
		System.out.println("Deposit successful!");
		return accountBalance + depositAmount;
	}
}
