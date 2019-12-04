package com.romani.chapterone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
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
import java.io.PrintWriter;
import java.util.Scanner;

public class EditFileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_file_activity);

        TextView fileTextView = findViewById(R.id.fileTxtView);
        TextView messageTextView = findViewById(R.id.messageTxtView);

        readFile(fileTextView, messageTextView);

    }

    public void removeTextFromFile(View v) throws IOException {
        TextView fileTextView = findViewById(R.id.fileTxtView);
        TextView messageTextView = findViewById(R.id.messageTxtView);

        EditText removableEditText = findViewById(R.id.removableEditText);
        EditText replacableEditText = findViewById(R.id.replacableEditText);

        String editString = "";

        FileInputStream fis = null;
        try {
            fis = openFileInput("rr.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String txt;

            while ((txt = br.readLine()) != null) {
                sb.append(txt).append("\n");
            }

            editString = sb.toString();

            editString = editString.replaceAll(removableEditText.getText().toString(), replacableEditText.getText().toString());

            fileTextView.setText(editString);
            messageTextView.setText("\n Loaded String..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    public void writeFileButton(View v) {
        TextView fileTextView = findViewById(R.id.fileTxtView);
        TextView messageTextView = findViewById(R.id.messageTxtView);
        EditText fileContents = findViewById(R.id.fileContentsEdtText);

        writeFile(messageTextView, fileContents.getText().toString());
        readFile(fileTextView, messageTextView);

    }

    public void writeFile(TextView messageTextView, String writeFile) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("rr.txt", MODE_PRIVATE);
            fos.write(writeFile.getBytes());
            messageTextView.setText("Editor finish editing.");

        } catch (Exception e) {
            messageTextView.setText(e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFile(TextView fileTextView, TextView messageTextView)
    {
        FileInputStream fis = null;
        try {
            fis = openFileInput("rr.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String txt;

            while ((txt = br.readLine()) != null) {
                sb.append(txt).append("\n");
            }

            fileTextView.setText(sb.toString());
            messageTextView.setText("\n Loaded String..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void countFileChars(View v) throws IOException
    {
        TextView messageTextView = findViewById(R.id.messageTxtView);
        int characters = 0, words = 0, lines = 0;
        FileInputStream fis = null;
        try {
            fis = openFileInput("rr.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String txt;

            while ((txt = br.readLine()) != null) {

                sb.append(txt).append("\n");
                String[] split = txt.split(" ");
                lines++;
                for (int i = 0; i < split.length; i++)
                    if (split[i].length() == 1)
                        characters++;
                    else
                        words++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        messageTextView.setText("Lines: " + lines +
                "\nWords: " + words +
                "\nCharacters: " + characters);

    }

}
