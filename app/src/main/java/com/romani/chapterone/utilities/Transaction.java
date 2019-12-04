package com.romani.chapterone.utilities;

import java.util.Date;

public class Transaction extends Account
{
    private Date date;
    private String type;
    private double amount;
    private double balance;
    private String description;

    public Transaction()
    {
        this("", 0, 0, "Default");
    }

    public Transaction(String type, double amount, double balance, String description)
    {
        date = new Date();
        this.setType(type);
        this.setAmount(amount);
        this.setBalance(balance);
        this.setDescription(description);
    }

    public String getDate() {
        return (date.getDay()+12) + "/" + (date.getMonth()+1) + "/" + (date.getYear()+1900)+ "  " + date.getHours() + ":" + date.getMinutes() + ":"+date.getSeconds();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
