package Kullanici;

import GetFirebaseData.FirebaseData;
import GetFirebaseData.GetMenuData;
import GetFirebaseData.GetMuzikData;

public class Kullanici {
    private String CafeId;

    public String getCafeId(){return CafeId;}

    public void setCafeId(String cafeId){CafeId = cafeId;}

    public void createList()
    {
        FirebaseData getData = new FirebaseData();

        getData.BringData(new GetMenuData(), this.getCafeId());
        getData.BringData(new GetMuzikData(), this.getCafeId()); // Kullanıcı nesnesi oluşturulduğu an müzikler firebaseden cekiliyor.
        // GetMucsData bir sınıf. Statik sınıf elemanlarını dolduruyor
    }
}
