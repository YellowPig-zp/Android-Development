package com.example.qin.a5_14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    GridView gvInfo;
    String[] titles = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth",
    "Seventh", "Eighth", "Ninth"};
    int[] images = {R.drawable.ic_launcher_round};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvInfo = (GridView) findViewById(R.id.gvInfo);
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("myTitle", titles[i]);


            map.put("myImage", images[0]);
            listItems.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.gvitem, new String[]{"myImage", "myTitle"},
                new int[]{R.id.ItemImage, R.id.ItemText});
        gvInfo.setAdapter(adapter);
        gvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = ((HashMap<String, Object>)parent.getItemAtPosition(position)).get("myTitle").toString();
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
