package com.example.iste_satin_al;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.iste_satin_al.Models.Firma;
import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private DrawerLayout drawer;
    String poster_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Firma gelenFirma = (Firma) getIntent().getSerializableExtra("gelenFirma");
        // ana sayfada bir şey ne yapacaz

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnaSayfaFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_anasayfa);
        }


    }
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final Firma gelenFirma = (Firma) getIntent().getSerializableExtra("gelenFirma");
        poster_username = gelenFirma.getCompanyMembersNickname();
        switch (item.getItemId()){

            case R.id.nav_anasayfa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnaSayfaFragment()).commit();
                break;

            case R.id.nav_firma_profil:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirmaProfilFragment()).commit();

               Intent intent = new Intent(this,FirmaProfil.class);
               intent.putExtra("gelenFirma",gelenFirma);;
               startActivity(intent);

                break;
            case R.id.nav_firma_ilan:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirmaIlanFragment()).commit();
                Intent intentt=new Intent(this,ilanlar.class);
                intentt.putExtra("hepsiMi", false);
                intentt.putExtra("username", poster_username);
                startActivity(intentt);
                break;
            case R.id.nav_tum_ilanlar:
                Intent intennt=new Intent(this,ilanlar.class);
                intennt.putExtra("hepsiMi", true);
                intennt.putExtra("username", poster_username);
                startActivity(intennt);

                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TumIlanFragment()).commit();
                break;

            case R.id.nav_ilan_olustur:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new IlanOlusturFragment()).commit();

                //Firma ile alakalı bilgi çekersek kullanıırız
                Intent in = new Intent(this,IlanOlusturActivity.class);
                in.putExtra("gelenFirma",gelenFirma);;

                startActivity(in);
                break;

            case R.id.nav_web:
                Uri uri = Uri.parse("https://istesatinal.com");
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
