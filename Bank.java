import java.util.ArrayList;
import java.util.Scanner;

/**
 * BankAccount class represents a single bank account
 * Demonstrates OOP concepts: Encapsulation, Attributes, and Methods
 */
class BankAccount {
    // Private attributes (Encapsulation)
    private String accountHolderName;
    private int accountNumber;
    private double balance;
    
    // Constructor to create new account
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    
    // Constructor with initial balance
    public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Amount deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }
    
    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful! Amount withdrawn: $" + amount);
                System.out.println("Remaining balance: $" + balance);
            } else {
                System.out.println("Insufficient balance! Current balance: $" + balance);
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
    
    // Method to check balance (Balance Inquiry)
    public void checkBalance() {
        System.out.println("\n=== Account Balance ===");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
        System.out.println("======================\n");
    }
    
    // Getter methods
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Display account information
    public void displayAccountInfo() {
        System.out.println("Account #" + accountNumber + " - " + accountHolderName + " - Balance: $" + balance);
    }
}

/**
 * Bank class manages multiple bank accounts
 * Demonstrates OOP concepts: Composition and Object Management
 */
class Bank {
    private ArrayList<BankAccount> accounts;
    private int nextAccountNumber;
    
    // Constructor
    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1001; // Starting account number
    }
    
    // Method to create new account
    public void createAccount(String accountHolderName, double initialBalance) {
        BankAccount newAccount = new BankAccount(accountHolderName, nextAccountNumber, initialBalance);
        accounts.add(newAccount);
        System.out.println("\n=== Account Created Successfully! ===");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + nextAccountNumber);
        System.out.println("Initial Balance: $" + initialBalance);
        System.out.println("====================================\n");
        nextAccountNumber++;
    }
    
    // Method to find account by account number
    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
    
    // Method to display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the bank.");
        } else {
            System.out.println("\n=== All Bank Accounts ===");
            for (BankAccount account : accounts) {
                account.displayAccountInfo();
            }
            System.out.println("========================\n");
        }
    }
    
    // Main method - Entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        
        System.out.println("\n**************************************");
        System.out.println("*   Welcome to Mini Banking System   *");
        System.out.println("**************************************\n");
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: // Create New Account
                    System.out.print("\nEnter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit amount: $");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(name, initialBalance);
                    break;
                    
                case 2: // Deposit Money
                    System.out.print("\nEnter account number: ");
                    int depositAccNum = scanner.nextInt();
                    BankAccount depositAccount = bank.findAccount(depositAccNum);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 3: // Withdraw Money
                    System.out.print("\nEnter account number: ");
                    int withdrawAccNum = scanner.nextInt();
                    BankAccount withdrawAccount = bank.findAccount(withdrawAccNum);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 4: // Check Balance
                    System.out.print("\nEnter account number: ");
                    int balanceAccNum = scanner.nextInt();
                    BankAccount balanceAccount = bank.findAccount(balanceAccNum);
                    if (balanceAccount != null) {
                        balanceAccount.checkBalance();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 5: // Display All Accounts
                    bank.displayAllAccounts();
                    break;
                    
                case 6: // Exit
                    System.out.println("\nThank you for using Mini Banking System!");
                    System.out.println("Goodbye!\n");
                    running = false;
                    break;
                    
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}
