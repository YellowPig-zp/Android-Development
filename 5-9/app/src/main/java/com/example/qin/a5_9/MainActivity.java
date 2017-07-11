package com.example.qin.a5_9;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioGroup gender = (RadioGroup) findViewById(R.id.radioGroup1);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton r = (RadioButton) findViewById(checkedId);
                String txt = r.getText().toString();
                Log.i("1", txt);
            }
        });
        Button submitButton = (Button) findViewById(R.id.btnSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < gender.getChildCount(); i++) {
                    RadioButton r = (RadioButton) gender.getChildAt(i);
                    if (r.isChecked()) {
                        Log.i("2", r.getText().toString());
                        break;
                    }
                }
            }
        });
    }
}
