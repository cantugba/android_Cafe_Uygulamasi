package Kullanici;

import FirebaseIslem.FirebaseIslem;
import GetFirebaseData.FirebaseData;
import GetFirebaseData.GetMasaData;

public class Kullanici1 extends Kullanici {
    //admin
    // adminde masalar listelenecek
    // müzik eklemeler olacak
    // müziklerde listelenecek

    private FirebaseIslem firebaseProcess;
    public FirebaseIslem getProcess() {
        if ( firebaseProcess == null )
            firebaseProcess = new FirebaseIslem();
        return firebaseProcess;
    }

    @Override
    public void createList() {
        super.createList();

        FirebaseData data = new FirebaseData();
        data.BringData(new GetMasaData(), this.getCafeId());
    }
}
