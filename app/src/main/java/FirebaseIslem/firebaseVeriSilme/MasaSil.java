package FirebaseIslem.firebaseVeriSilme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MasaSil implements IFirebaseDataSil {
    @Override
    public void firebaseSil(HashMap mapHash) {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(mapHash.get("CafeId").toString()).child("masa");
        myRef.child(mapHash.get("SilinecekVeri").toString()).removeValue();
    }
}
