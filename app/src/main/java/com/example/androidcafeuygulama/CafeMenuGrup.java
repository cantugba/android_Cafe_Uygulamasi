package com.example.androidcafeuygulama;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import Adapters.Facade;
import FirebaseIslem.firebaseVeriEkleme.MenuEkle;
import Islemler.CreateToast;
import Islemler.HideShow.HideShow;
import Kullanici.Admin;

public class CafeMenuGrup extends AppCompatActivity {
    HideShow hideShow;
    String grupAdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_menu_grup);

        hideShow = new HideShow();

        CreateToast.setContext(this);
        Facade.getNesne().grupAdapter((ListView) findViewById(R.id.grupList), this, this);

    }


    public void menuGir(String grupAdi, int Key) {
        menuLayoutGizle();

        hideShow.show((RelativeLayout) findViewById(R.id.UrunGirmeLayout));
        hideShow.show((Button) findViewById(R.id.addMenu));
        hideShow.show((RelativeLayout)findViewById(R.id.MenuListe));
        this.grupAdi = grupAdi;
        Facade.getNesne().adminMenu((ListView)findViewById(R.id.menuListesi), this, Key);
    }

    public void groupEkle(View view) {

        menuLayoutGizle();

        hideShow.show((RelativeLayout) findViewById(R.id.UrunGirmeLayout));
        hideShow.show((RelativeLayout) findViewById(R.id.GroupAddLayout));
        hideShow.show((Button) findViewById(R.id.addNewGroup));
    }

    public void yeniGrupEkle(View view) {

        String [] urunAdFiyatGroup = editMetin();
        eklemeIslem(urunAdFiyatGroup[0], urunAdFiyatGroup[1], urunAdFiyatGroup[2]);
    }

    public void yeniMenuEkle(View view) {
        String [] urunAdFiyat = editMetin();
        eklemeIslem(urunAdFiyat[0], urunAdFiyat[1], this.grupAdi);
    }


    public void menuLayoutGoster() {
        hideShow.show((RelativeLayout) findViewById(R.id.listViewLayout));
        hideShow.show((Button) findViewById(R.id.addGroup));


        hideShow.hide((RelativeLayout) findViewById(R.id.UrunGirmeLayout));
        hideShow.hide((RelativeLayout) findViewById(R.id.GroupAddLayout));
        hideShow.hide((RelativeLayout)findViewById(R.id.MenuListe));
        hideShow.hide((Button) findViewById(R.id.addNewGroup));
        hideShow.hide((Button) findViewById(R.id.addMenu));
    }

    public void menuLayoutGizle() {
        hideShow.hide((RelativeLayout) findViewById(R.id.listViewLayout));
        hideShow.hide((Button) findViewById(R.id.addGroup));
    }



    public String[] editMetin() {
        EditText urunAd = findViewById(R.id.urunAD);
        EditText urunFiyat = findViewById(R.id.urunFiyat);
        EditText groupAd = findViewById(R.id.groupAd);

        String [] urunAdFiyat = new String[3];
        urunAdFiyat[0] = urunAd.getText().toString();
        urunAdFiyat[1] = urunFiyat.getText().toString();
        urunAdFiyat[2] = groupAd.getText().toString();

        urunAd.setText("");
        urunFiyat.setText("");
        groupAd.setText("");

        return urunAdFiyat;
    }

    public void eklemeIslem(String urunAd, String urunFiyat, String groupAd) {
        if (urunAd.length() >= 3 && urunFiyat.length() >= 1 && groupAd.length() >= 3) {
            Admin.getObject().getProcess().firebaseEkle(new MenuEkle(), hasmapHazirla(urunAd, urunFiyat, groupAd));

        }
        menuLayoutGoster();
    }

    public HashMap hasmapHazirla(String urunAd, String urunFiyat, String groupAd) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("CafeId", Admin.getObject().getCafeId());
        hashMap.put("MenuKategori", groupAd);
        hashMap.put("UrunAdi", urunAd);
        hashMap.put("Fiyat", urunFiyat);
        return hashMap;
    }

}
