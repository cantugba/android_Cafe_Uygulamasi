package Islemler;

import java.util.HashMap;

import Kullanici.Musteri;

public class HashMapHazirla {

    HashMap<String,String> hashMap;

    public HashMapHazirla(){
        hashMap = new HashMap<String, String>();
    }
 //anahtar değer 2lileri
    public HashMap oyverHashMap( String CafeId, String MasaId,String oyZamani){
        hashMap.put("CafeId",CafeId);
        hashMap.put("MasaId",MasaId);
        hashMap.put("oyZamani",oyZamani);
        return hashMap;

    }

    public HashMap SiparisHashMap(String siparisArray[] , String adet){
        hashMap.put("CafeId", Musteri.getObjeck().getCafeId());
        hashMap.put("adet",adet);
        hashMap.put("siparis",siparisArray[0]);
        hashMap.put("fiyat", siparisArray[1]);
        hashMap.put("masaId",Musteri.getObjeck().getMasaId());

        return hashMap;
    }


}
