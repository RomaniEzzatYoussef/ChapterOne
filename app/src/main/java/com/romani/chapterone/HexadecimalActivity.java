package com.romani.chapterone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HexadecimalActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hexadecimal_activity);
    }

    public void binary2Decimal(View v)
    {
        EditText editText = findViewById(R.id.editText);
        TextView message = findViewById(R.id.messageTxtView);
        try
        {
            String binaryStr = editText.getText().toString();
            message.setText("The decimal of " + binaryStr + " is " + bin2Dec(binaryStr));
        }
        catch (Exception ex)
        {
            message.setText(ex.getMessage());
        }
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatExeption
    {
        int value = convertBin2Dec(Character.getNumericValue(binaryString.charAt(binaryString.length() - 1)), 0);

        for (int i = binaryString.length() - 2; i >= 0; i--)
            value += convertBin2Dec(Character.getNumericValue(binaryString.charAt(i)), binaryString.length() - i - 1);

        return value;
    }

    public static int convertBin2Dec(int binary, int pow) throws BinaryFormatExeption
    {
        if (binary == 0)
            return 0;
        else if (binary == 1)
            return (int) Math.pow(2, pow);
        else
            throw new BinaryFormatExeption();
    }
}

class BinaryFormatExeption extends Exception
{
    private static final long serialVersionUID = 1L;

    BinaryFormatExeption()
    {
        super("Illegal binary character");
    }

    BinaryFormatExeption(String message)
    {
        super(message);
    }
}
