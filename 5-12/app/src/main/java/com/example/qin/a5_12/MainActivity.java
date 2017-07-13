package com.example.qin.a5_12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] incomes = {"1 | salary 4000$", "2 | Stipend 2000$", "3 | Stock 1000$", "4 | Rent 2400$"};
        ListView incomeInfo = (ListView) findViewById(R.id.incomeinfo);
        ArrayAdapter<String> arrayAdapter = null;
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, incomes);
        incomeInfo.setAdapter(arrayAdapter);
        incomeInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
