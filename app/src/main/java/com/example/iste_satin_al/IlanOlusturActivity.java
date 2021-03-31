package com.example.iste_satin_al;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.iste_satin_al.Models.Firma;

public class IlanOlusturActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText baslik,date;
    Spinner spinner2,sektorlerspinner;
    RadioGroup radioGroup;
    DpHelper helper;
    Button Olustur,button2,button3;
    String poster_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanolustur);

        baslik=findViewById(R.id.baslik);
        date=findViewById(R.id.date);
        radioGroup = findViewById(R.id.radioGroup);
        Olustur=findViewById(R.id.Olustur);
        helper = new DpHelper(this);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        final Firma gelenFirma = (Firma) getIntent().getSerializableExtra("gelenFirma");
        poster_username = gelenFirma.getCompanyMembersNickname();
        // intent database shareprefrencenses birini kullanaraka buraya username getirirsen her şey çalışacak
        // ben suan elcuman olarak aldim ve calisiyor bu haliyle kodlar

        String[] sehirlerArray = new String[] {"Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
                "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
                "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir",
                "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
                "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya",
                "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
                "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak",
                "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak",
                "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"};

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sehirlerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);


        String[] sektörler = new String[] {"Agir Sanayi ve Kimysasal","Enerji","Gida ve Toptancilik","Insaat",
                "Otomobil","Tuketici","Muhendislik ve Uretim","Saglik Hizmetleri","Kamu Sektoru", "Perakende","Tekstil","Tarim","Diger"};

        sektorlerspinner = findViewById(R.id.sektorlerspinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sektörler);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sektorlerspinner.setAdapter(adapter2);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void olustur(View view){
        String text_baslik = baslik.getText().toString();
        RadioButton selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
        String text_radioButton = selectedRadioButton.getText().toString();
        String text_spinner =spinner2.getSelectedItem().toString();
        String text_sektorler =sektorlerspinner.getSelectedItem().toString();
        String text_date=date.getText().toString();

        helper.Poster_Insert(text_baslik,text_radioButton,text_spinner,text_sektorler,text_date, poster_username);

        Toast.makeText(this,"Ilaniniz Olusturuldu",Toast.LENGTH_LONG).show();
    }

    public void TumIlanlar(View view){

        Intent intent=new Intent(this,ilanlar.class);
        intent.putExtra("hepsiMi", true);
        intent.putExtra("username", poster_username);
        startActivity(intent);
    }

    public void firmailanlari (View view){

        Intent intent=new Intent(this,ilanlar.class);
        intent.putExtra("hepsiMi", false);
        intent.putExtra("username", poster_username);
        startActivity(intent);
    }
}
