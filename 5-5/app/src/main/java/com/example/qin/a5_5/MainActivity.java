package com.example.qin.a5_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "You have clicked a normal button", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void myClick(View v) {
        Toast toast = Toast.makeText(MainActivity.this, "You have clicked an image button", Toast.LENGTH_SHORT);
        toast.show();
    }
}
