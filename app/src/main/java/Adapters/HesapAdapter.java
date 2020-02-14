package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidcafeuygulama.R;

import java.util.HashMap;

import Kullanici.Musteri;

public class HesapAdapter extends BaseAdapter {
    Context context;

    public HesapAdapter(Context context){
        setContext(context);
    }

    public Context getContext(){ return context ; }
    public void setContext(Context context){ this.context = context; }


    @Override
    public int getCount() {
        return Musteri.getObjeck().getSiparisler().size();
    }

    @Override
    public HashMap<String, String> getItem(int position) {
        return Musteri.getObjeck().getSiparisler(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.row_musteri_menu_grup,viewGroup,false);

        TextView nameTextView = layout.findViewById(R.id.nameTextView);
        TextView countTextView = layout.findViewById(R.id.countTextView);
        HashMap hashMap = Musteri.getObjeck().getSiparisler(position);

        nameTextView.setText(hashMap.get("siparis").toString() + " Fiyat= " + hashMap.get("fiyat").toString());
        countTextView.setText("Adet " + hashMap.get("adet").toString());

        return layout;
    }
}
