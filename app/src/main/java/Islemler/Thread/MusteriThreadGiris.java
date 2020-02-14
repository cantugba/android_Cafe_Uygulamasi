package Islemler.Thread;

import android.content.Context;
import android.view.Display;

import com.example.androidcafeuygulama.MainActivity;

import Islemler.CreateToast;
import Islemler.FirebaseBoolean;

public class MusteriThreadGiris extends ToastLoad {

    public MusteriThreadGiris(Context context, Display display){
        super(context, display);
    }

    public void threadBaslat(MainActivity mainActivity) //firebase gecikmesini kontrol ediyor
    {
        this.showLt("Giriş Yapılıyor");
        final MainActivity Main=mainActivity;

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (FirebaseBoolean.getLoginAddFonksiyonaGirisKontrol())
                {
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hideLt();
                        musteriGiris(Main);
                    }
                });
            }
        });
        thread.start();


    }

    private void musteriGiris(MainActivity mainActivity) // firebase admin giris sonucu
    {
        if(FirebaseBoolean.getLoginAddIslemSonucKontrol()){
            mainActivity.yonlendir();
        }
        else{
            CreateToast.makeToast("Kullanıcı adı veya şifreniz yanlış");
        }

    }
}
