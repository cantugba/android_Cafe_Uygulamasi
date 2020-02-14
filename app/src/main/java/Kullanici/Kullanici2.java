package Kullanici;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import FirebaseIslem.firebaseVeriEkleme.OyKullan;
import GetFirebaseData.FirebaseData;
import GetFirebaseData.GetHesapData;

public class Kullanici2 extends Kullanici {
    //Musteri

    private List<HashMap<String,String>> siparisler;
    private OyKullan OyVer;
    private String OyTarihi = ""; // oy kullanma işlemi bu özellik üzerinden yapılacak. Oturum acıldığında bu özellik setlenecek.
    private String MasaId;

    public Kullanici2(){
        this.setOyVer();
        this.siparisler = new ArrayList<HashMap<String,String>>();

    }

    public String getMasaId(){ return MasaId;}
    public void setMasaId(String masaId){
        MasaId = masaId;
    }

    public  String getOyTarihi(){return OyTarihi;}
    public void setOyTarihi(String OyTarihi){this.OyTarihi= OyTarihi;}

    private void setOyVer() {
        this.OyVer = new OyKullan();
    } // nesne set

    private OyKullan getOyVer() {
        return this.OyVer;
    } // nesne get

    public void oyVer(int Index) {
        this.getOyVer().oyKullan(Index);
    }

    public void siparis(String siparis, String adet, String fiyat)
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("siparis",siparis);
        hashMap.put("adet", adet);
        hashMap.put("fiyat", fiyat);
        this.setSiparisler(hashMap);
    }
    private void setSiparisler(HashMap hashMap)
    {
        this.siparisler.add(hashMap);
    }

    public List<HashMap<String, String>> getSiparisler(){ return siparisler;}
    public HashMap getSiparisler(int Id){ return siparisler.get(Id);}

    public void createList(){
        super.createList();
        FirebaseData firebaseData = new FirebaseData();
        firebaseData.BringData(new GetHesapData(), this.getCafeId());
    }


}
