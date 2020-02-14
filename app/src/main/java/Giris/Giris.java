package Giris;

import android.app.Activity;

public class Giris {

    public void giris(IQRGiris Qr , String CafeId, String MasaId){
        Qr.giris(CafeId,MasaId);
    }

    public void giris(IKullaniciAdiGiris KullaniciGiris,String KullaniciAdi, String Sifre, Activity activity){
        KullaniciGiris.giris(KullaniciAdi,Sifre,activity);
    }
}
