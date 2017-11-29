package com.teknords.duaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] names={"A","B","C","D","E","F","G","H","J","k","l","m","n","o","p","q"};
    int[] images={R.drawable.images15,R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6,R.drawable.images7,R.drawable.images8,R.drawable.images9,R.drawable.images10,R.drawable.images11,R.drawable.images12,R.drawable.images13,R.drawable.images14,R.drawable.images};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listView1);

        Adapter adapter =new Adapter(this,names,images);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

                Intent intent = new Intent(MainActivity.this,duaShow.class);
                intent.putExtra("selectedDua",pos);
                startActivity(intent);

            }
        });
    }
}
