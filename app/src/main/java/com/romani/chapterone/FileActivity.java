package com.romani.chapterone;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_activity);


        File file = new File(Environment.getExternalStorageDirectory() + "/RomaniAndroid");
        boolean success = true;
        if (!file.exists())
        {
            Toast.makeText(getApplicationContext(), "Directory does not exist, create it", Toast.LENGTH_LONG).show();

        }

        if (success)
        {
            Toast.makeText(getApplication(), "Directory created", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this, "failed Error", Toast.LENGTH_SHORT).show();
        }

    }

    public void saveFile(View v)
    {
        EditText editText = (EditText) findViewById(R.id.editTextFile);
        TextView textView = (TextView) findViewById(R.id.messageTxtView);


        String saveText = editText.getText().toString();

        FileOutputStream fos = null;
        try {

            fos = openFileOutput("r.text",MODE_PRIVATE);
            fos.write(saveText.getBytes());
            textView.setText(saveText);
            editText.getText().clear();

            Toast.makeText(this, "Saved to " +  getFilesDir() + "/r.text", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadFile(View v)
    {
        EditText editText = (EditText) findViewById(R.id.editTextFile);
        TextView textView = (TextView) findViewById(R.id.messageTxtView2);

        FileInputStream fis = null;
        try {
            fis = openFileInput("r.text");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String txt;

            while ((txt = br.readLine()) != null)
            {
                sb.append(txt).append("\n");
            }

            editText.setText(sb.toString());
            textView.setText(sb.toString() + "\n Loaded String..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadMonkeyFile(View v)
    {
        TextView textView = (TextView) findViewById(R.id.monkeyTxtView);

        FileInputStream fis = null;
        try {
            fis = openFileInput("monkey.text");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String txt;

            while ((txt = br.readLine()) != null)
            {
                sb.append(txt).append("\n");
            }

            textView.setText(sb.toString() + "\n Loaded String..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
