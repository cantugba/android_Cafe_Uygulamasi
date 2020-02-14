package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MenuEkle implements IFirebaseDataEkle{
    @Override
    public void firebaseEkle(HashMap mapHash) {
        String CafeId =  mapHash.get("CafeId").toString();
        String MenuKategori = mapHash.get("MenuKategori").toString();
        String UrunAdi = mapHash.get("UrunAdi").toString();
        String Fiyat = mapHash.get("Fiyat").toString();

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(CafeId).child("Menu").child(MenuKategori).push();
        myref.child("Urun").setValue(UrunAdi);
        myref.child("Fiyat").setValue(Fiyat);
    }
}
