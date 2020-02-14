package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import FirebaseDataList.FirebaseDataList;
import FirebaseIslem.FirebaseIslem;
import Islemler.CreateToast;
import Islemler.HashMapHazirla;
import Kullanici.Musteri;

public class OyKullan {
    public void oyKullan(int Index) {   // index muzik dizisindeki id. Bu id listieve tıklanmada gelicek

        Date simdikiZaman = new Date();
        System.out.println(simdikiZaman.toString());
        DateFormat df = new SimpleDateFormat("H:m");
        String sistemSaat = df.format(simdikiZaman);

        int fark = saatIslem(sistemSaat);
        if (fark >= 4) //true olması oy kullanılabilir demektir
        {
            int oy = FirebaseDataList.getMusicList().getOy(Index) + 1;
            String cafeId = Musteri.getObjeck().getCafeId();
            String muzikId = FirebaseDataList.getMusicList().getFirebaseKey(Index);
            DatabaseReference myref = FirebaseDatabase.getInstance().getReference(cafeId).child("muzik").child(muzikId);
            myref.child("oy").setValue(oy);

            Musteri.getObjeck().setOyTarihi(sistemSaat);
            masaSaatDegis();
        } else {
            int oyKullanmaZamani = 4 - fark;
            CreateToast.makeToast(oyKullanmaZamani + "dakika sonra oy kullanabilirsiniz.");

        }


    }

    private void masaSaatDegis() {
        FirebaseIslem firebaseIslem = new FirebaseIslem();
        HashMapHazirla hashMapHazirla = new HashMapHazirla();

        HashMap hashMap = hashMapHazirla.oyverHashMap(Musteri.getObjeck().getCafeId(), Musteri.getObjeck().getMasaId(), Musteri.getObjeck().getOyTarihi());

        firebaseIslem.firebaseEkle(new OyEkle(), hashMap);
    }

    private int saatIslem(String saatSistem) {
        String[] sistemSaat = saatSistem.split(":");
        String[] musteriSaat = Musteri.getObjeck().getOyTarihi().split(":");

        return saatFarki(sistemSaatConvert(sistemSaat), musteriSaatConvert(musteriSaat));
    }

    private int saatFarki(int[] sistemSaatInteger, int[] musteriSaatInteger) {
        int saatFarki = ((sistemSaatInteger[0] - musteriSaatInteger[0]) * 60) + (sistemSaatInteger[1] - musteriSaatInteger[1]);
        return saatFarki;
    }

    private int[] sistemSaatConvert(String[] sistemSaat) {
        int[] sistemSaatInteger = new int[2];
        sistemSaatInteger[0] = Integer.parseInt(sistemSaat[0]);
        sistemSaatInteger[1] = Integer.parseInt(sistemSaat[1]);

        return sistemSaatInteger;
    }

    private int[] musteriSaatConvert(String[] musteriSaat){
        int[] musteriSaatInteger = new int[2];
        musteriSaatInteger[0] = Integer.parseInt(musteriSaat[0]);
        musteriSaatInteger[1] = Integer.parseInt(musteriSaat[0]);

        return musteriSaatInteger;
    }
}
