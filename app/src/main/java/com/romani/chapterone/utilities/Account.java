package com.romani.chapterone.utilities;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private String customerName;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account()
    {
        dateCreated = new Date();
    }

    public Account(String name, int id , double balance)
    {
        this.id = id;
        this.customerName = name;
        this.balance = balance;
        dateCreated = new Date();
    }

    public Account(int id , String customerName, double balance)
    {
        this.id = id;
        this.customerName = customerName;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }



    public Date getDateCreated()
    {
        return dateCreated;
    }

    public double getMonthlyInterestRate()
    {
        return (getAnnualInterestRate() /100) / 12;
    }

    public double getMonthlyInterest()
    {
        return (getBalance() * getMonthlyInterestRate());
    }

    public void withdraw(double amount)
    {
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount, balance, ""));

    }

    public void deposit(double amount)
    {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount, balance, ""));

    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

}


