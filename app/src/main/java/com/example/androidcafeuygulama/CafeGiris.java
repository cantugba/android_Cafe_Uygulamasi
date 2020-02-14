package com.example.androidcafeuygulama;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import FirebaseIslem.firebaseVeriEkleme.AdminEkle;
import Giris.Giris;
import Giris.KullaniciAdiGiris;
import Islemler.CreateToast;
import Islemler.Thread.AdminGirisThread;

public class CafeGiris extends AppCompatActivity {
    private Button backbutton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_giris);

        CreateToast.setContext(this);

        backbutton =(Button) findViewById(R.id.backButton);

        backbutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i =new Intent(CafeGiris.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public  String[] kayitBilgi() // kayıt olmada EditText'lerden bilgileri alıp geriye dizi şeklinde gönderiyor.
    {
        EditText kullaniciAd = findViewById(R.id.kullaniciAdi);
        EditText sifre = findViewById(R.id.sifre);
        String[] veriler =new String[2];
        veriler[0] = kullaniciAd.getText().toString();
        veriler[1] =sifre.getText().toString();

        return veriler;
    }

    public void kayitOl(View view) //firebase kayıt olma islevi
    {
        String[] veriler = this.kayitBilgi();

        if(veriler[0].length() > 10 && veriler[1].length() >=7){
            AdminEkle ekle = new AdminEkle();
            ekle.adminEkle(this.kayitBilgi()[0],this.kayitBilgi()[1],this);

            AdminGirisThread adminGirisThread =new AdminGirisThread(CafeGiris.this,getWindowManager().getDefaultDisplay());
            adminGirisThread.threatBaslat(this,'K');

        } else
            CreateToast.makeToast("Kullanıcı adı ve şifrenizi uzun giriniz:  ");
    }

    public String[] adminGirisBilgi() // admin girisinde EditText'lerden bilgileri alıp geriye dizi şeklinde gönderiyor.
    {
      EditText kullaniciAd =findViewById(R.id.kullaniciAdi);
      EditText sifre = findViewById(R.id.sifre);
      String[] veriler =new String[2];
      veriler[0] = kullaniciAd.getText().toString();
      veriler[1] = sifre.getText().toString();

      return veriler;
    }

    public void adminGiris(View view) //firebase admin giris islevi
    {
        String[] veriler = this.adminGirisBilgi();
        if(veriler[0].length()>10 && veriler[1].length() >=7){
            Giris giris = new Giris();
            giris.giris(new KullaniciAdiGiris(),veriler[0],veriler[1],this);

            AdminGirisThread adminGirisThread = new AdminGirisThread(CafeGiris.this,getWindowManager().getDefaultDisplay());
            adminGirisThread.threatBaslat(this,'A');
        }else
            CreateToast.makeToast("Sifre ve Kullanıcı adınızı uzun giriniz.");

    }

    public void yonlendirme() //firebase admin giris sonucu
    {
        Intent i = new Intent(CafeGiris.this,CafeYonetimi.class);
        startActivity(i);
        finish();
    }

}
