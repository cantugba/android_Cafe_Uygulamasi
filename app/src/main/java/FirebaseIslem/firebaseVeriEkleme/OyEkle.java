package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class OyEkle implements IFirebaseDataEkle {
    @Override
    public void firebaseEkle(HashMap mapHash) {
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(mapHash.get("CafeId").toString()).child("masa").child(mapHash.get("MasaId").toString());
        myref.child("oyTarihi").setValue(mapHash.get("oyZamani").toString());
    }
}
