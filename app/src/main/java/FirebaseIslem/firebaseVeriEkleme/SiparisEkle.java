package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SiparisEkle implements IFirebaseDataEkle {
    @Override
    public void firebaseEkle(HashMap mapHash) {
        Date simdikiZaman = new Date();
        DateFormat df = new SimpleDateFormat("H:m");
        String saat =df.format(simdikiZaman);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(mapHash.get("CafeId").toString()).child("siparisler").push();
        myref.child("siparisDurum").setValue(0);
        myref.child("adet").setValue(mapHash.get("adet").toString());
        myref.child("fiyat").setValue(mapHash.get("fiyat").toString());
        myref.child("masaId").setValue(mapHash.get("masaId").toString());
        myref.child("siparis").setValue(mapHash.get("siparis").toString());
        myref.child("tarih").setValue(saat);


    }
}
