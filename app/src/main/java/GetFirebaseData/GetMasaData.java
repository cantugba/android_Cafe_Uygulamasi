package GetFirebaseData;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Adapters.Facade;
import FirebaseDataList.FirebaseDataList;
import Islemler.FirebaseBoolean;

public class GetMasaData implements IGetFirebaseData {
    @Override
    public void firebaseData(String CafeId) {
        FirebaseDataList.getTableList().setFirebaseKey();
        FirebaseDataList.getTableList().setValueName();

        FirebaseBoolean.setMasaFonksiyonaGirisKontrol(true);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child("masa");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FirebaseDataList.getTableList().listClear();
                for(DataSnapshot key : dataSnapshot.getChildren()){
                    FirebaseDataList.getTableList().setValueName(key.child("Numara").getValue().toString()); // masa numarası
                    FirebaseDataList.getTableList().setFirebaseKey(key.getKey()); // masa key

                }
                FirebaseBoolean.setMasaFonksiyonaGirisKontrol(false);
                if ( Facade.getNesne().getAdminMasaAdapter() != null) //eğer admin girişi yapılmiş ve ilk yüklemenin ardından 2. yükleme geliyorsa gelen data setleniyor.
                    Facade.getNesne().getAdminMasaAdapter().notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
