package com.example.qin.a5_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CompoundButton.OnCheckedChangeListener checkBoxListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Log.i("CompoundButton", "Checked [" + buttonView.getText().toString() + "]");
                }
            }
        };
        final CheckBox like1 = (CheckBox) findViewById(R.id.like1);
        final CheckBox like2 = (CheckBox) findViewById(R.id.like2);
        final CheckBox like3 = (CheckBox) findViewById(R.id.like3);
        like1.setOnCheckedChangeListener(checkBoxListener);
        like2.setOnCheckedChangeListener(checkBoxListener);
        like3.setOnCheckedChangeListener(checkBoxListener);

        Button submitButton = (Button) findViewById(R.id.btmSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = "";
                if(like1.isChecked()) {
                    txt += like1.getText().toString() + " ";
                }
                if(like2.isChecked()) {
                    txt += like2.getText().toString() + " ";
                }
                if(like3.isChecked()) {
                    txt += like3.getText().toString() + " ";
                }
                Toast.makeText(MainActivity.this, txt, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
