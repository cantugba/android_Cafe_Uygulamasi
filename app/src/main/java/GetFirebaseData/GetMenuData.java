package GetFirebaseData;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

import Adapters.Facade;
import FirebaseDataList.FirebaseDataList;
import Islemler.FirebaseBoolean;

public class GetMenuData implements IGetFirebaseData {
    @Override
    public void firebaseData(String CafeId) {
        FirebaseDataList.getMenuList().setMenu(); //  menu hasmap listesi, new ile bellekte yer ayrımı yapılıyor
        FirebaseDataList.getMenuList().setMenuHashMapKey(); //menu hasmap listesi, new ile bellekte yer ayrımı yapılıyor

        FirebaseBoolean.setMenuFonksiyonaGirisKontrol(true);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(CafeId).child("Menu");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseDataList.getMenuList().clearMenuHashMapKey();
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext())
                {
                    DataSnapshot key = items.next();
                    FirebaseDataList.getMenuList().setMenuHashMapKey(key.getKey()); // Hasmap key listesine, key eklemesi
                    FirebaseDataList.getMenuList().setMenuNewElement(key.getKey()); // Hasmap listesinde örnğin soğuk icecekler tanımlanıyor
                    FirebaseDataList.getMenuList().setUrunFiyatList(key.getKey()); // Hasmap listesinde örneğin soğuk icecekler icin, fiyat listesi tanımlanıyor(new)
                    FirebaseDataList.getMenuList().setUrunIsimList(key.getKey());// Hashmap listesinde örneğin soğuk icecekler icin, urun isim listesi tanımlanıyor(new)
                    FirebaseDataList.getMenuList().setUrunKeyList(key.getKey());

                    for (DataSnapshot key2 : key.getChildren())
                    {
                        FirebaseDataList.getMenuList().setUrunIsimList(key.getKey(), key2.child("Urun").getValue().toString());
                        try{
                            FirebaseDataList.getMenuList().setUrunFiyatList(key.getKey(), key2.child("Fiyat").getValue().toString());
                        }catch (Exception e){}

                        FirebaseDataList.getMenuList().setUrunKeyList(key.getKey(),key2.getKey());
                    }

                }

                FirebaseBoolean.setMenuFonksiyonaGirisKontrol(false);
                if( Facade.getNesne().getGrupAdapter() != null )
                {
                    Facade.getNesne().getGrupAdapter().notifyDataSetChanged();
                }
                if(Facade.getNesne().getAdminMenuAdapter() != null)
                {
                    Facade.getNesne().getAdminMenuAdapter().notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
