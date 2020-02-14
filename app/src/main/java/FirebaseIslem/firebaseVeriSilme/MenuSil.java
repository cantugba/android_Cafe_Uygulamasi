package FirebaseIslem.firebaseVeriSilme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuSil {
    public void firebaseSil(String CafeId, String MenuKategori, String SilinecekVeri) {
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(CafeId).child("Menu").child(MenuKategori);
        myref.child(SilinecekVeri).removeValue();
    }
}
