package Islemler;

import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.HashMap;

import FirebaseIslem.FirebaseIslem;
import FirebaseIslem.firebaseVeriEkleme.SiparisEkle;
import Islemler.HideShow.HideShow;
import Kullanici.Musteri;

public class SiparisVer {

    public void  SiparisHazirla(EditText editText, TextView textView, ConstraintLayout constraintLayout){

        String adet = editText.getText().toString();
        String siparis[] = regexFiyat(textView.getText().toString());


        if(Integer.parseInt(adet) >= 1 && siparis.length >=2){
            HashMapHazirla hashMapHazirla = new HashMapHazirla();

            HashMap siparisHashMap = hashMapHazirla.SiparisHashMap(siparis,adet);

            textBosalt(editText,textView);

            this.siparisVer(siparisHashMap);
            this.gizleLayout(constraintLayout);
        }

        else{

            CreateToast.makeToast("Lütfen seçimlerinizi yapınız");
        }

    }

    private void textBosalt(EditText editText,TextView textView){

        textView.setText("");
        editText.setText("");
    }

    private String [] regexFiyat(String fiyat){
        return fiyat.split("Fiyat=");
    }

    private void gizleLayout(ConstraintLayout constraintLayout)
    {
        HideShow hideShow = new HideShow();
        hideShow.hide(constraintLayout);
    }

    private void siparisVer(HashMap siparisHashMap){

        FirebaseIslem firebaseIslem = new FirebaseIslem();
        firebaseIslem.firebaseEkle(new SiparisEkle(),siparisHashMap);
    musteriSiparisEkle(siparisHashMap);
}

    private void musteriSiparisEkle(HashMap hashMap){

        Musteri.getObjeck().siparis(hashMap.get("siparis").toString(),hashMap.get("adet").toString(),hashMap.get("fiyat").toString());
    }
}
