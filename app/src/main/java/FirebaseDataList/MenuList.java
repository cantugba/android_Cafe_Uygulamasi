package FirebaseDataList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuList {

    private List<String> MenuHashMapKey;
    private HashMap<String,HashMap<String,List<String>>> Menu;

    private static MenuList ListMenu;
    private  MenuList(){}
    //Singleton
    public static MenuList getListMenu(){

        if(ListMenu == null)
            ListMenu = new MenuList();
        return ListMenu;
    }

    public void setMenuHashMapKey(){ MenuHashMapKey = new ArrayList<String>();}
    public void  setMenuHashMapKey(String Key){MenuHashMapKey.add(Key);}
    public List<String> getMenuHashMapKey(){ return MenuHashMapKey;}
    public String getMenuHashMapKey(int Id){ return MenuHashMapKey.get(Id);}
    public void clearMenuHashMapKey(){getMenuHashMapKey().clear();}
    public void setMenu(){ Menu = new HashMap<String, HashMap<String, List<String>>>();}
    // Soğuk icecekler, Atıştırmalıklar vs ana başlıklar koyuluyor
    public void setMenuNewElement(String Key){
        Menu.put(Key,new HashMap<String, List<String>>());
    }

    //Urun isim,fiyat,key listesi tanımlama
    public void setUrunIsimList(String Key){
        Menu.get(Key).put("UrunIsim", new ArrayList<String>());
    }

    public void setUrunFiyatList(String Key){
        Menu.get(Key).put("UrunFiyat", new ArrayList<String>());
    }

    public void setUrunKeyList(String Key){
        Menu.get(Key).put("UrunKey", new ArrayList<String>());
    }

    //Urun isim,fiyat ve Key Listelerine Ekleme işlemleri

    public void setUrunIsimList(String Key, String Isim){
        Menu.get(Key).get("UrunIsim").add(Isim);
    }

    public void setUrunFiyatList(String Key, String Fiyat){
        Menu.get(Key).get("UrunFiyat").add(Fiyat);
    }

    public void setUrunKeyList(String Key, String UrunKey){
        Menu.get(Key).get("UrunKey").add(UrunKey);
    }

    public HashMap<String,HashMap<String,List<String>>> getMenu(){ return Menu;}

    public List<String> getUrunIsimList(int MapKey){
        return this.getMenu().get(this.getMenuHashMapKey(MapKey)).get("UrunIsim");
    }

    public String getUrunIsim(int MapKey, int IsimIndex){
        return this.getMenu().get(this.getMenuHashMapKey(MapKey)).get("UrunIsim").get(IsimIndex);
    }

    public String getUrunFiyat(int MapKey, int FiyatIndex){
        return this.getMenu().get(this.getMenuHashMapKey(MapKey)).get("UrunFiyat").get(FiyatIndex);
    }

    public String getUrunKey(int MapKey,int UrunKeyIndex){
        return  this.getMenu().get(this.getMenuHashMapKey(MapKey)).get("UrunKey").get(UrunKeyIndex);
    }

}
