package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MuzikEkle implements IFirebaseDataEkle{
    @Override
    public void firebaseEkle(HashMap mapHash) {
        //Kullanici adi cafeid
        //Şifre Muizk adi

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(mapHash.get("CafeId").toString()).child("muzik").push();
        myref.child("muzikAdi").setValue(mapHash.get("EklenecekVeri").toString());
        myref.child("oy").setValue(0);
    }
}
