package FirebaseIslem.firebaseVeriSilme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MuzikSil implements IFirebaseDataSil{
    @Override
    public void firebaseSil(HashMap mapHash) {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(mapHash.get("CafeId").toString()).child("muzik");
        myRef.child(mapHash.get("CafeId").toString()).removeValue();
    }
}
