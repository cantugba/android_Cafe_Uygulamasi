package Giris;

import android.app.DownloadManager;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import Islemler.FirebaseBoolean;
import Kullanici.Musteri;

public class QRGiris implements IQRGiris {
    private  String IdMasa;
    private String CafeId;


    @Override
    public void giris(final String IdCafe, String MasaID) {
        FirebaseBoolean.setLoginAddFonksiyonaGirisKontrol(true);
        FirebaseBoolean.setLoginAddIslemSonucKontrol(false);
        this.IdMasa = MasaID;
        this.CafeId = IdCafe;

   Query query = FirebaseDatabase.getInstance().getReference(CafeId).child("masa");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot key : dataSnapshot.getChildren())

                    if(key.getKey().equals(IdMasa))
                    {
                        FirebaseBoolean.setLoginAddIslemSonucKontrol(true);
                        Musteri.getObjeck().setOyTarihi(key.child("oyTarihi").getValue().toString());
                        Musteri.getObjeck().setCafeId(CafeId);
                        Musteri.getObjeck().setMasaId(IdMasa);
                        Musteri.getObjeck().createList();
                    }
                FirebaseBoolean.setLoginAddFonksiyonaGirisKontrol(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
