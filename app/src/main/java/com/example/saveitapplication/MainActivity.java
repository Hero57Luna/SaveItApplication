package com.example.saveitapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button button_simpan_user, button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.textUser);
        password = findViewById(R.id.textPassword);

        button_simpan_user = findViewById(R.id.button_save_user);
        button_login = findViewById(R.id.button_login);

        button_simpan_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                databaseHelper.addUser(username.getText().toString(), password.getText().toString());
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

                boolean result = databaseHelper.checkUser(user, pass);

                if (result) {
                    Toast.makeText(MainActivity.this, "Logged In!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}