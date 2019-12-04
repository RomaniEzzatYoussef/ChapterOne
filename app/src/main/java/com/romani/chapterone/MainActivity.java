package com.romani.chapterone;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DEFAULT_USERNAME = "romani";
    private static final String DEFAULT_PASSWORD = "r";

    private Connection connection;

    String tag = "lifecycle step";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Log.d(tag, "In the onCreate() event ");

        Button login_btn = findViewById(R.id.login1Button);
        TextView myDBText = findViewById(R.id.myDBText);


        try {
            this.connection = createConnection();
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();

            Statement stmt = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            ResultSet rs = stmt.executeQuery("select username , password from users");

            while (rs.next())
            {
                stringBuffer.append(rs.getString(1) + "\n");
            }

            myDBText.setText(stringBuffer.toString());

            connection.close();
        } catch (Exception e) {

            Toast.makeText(MainActivity.this, "" + e,
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public static Connection createConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        return createConnection(DEFAULT_DRIVER, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }




    protected void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event ");
    }

    protected void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event ");
    }

    protected void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }

    protected void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }

    public void login(View v) {
        EditText userName = findViewById(R.id.userNameEditText);
        EditText password = findViewById(R.id.passwordEditText);
        TextView messagelogin = findViewById(R.id.loginMessageTextView);


        if (userName.getText().toString().equals("")) {
            if (password.getText().toString().equals("")) {
                startActivity(new Intent("com.romani.chapterone.MenuActivity"));
                messagelogin.setText("");

            } else {
                messagelogin.setText("Invalid password try again!");
            }
        } else {
            messagelogin.setText("Invalid username try again!");
        }

    }

    public void closeApplication(View v)
    {
        super.onDestroy();
    }

    public void createNewAccount(View v)
    {
        startActivity(new Intent(this, Session6Activity.class));
    }

    public void visitGoogle(View v)
    {
        Uri uri  = Uri.parse("http://www.google.com");
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public void dialUp(View v)
    {
        Uri uri  = Uri.parse("tel:01205224265");
        startActivity(new Intent(Intent.ACTION_DIAL, uri));
    }

}
