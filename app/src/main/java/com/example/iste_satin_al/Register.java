package com.example.iste_satin_al;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

public class Register extends AppCompatActivity {
MaskEditText etphone,etVergiNumarasi,etFirmaTel;
EditText etname,etsurname,etnickname,etmail,etcompanyname,etpass,etpass2,etcompanytype;
ImageView ivback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etname = findViewById(R.id.etname);
        etsurname = findViewById(R.id.etsurname);
        etnickname = findViewById(R.id.etnickname);
        etpass = findViewById(R.id.etpass);
        etpass2 = findViewById(R.id.etpass2);
        etphone = findViewById(R.id.etphonee);
        etmail = findViewById(R.id.etemail);

        etVergiNumarasi = findViewById(R.id.etVergiNumarasi);
        etFirmaTel = findViewById(R.id.etFirmaTel);
        etcompanyname = findViewById(R.id.etFirma);
        etcompanytype = findViewById(R.id.etFirmaTipi);

        ivback = findViewById(R.id.ivBack);
    }

    public void Register(View view){
        try {
         String name = etname.getText().toString().trim();
         String surname = etsurname.getText().toString().trim();
         String nickname = etnickname.getText().toString().trim();
            String email = etmail.getText().toString().trim();
         String password = etpass.getText().toString().trim();
         String password2 = etpass2.getText().toString().trim();
         //int phone =  Integer.parseInt( etphone.getRawText().trim());
            String phone = etphone.getRawText();

            if (name.isEmpty()){ Toast.makeText(this,"İsim Boş Bırakılamaz.",Toast.LENGTH_LONG).show(); etname.requestFocus(); return;}
            if (surname.isEmpty()){ Toast.makeText(this,"Soyad Boş Bırakılamaz.",Toast.LENGTH_LONG).show();etsurname.requestFocus(); return;}
            if (nickname.isEmpty()){ Toast.makeText(this,"Kullanıcı adı Boş Bırakılamaz.",Toast.LENGTH_LONG).show();etnickname.requestFocus(); return;}
            if (email.isEmpty()){ Toast.makeText(this,"Mail Boş Bırakılamaz.",Toast.LENGTH_LONG).show();etmail.requestFocus(); return;}
            if(!email.contains("@")){ Toast.makeText(this,"Mail formatı uygun degil.",Toast.LENGTH_LONG).show();etmail.requestFocus();return;}
            //if ("".equals(phone)){ Toast.makeText(this,"Telefon Boş Bırakılamaz.",Toast.LENGTH_LONG).show();etphone.requestFocus(); return;}

            if (!password.equals(password2)){Toast.makeText(this,"Parolalar eslesmiyor",Toast.LENGTH_LONG).show();
                etpass.requestFocus();
                return ;};
             if(password.length() < 8){
                 Toast.makeText(this,"Parola En az 8 Karakterli olmalıdır",Toast.LENGTH_LONG).show();etpass.requestFocus();return; }
             if(password.contains(",")){Toast.makeText(this,"Parolada yabancı işaretler bulunmamalıdır",Toast.LENGTH_LONG ).show();};



         String companytype = etcompanyname.getText().toString().trim();
         String company = etcompanyname.getText().toString().trim();
         String  companynum =  etVergiNumarasi.getRawText().trim();
         String companyphone =  etFirmaTel.getRawText().trim();

            if(companytype.isEmpty()){ Toast.makeText(this,"Firma Türü Boş Bırakılamaz.",Toast.LENGTH_LONG).show(); return;}
            if (company.isEmpty()){ Toast.makeText(this,"Firma Adı boş bırakılamaz.",Toast.LENGTH_LONG).show(); return;}
            if (companynum.isEmpty()){ Toast.makeText(this,"Vergi Numarası Boş Bırakılamaz.",Toast.LENGTH_LONG).show(); return;}
            if (companyphone.isEmpty()){ Toast.makeText(this,"Vergi Numarası Boş Bırakılamaz.",Toast.LENGTH_LONG).show(); return;}



            //bir ton kontrol yapılacak burada şifre 8 karakterden az olamaz şartı koymuşuz o banko olacak

            DpHelper helper = new DpHelper(this);
            String  result = helper.AddMembers(name,surname,nickname,password,email,phone,company,companynum,companyphone,companytype);

            if(result.contains("Basarili")){
             Intent intent = new Intent(this,MainActivity.class);
                Toast.makeText(this,result,Toast.LENGTH_LONG).show();
                startActivity(intent);

         }


        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show(); }

    }
    public void Back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }
}
