package FirebaseIslem;

import java.util.HashMap;

import FirebaseIslem.firebaseVeriEkleme.IFirebaseDataEkle;
import FirebaseIslem.firebaseVeriSilme.IFirebaseDataSil;

public class FirebaseIslem {

    public void firebaseSil(IFirebaseDataSil DataSil, HashMap MapHash){
        DataSil.firebaseSil(MapHash);
    }

    public void firebaseEkle(IFirebaseDataEkle DataEkle,HashMap MapHash){
        DataEkle.firebaseEkle(MapHash);
    }
}
