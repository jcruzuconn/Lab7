package me.thankstoken.a2020_04_21e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import me.thankstoken.a2020_04_21e.model.Radio;
import me.thankstoken.a2020_04_21e.model.ItemArrayAdapter;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Radio> radioList = new ArrayList<Radio>();

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, radioList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);

        // Populating list items
        for(int i=0; i<10; i++) {
            radioList.add(new Radio("Radio: " + i, R.mipmap.ic_launcher));
        }


    }
}
