package com.jkb.automaxtrailersinc;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button signIn;
    String line;

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream in= urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char)data;
                    result += current;
                    data = reader.read();

                }
                return result;

            } catch(Exception e) {
                e.printStackTrace();
                return "Failed";
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        DownloadTask task = new DownloadTask();
        String result = null;
        try {
            result = task.execute("http://automaxtrailers.com/").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Contents of URL: " + result);

        username=(EditText)findViewById(R.id.usernameET);
        password=(EditText)findViewById(R.id.passwordET);
        signIn=(Button)findViewById(R.id.signIn);

        signIn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if (username.getText().toString().equals("1234") && password.getText().toString().equals("1234")) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(MainActivity.this,
                            LoadInfo.class);
                    startActivity(myIntent);
                    }
                 else {
                    Toast.makeText(getApplicationContext(), "Wrong Username and/or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
