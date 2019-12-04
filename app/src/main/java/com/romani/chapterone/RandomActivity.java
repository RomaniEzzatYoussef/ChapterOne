package com.romani.chapterone;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.romani.chapterone.utilities.Account;
import com.romani.chapterone.utilities.Transaction;

import java.util.ArrayList;
import java.util.Random;

public class RandomActivity extends Activity
{
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.random_activity);
    }

    public void onClickButton(View v)
    {
        TextView txt = findViewById(R.id.messageTxtView);

        Account.setAnnualInterestRate(Math.random() * 10);;

        Account account = new Account("Romani Ezzat", 1122, Math.random() * 100000);
        String message = "";
        message += ("\nID: " + account.getId());
        message += ("\nName: " + account.getCustomerName());
        message += ("\nAnnual interest rate: " + String.format("%-7.3f" , Account.getAnnualInterestRate()));
        message += ("\nBalance: " + String.format("%-7.4f" , account.getBalance()) + "\n");


        shuffleTransaction(account);

        ArrayList<Transaction> list = account.getTransactions();
        message += String.format("\nUser Transactoins Today:\n%-3s%-35s%-14s%-16s%-15s\n", "ID", "Date", "Type", "Amount", "Balance");

        for (int i = 0; i < list.size(); i++)
        {
            Transaction transaction = (list.get(i));
            message += String.format("%-3s%-22s%-14s%-15.2f%-13.2f\n", (i+1), transaction.getDate(), transaction.getType(), transaction.getAmount(), transaction.getBalance());
        }

        message += ("\nTotal Balance: " + String.format("%-7.4f" , account.getBalance()) + "\n");

        txt.setTextColor(Color.BLUE);
        txt.setBackgroundColor(Color.GRAY);
        txt.setText(message);
    }

    public void shuffle(ArrayList<Transaction> list)
    {
        Random r = new Random();
        for (int i = 0; i < list.size(); i++)
        {
            int x = r.nextInt(list.size());

            Transaction temp = list.get(i);
            list.set(i, list.get(x));
            list.set(x, temp);
        }
    }

    public void shuffleTransaction(Account account)
    {
        for (int i = 0; i < Math.random() * 1000; i++)
        {
            int shuffle = (int)(Math.random() * 2);
            if (shuffle == 0)
                account.deposit(Math.random() * 10000);
            else
                account.withdraw(Math.random() * 10000);

        }
    }

    public void multiplicationTableOnClick(View v)
    {
        TextView txt = findViewById(R.id.messageTxtView);
        String message = "";

        for (int r = 1; r < 30; r++)
        {
            message += String.format("%-5s%2s" , (r) , " ");
            for (int c = 1; c < 13; c++)
                message += String.format("%-5s%2s" , (r*c) , " ");
            message += "\n";
        }

        txt.setTextColor(Color.BLUE);
        txt.setBackgroundColor(Color.GRAY);
        txt.setText(message);
    }





}
