package Islemler.Thread;

import android.content.Context;
import android.view.Display;
import android.widget.Button;

import Islemler.FirebaseBoolean;
import Islemler.HideShow.ButtonHideShow;
import Islemler.HideShow.ButtonsHideShow;

public class AdminDataThread extends ToastLoad{

    public AdminDataThread(Context context, Display display){
        super(context,display);
    }
    public void firebaseThread(Button button[]) // firebaseden gelen verilerin gecikmesini kontrol ediyor.
    {
        final ButtonsHideShow hideShow= new ButtonsHideShow();
        final Button buttonlar[] = button;

        hideShow.buttonlariGizle(buttonlar);
        this.showLt("Veriler Çekiliyor");

        Thread thread  = new Thread(new Runnable(){

            @Override
            public void run() {
                while (FirebaseBoolean.getMenuFonksiyonaGirisKontrol()
                ||
                FirebaseBoolean.getMasaFonksiyonaGirisKontrol()
                ||
                FirebaseBoolean.getMuzikFonksiyonaGirisKontrol()
                ){
                    try{
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hideLt();
                        hideShow.buttonlariGoster(buttonlar);
                    }
                });
            }
        });

        thread.start();
    }




}
