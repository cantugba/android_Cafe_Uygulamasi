package FirebaseIslem.firebaseVeriEkleme;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Islemler.FirebaseBoolean;
import Kullanici.Admin;

public class AdminEkle {

    public static boolean fonksiyonGirisKontrol;
    public static boolean girisKontrol;

    public void adminEkle(String KullaniciAdi , String Sifre, final Activity activity){
        FirebaseBoolean.setLoginAddFonksiyonaGirisKontrol(true);
        FirebaseBoolean.setLoginAddIslemSonucKontrol(false);

        final FirebaseAuth auth = FirebaseAuth.getInstance(); //kkimlik doğrulama
        auth.createUserWithEmailAndPassword(KullaniciAdi, Sifre)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Admin.getObject().setCafeId(auth.getUid());
                            Admin.getObject().createList();
                            FirebaseBoolean.setLoginAddIslemSonucKontrol(true);
                        }

                        FirebaseBoolean.setLoginAddFonksiyonaGirisKontrol(false);
                    }
                });


    }

}
