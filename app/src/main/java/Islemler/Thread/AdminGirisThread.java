package Islemler.Thread;

import android.content.Context;
import android.view.Display;

import com.example.androidcafeuygulama.CafeGiris;

import Islemler.CreateToast;
import Islemler.FirebaseBoolean;
import Kullanici.Admin;

public class AdminGirisThread extends ToastLoad { //birden fazla işlemin tek program içinde gerçeklemesi

    public AdminGirisThread(Context context, Display display){
        super(context,display);
    }

    public void threatBaslat(CafeGiris cafeGiris, char Secenek) // firebase gecikmesini kontrol eden thread
    {
        this.showLt("Giris Yapılıyor");
        final CafeGiris girisCafe = cafeGiris;
        final char secenek = Secenek;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while (FirebaseBoolean.getLoginAddFonksiyonaGirisKontrol()) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        runOnUiThread(new Runnable() {
                            public void run() {
                                hideLt();
                                if (secenek == 'A')
                                    adminSonuc(girisCafe);
                                else if (secenek == 'K')
                                    kayitSonuc();

                            }
                        });
                    }
                });

                thread.start();
            }
        });

        thread.start();
    }

    private void adminSonuc(CafeGiris girisCafe) //firebase admin giris sonucu
    {
        if(FirebaseBoolean.getLoginAddIslemSonucKontrol()){
            girisCafe.yonlendirme();
        }
        else{
            CreateToast.makeToast("Kullanıcı adı veya şifre yanlış");
        }
    }

    private void kayitSonuc(){
        if(FirebaseBoolean.getLoginAddIslemSonucKontrol())
            CreateToast.makeToast("Kayıt işleminiz başarıyla gerçekleştirilmiştir. Lütfen giris yapınız.");
        else
            CreateToast.makeToast(("Kayıt Olunamadı."));
    }

}

