package com.example.androidcafeuygulama;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.HashMap;

import Adapters.Facade;
import FirebaseDataList.FirebaseDataList;
import FirebaseIslem.firebaseVeriEkleme.OyKullan;
import Islemler.CreateToast;
import Islemler.HideShow.ButtonsHideShow;
import Islemler.HideShow.HideShow;
import Islemler.SiparisVer;
import Islemler.Thread.MusteriDataThread;

public class Musteri extends AppCompatActivity {
    HideShow hideShow;
    Spinner menuGruplari;
    ListView menuList, hesapList, muzikList;
    Context context = this;
    Musteri customer = this;
    TextView toplamTutar, musteriOyVerText;
    int listMuzikKey = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musteri);
        CreateToast.setContext(this);
        hideShow = new HideShow();
        tanimla();

        threadBaslat();
        menuGruplari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Facade.getNesne().musteriMenuAdapter(menuList, context, i, customer);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        muzikList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                musteriOyVerText.setText(FirebaseDataList.getMusicList().getValueName(i));
                listMuzikKey = i;
            }
        });

    }

    public void anaSayfaGoster(View view) // kontrol yapılmadan ana sayfa harici tüm layoutlar gizleniyor.
    {
        ButtonsHideShow buttonlarHideShow = new ButtonsHideShow();
        buttonlarHideShow.buttonlariGoster(buttonsDizi());


        hideShow.hide((RelativeLayout) findViewById(R.id.hesapLayout)); // hesap layout
        hideShow.hide((RelativeLayout) findViewById(R.id.MenuListesi)); // menu listesi
        hideShow.hide((ConstraintLayout) findViewById(R.id.SiparisVer)); // menunun altındaki sipariş verme
        hideShow.hide((RelativeLayout) findViewById(R.id.MuzikListLayout));
    }

    public void menuGoster(View view) {
        anasayfaButtonGizle();

        hideShow.show((RelativeLayout) findViewById(R.id.MenuListesi));
        Facade.getNesne().musteriGrupAdapter(menuGruplari, this);

    }

    public void hesapGoster(View view) {
        anasayfaButtonGizle();

        hideShow.show((RelativeLayout) findViewById(R.id.hesapLayout));
        Facade.getNesne().hesapAdapter(hesapList, this);
        tutarTopla();


    }

    public void muzikGoster(View view) {
        anasayfaButtonGizle();
        hideShow.show((RelativeLayout) findViewById(R.id.MuzikListLayout));
        Facade.getNesne().muzikAdapter(muzikList, this);

    }

    public void siparisOnay(View view) {
        SiparisVer siparisVer = new SiparisVer();
        siparisVer.SiparisHazirla((EditText) findViewById(R.id.SiparisAdeti), (TextView) findViewById(R.id.MusteriSiparisText), (ConstraintLayout) findViewById(R.id.SiparisVer));
    }

    public void muzikOyVer(View view)
    {
        if(musteriOyVerText.getText().length()>1)
        {
            OyKullan oyKullan = new OyKullan();
            oyKullan.oyKullan(listMuzikKey);
        }
    }

    public void anasayfaButtonGizle() {
        ButtonsHideShow buttonlarHideShow = new ButtonsHideShow();
        buttonlarHideShow.buttonlariGizle(buttonsDizi());
    }

    public Button[] buttonsDizi() {
        Button butonlar[] = new Button[3];

        butonlar[0] = findViewById(R.id.MusteriHesapButton);
        butonlar[1] = findViewById(R.id.MusteriMenuButton);
        butonlar[2] = findViewById(R.id.MusteriMuzikButton);
        return butonlar;
    }


    public void threadBaslat() {

        Button button[] = new Button[3];
        button[0] = findViewById(R.id.MusteriMuzikButton);
        button[1] = findViewById(R.id.MusteriMenuButton);
        button[2] = findViewById(R.id.MusteriHesapButton);
        MusteriDataThread musteriDataThread = new MusteriDataThread(this, getWindowManager().getDefaultDisplay());

        musteriDataThread.firebaseThread(button);
    }

    public void tanimla() {
        //MenuList
        menuGruplari = findViewById(R.id.MenuGruplari);
        menuList = findViewById(R.id.MenuList);
        hesapList = findViewById(R.id.HesapList);
        toplamTutar = (TextView) findViewById(R.id.MusteriHesapToplamTutar);
        muzikList = findViewById(R.id.muzikList);
        musteriOyVerText = findViewById(R.id.MusteriOyVerText);
    }


    public void siparisVer(String urunAd, String fiyat) {
        hideShow.show((ConstraintLayout) findViewById(R.id.SiparisVer));
        TextView textView = findViewById(R.id.MusteriSiparisText);
        textView.setText(urunAd + " " + fiyat);
    }

    public void tutarTopla() {

        float toplam = 0;

        for (HashMap hashMap : Kullanici.Musteri.getObjeck().getSiparisler())
            toplam += Float.parseFloat(hashMap.get("fiyat").toString());

        toplamTutar.setText(toplam + "TL");

    }





}
