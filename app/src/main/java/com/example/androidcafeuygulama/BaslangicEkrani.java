package com.example.androidcafeuygulama;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaslangicEkrani extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.baslangic);
        Thread mSplashThread;//thread classdan obje olustrduk uygulmann 4 saniye uyutulmasi icin
        mSplashThread = new Thread(){
            @Override public void run(){
                try {

                    synchronized(this){
                        wait(2500);
                    }
                }catch(InterruptedException ex){

                }
                finally{

                    Intent i=new Intent(BaslangicEkrani.this,MainActivity.class); //aktiviteler arası geçiş
                    startActivity(i);
                    finish();
                }

            }
        };//thread objesini olusturduk ve istediğimz sekilde sekillendrdik
        mSplashThread.start();// thread objesini calistriyoruz

    }

}
