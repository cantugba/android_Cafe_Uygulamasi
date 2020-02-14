package Adapters;

import android.content.Context;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.androidcafeuygulama.CafeMenuGrup;
import com.example.androidcafeuygulama.Musteri;

public class Facade {
    private GrupAdapter grupAdapter;
    private MuzikAdapter muzikAdapter;
    private AdminMasaAdapter masaAdapter;
    private AdminMenuAdapter adminMenuAdapter;

    private static Facade facade;
    private Facade(){}

    public static Facade getNesne(){

        if (facade == null )
            facade = new Facade();
        return facade;

    }

    public GrupAdapter getGrupAdapter(){ return grupAdapter; }
    public MuzikAdapter getMuzikAdapter(){ return muzikAdapter; }
    public AdminMasaAdapter getAdminMasaAdapter(){ return masaAdapter; }
    public AdminMenuAdapter getAdminMenuAdapter(){ return adminMenuAdapter; }

    public void muzikAdapter(ListView listView, Context context)
    {
        muzikAdapter = new MuzikAdapter(context);
        listView.setAdapter(muzikAdapter);
    }

    public void grupAdapter(ListView listView , Context context, CafeMenuGrup cafeMenuGrup)
    {
        grupAdapter =new GrupAdapter(context,cafeMenuGrup);
        listView.setAdapter(grupAdapter);
    }

    public void masaAdapter(ListView listView, Context context)
    {
        masaAdapter = new AdminMasaAdapter(context);
        listView.setAdapter(masaAdapter);
    }

    public void adminMenu(ListView listView,Context context,int key)
    {
        adminMenuAdapter = new AdminMenuAdapter(context,key);
        listView.setAdapter(adminMenuAdapter);
    }

    public void musteriGrupAdapter(Spinner spinner, Context context)
    {
        MusteriGrupAdapter musteriGrupAdapter = new MusteriGrupAdapter(context);
        spinner.setAdapter(musteriGrupAdapter);
    }
    public void musteriMenuAdapter(ListView listView, Context context, int key, Musteri musteri)
    {
        MusteriMenu musteriMenu = new MusteriMenu(context, key, musteri);
        listView.setAdapter(musteriMenu);
    }
    public void hesapAdapter(ListView listView, Context context)
    {
        HesapAdapter hesapAdapter = new HesapAdapter(context);
        listView.setAdapter(hesapAdapter);

    }

}
