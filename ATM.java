package ATMMachine;



import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

        public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
            if (amount <= 0) {
                throw new InvalidAmountException("Invalid amount. Please enter a positive value.");
            }

            if (amount > balance) {
                throw new InsufficientFundsException("Insufficient funds. Cannot withdraw more than the current balance.");
            }

            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
}

public class ATM {
       public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Account account = new Account(1000.0);

            while (true) {
            	System.out.println("ATM MENU:");
                System.out.println("1.Check Balance");
                System.out.println("2.Deposit");
                System.out.println("3.Withdraw");
                System.out.println("4.Exit");
                System.out.print("Please enter your choice: ");

                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("Current balance: " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposit process done successfully.");
                        break;
                    case 3:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        try {
                            account.withdraw(withdrawAmount);
                            System.out.println("Withdrawal process done successfully.");
                        } catch (InsufficientFundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (InvalidAmountException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                System.out.println();

            }
      
     }
}



