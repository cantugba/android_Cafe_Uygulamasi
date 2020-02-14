package com.example.androidcafeuygulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CafeMenuTercih extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_menu_tercih);


    }
    public void menuGecis(View view) {

        Intent i = new Intent(CafeMenuTercih.this, CafeMenuGrup.class);
        startActivity(i);


    }


    public void MenuGrupEkle(View view) {

        Intent i = new Intent(CafeMenuTercih.this, CafeMenuFiyatDegistirme.class);
        startActivity(i);

    }

}
