package lab06;

import java.util.ArrayList;

public class Lab06 {

    public static void main(String[] args) {
        Account account = new Account(1122, 1000, "George");

        account.setAnnualInterestRate(1.5);

        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        Object obj = new Object();

        account.summary();
    }
}//end main

class Account {

    private String name;
    private int id = 0;
    private static double annualInterestRate = 0.0;
    private double balance = 0.0;
    private ArrayList<Transaction> transaction = new ArrayList<>();
    private java.util.Date dateCreated;

    public Account() {
        dateCreated = new java.util.Date();
    }

    public Account(int id, double balance, String name) {
        this();
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public String getDateCreated() {
        return this.dateCreated.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        transaction.add(new Transaction('W', amount, this.balance, "Withdraw"));
    }

    public void deposit(double amount) {
        this.balance += amount;
        transaction.add(new Transaction('D', amount, this.balance, "Deposit"));
    }

    public void summary() {
        System.out.println("Summary:");
        System.out.println("Account holder name: " + name);
        System.out.println("Interest rate: " + annualInterestRate + "percent");
        System.out.println("Balance: " + balance + "Dollar");

        System.out.println("Account Transactions:");
        for (Transaction j : transaction) {
            System.out.println(j.toString());
        }
    }
}

class Transaction {

    private java.util.Date date;
    private char type;

    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        date = new java.util.Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction Date: " + date + "\n"
                + "Transaction type: '" + type + "'\n"
                + "Amount: " + amount + " Dollar\n"
                + "Balance: " + balance + " Dollar\n";
    }
}
