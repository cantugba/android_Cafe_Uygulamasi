package GetFirebaseData;

import android.app.DownloadManager;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import Kullanici.Musteri;

public class GetHesapData implements IGetFirebaseData {
    @Override
    public void firebaseData(String CafeId) {
        Query query = FirebaseDatabase.getInstance().getReference(CafeId).child("Siparişler");
        query.orderByChild("masaId").equalTo(Musteri.getObjeck().getMasaId()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot key : dataSnapshot.getChildren()) {

                    String adet = key.child("adet").getValue().toString();
                    String siparis = key.child("siparis").getValue().toString();
                    String fiyat = key.child("fiyat").getValue().toString();
                    Musteri.getObjeck().siparis(siparis,adet,fiyat);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
