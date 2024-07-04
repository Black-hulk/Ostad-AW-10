
import java.util.Scanner;
class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}


class SavingsAccount extends BankAccount {
    private static final double WITHDRAWAL_LIMIT = 1000.00;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal amount exceeds the limit of $" + WITHDRAWAL_LIMIT);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        }
    }
}

class CheckingAccount extends BankAccount {
    private static final double WITHDRAWAL_FEE = 2.00;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        double totalAmount = amount + WITHDRAWAL_FEE;
        if (totalAmount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= totalAmount;
            System.out.println("Withdrew: $" + amount + " (including fee of $" + WITHDRAWAL_FEE + ")");
        }
    }
}



public class test1Main {
    public static void main(String[] args) {
    	
    	Scanner myObj = new Scanner(System.in);
    	
        BankAccount savings = new SavingsAccount(1500.00);
        BankAccount checking = new CheckingAccount(1500.00);

        System.out.println("Initial Savings Balance: $" + savings.getBalance());
        System.out.print("Enter Deposite Amount: $");
        double d= myObj.nextDouble();
        savings.deposit(d);
        
        System.out.print("Enter Deposite Amount: $");
        double w= myObj.nextInt();
        savings.withdraw(w);
        System.out.println("Final Savings Balance: $" + savings.getBalance());

        System.out.println("\nInitial Checking Balance: $" + checking.getBalance());
        checking.deposit(d);
        checking.withdraw(w);
        System.out.println("Final Checking Balance: $" + checking.getBalance());
    }
}
