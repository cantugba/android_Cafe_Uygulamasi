package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FiyatDegis implements IFirebaseDataEkle {
    @Override
    public void firebaseEkle(HashMap hashMap) {
        //String CafeId, String MenuKatagori, String KatagoriId, String YeniDeger
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(hashMap.get("CafeId").toString()).child("Menu").child(hashMap.get("MenuKatagori").toString()).child(hashMap.get("KatagoriId").toString());
        myref.child("Fiyat").setValue(hashMap.get("YeniDeger").toString());

    }
}
