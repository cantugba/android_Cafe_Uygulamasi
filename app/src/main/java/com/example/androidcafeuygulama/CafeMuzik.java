package com.example.androidcafeuygulama;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import Adapters.Facade;
import FirebaseIslem.firebaseVeriEkleme.MuzikEkle;
import Kullanici.Admin;

public class CafeMuzik extends AppCompatActivity {
    ListView musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_muzik);

        Facade.getNesne().muzikAdapter((ListView)findViewById(R.id.musicListId), this);


    }


    public HashMap<String, String> MapTanimlama(String EklenecekVeri) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("CafeId", Admin.getObject().getCafeId());
        hashMap.put("EklenecekVeri", EklenecekVeri);
        return hashMap;
    }

    public void muzikKayit(View view) {

        EditText musicName = findViewById(R.id.musicNameId);
        Admin.getObject().getProcess().firebaseEkle(new MuzikEkle(), MapTanimlama(musicName.getText().toString()));
        musicName.setText("");
    }
}
