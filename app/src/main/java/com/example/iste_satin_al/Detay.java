package com.example.iste_satin_al;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Detay extends AppCompatActivity {

    ArrayList<String> data;
    ListView listview2;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        listview2=findViewById(R.id.listview2);

        getExrtras();



        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, data);
        listview2.setAdapter(arrayAdapter);
    }

    public void getExrtras(){
        Intent intent = getIntent();
        data = new ArrayList<String>();
        data.add( "Başlık: " + intent.getStringExtra("baslik"));
        data.add("Sehir: " + intent.getStringExtra("sehir"));
        data.add("Sektor: " + intent.getStringExtra("sektor"));
        data.add("Tur: " + intent.getStringExtra("tur"));
        data.add("Tarih: " + intent.getStringExtra("tarih"));
    }
}
