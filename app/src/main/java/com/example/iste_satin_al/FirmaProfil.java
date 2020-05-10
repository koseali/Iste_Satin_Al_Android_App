package com.example.iste_satin_al;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iste_satin_al.Models.Firma;

public class FirmaProfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firma_profil);

        final Firma gelenFirma = (Firma) getIntent().getSerializableExtra("gelenFirma");

        TextView textViewMemberName = findViewById(R.id.tvName);
        TextView textViewMemberSurname = findViewById(R.id.tvSurname);
        TextView textViewMemberNickname = findViewById(R.id.tvNickname);
        TextView textViewPassword = findViewById(R.id.tvPassword);
        TextView textViewEmail = findViewById(R.id.tvEmail);
        TextView textViewMemberPhone = findViewById(R.id.tvUserPhone);
        TextView textViewCompanyName = findViewById(R.id.tvCompanyName);
        TextView textViewCompanyId = findViewById(R.id.tvCompanyId);
        TextView textViewCompanyPhone = findViewById(R.id.tvCompanyPhone);
        TextView textViewCompanyType = findViewById(R.id.tvCompanyType);


        assert gelenFirma != null;
        textViewMemberName.setText(gelenFirma.getCompanyMembersName());
        textViewMemberSurname.setText(gelenFirma.getCompanyMembersSurname());
        textViewMemberNickname.setText(gelenFirma.getCompanyMembersNickname());
        textViewPassword.setText(gelenFirma.getCompanyMembersPassword());
        textViewEmail.setText(gelenFirma.getCompanyMembersEmail());
        textViewMemberPhone.setText(gelenFirma.getCompanyMembersPhone());

        textViewCompanyName.setText(gelenFirma.getCompanyName());
        textViewCompanyId.setText(gelenFirma.getCompanyId());
        textViewCompanyPhone.setText(gelenFirma.getCompanyPhone());
        textViewCompanyType.setText(gelenFirma.getCompanyType());



    }

    public void Delete(View view){
        DpHelper helper = new DpHelper(this);
        final Firma gelenFirma = (Firma) getIntent().getSerializableExtra("gelenFirma");
        helper.DeleteMembers(gelenFirma.getCompanyMembersId());
        Intent intent = new Intent(this,MainActivity.class);
        Toast.makeText(this,"Hesabınız Silindi.",Toast.LENGTH_LONG).show();
        startActivity(intent);
        finish();


    }


}
