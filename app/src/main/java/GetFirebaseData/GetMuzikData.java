package GetFirebaseData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;

import Adapters.Facade;
import FirebaseDataList.FirebaseDataList;
import Islemler.FirebaseBoolean;

public class GetMuzikData implements IGetFirebaseData {
    @Override
    public void firebaseData(String CafeId) {
        FirebaseDataList.getMusicList().setOy();
        FirebaseDataList.getMusicList().setFirebaseKey();
        FirebaseDataList.getMusicList().setValueName();

        FirebaseBoolean.setMuzikFonksiyonaGirisKontrol(true);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(CafeId).child("muzik");
        myref.orderByChild("oy").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                FirebaseDataList.getMusicList().listClear();

                for (DataSnapshot key : dataSnapshot.getChildren()) {
                    FirebaseDataList.getMusicList().setValueName(key.child("muzikAdi").getValue().toString());
                    FirebaseDataList.getMusicList().setFirebaseKey(key.getKey());
                    try {
                        // muzik adı oydan önce eklendiğinden, vote değeri null gelme durumu var.
                        FirebaseDataList.getMusicList().setOy(Integer.parseInt(key.child("vote").getValue().toString()));
                    } catch (Exception e) {
                    }
                    //
                }

                // Collections.reverse ile müzik listesi büyükten küçüğe sıralanmış oluyor.
                Collections.reverse(FirebaseDataList.getMusicList().getOy());
                Collections.reverse(FirebaseDataList.getMusicList().getFirebaseKey());
                Collections.reverse(FirebaseDataList.getMusicList().getValueName());
                FirebaseBoolean.setMuzikFonksiyonaGirisKontrol(false);
                if ( Facade.getNesne().getMuzikAdapter() != null ) // eğer admin girişi yapılmiş ve ilk yüklemenin ardından 2. yükleme geliyorsa gelen data setleniyor.
                {
                    Facade.getNesne().getMuzikAdapter().notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}
