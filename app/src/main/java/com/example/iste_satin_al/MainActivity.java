package com.example.iste_satin_al;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iste_satin_al.Models.Firma;

public class MainActivity extends AppCompatActivity {
    EditText etnickname,etpass;
    CheckBox checkHatirla ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().hide(); // action saklamak için
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnickname = findViewById(R.id.etLogKullanici);
        etpass = findViewById(R.id.etLogPass);
        checkHatirla = findViewById(R.id.chckHatirla);
        Remember remember = new Remember(this);
        String nick = remember.Load("Nickname");
        String pas = remember.Load("Password");
       if(!nick.isEmpty()|| !pas.isEmpty() ){
           etnickname.setText(nick);
           etpass.setText(pas); }

        etnickname.setText(remember.Load("Nickname"));
        etpass.setText(remember.Load("Password"));
    }

    public void Login(View view){
        try { String msg = "";
            String nickname = etnickname.getText().toString().trim();
            String password = etpass.getText().toString().trim();

            if(nickname.isEmpty() || password.isEmpty()){ Toast.makeText(this,"mail veya parola boş bırakılamaz.",Toast.LENGTH_LONG).show();return; };
            DpHelper helper = new DpHelper(this);
            String result = helper.Login(nickname,password);
            Toast.makeText(this,result,Toast.LENGTH_LONG).show();

            if(result.contains("Basarili")){

                Firma gelenFirma = new Firma();

                gelenFirma = helper.getFirma(nickname,password);

               Intent intent = new Intent(this, home.class);
               intent.putExtra("gelenFirma",gelenFirma);


                if(checkHatirla.isChecked()){  Remember remember = new Remember(this);
                                                remember.Save("Nickname",nickname);
                                                remember.Save("Password",password);
                } else{
                    Remember remember = new Remember(this);
                    remember.Remove("Nickname");
                    remember.Remove("Password");
                }
              startActivity(intent);
                finish();

            }




        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }

    public  void Register(View view){
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);
    }


}
