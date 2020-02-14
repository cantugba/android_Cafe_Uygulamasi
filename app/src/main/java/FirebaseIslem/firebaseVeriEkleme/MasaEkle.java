package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MasaEkle implements IFirebaseDataEkle {
    @Override
    public void firebaseEkle(HashMap mapHash) {
        //kullaniciadı cafe id
        //şifre masa no

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(mapHash.get("CafeId").toString()).child("masa").push();
        myref.child("Numara").setValue(mapHash.get("EklenecekVeri").toString()); // masa no
        myref.child("oyTarihi").setValue(0); // oy kullanma zamanı. Her 4dkda bir oy kullanılabilir.
    }
}
