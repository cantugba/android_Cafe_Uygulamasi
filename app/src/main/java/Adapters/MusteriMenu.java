package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidcafeuygulama.Musteri;
import com.example.androidcafeuygulama.R;

import java.net.ConnectException;

import FirebaseDataList.FirebaseDataList;
import de.hdodenhof.circleimageview.CircleImageView;

public class MusteriMenu extends BaseAdapter {
    private int key;
    private Context context;
    private Musteri musteri;

    public MusteriMenu(Context context,int key,Musteri musteri){
        this.setContext(context);
        this.setKey(key);
        this.setMusteri(musteri);
    }

    public Musteri getMusteri(){ return musteri; }
    public void setMusteri(Musteri musteri){ this.musteri = musteri; }

    public int getKey(){ return key; }
    public void setKey(int key){ this.key = key; }

    public Context getContext(){ return context; }
    public void setContext(Context context){ this.context = context;}


    @Override
    public int getCount() {
        return FirebaseDataList.getMenuList().getUrunIsimList(this.getKey()).size();
    }

    @Override
    public String getItem(int position) {
        return FirebaseDataList.getMenuList().getUrunIsim(this.getKey(),position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       View layout = LayoutInflater.from(this.context).inflate(R.layout.row_musteri_menu, viewGroup,false);
        final TextView nameTextView = layout.findViewById(R.id.nameTextView);
        final TextView countTextView = layout.findViewById(R.id.costTextView);
        CircleImageView groupImg = layout.findViewById(R.id.groupImgId);
        Button button = layout.findViewById(R.id.SiparisVerButton);
        nameTextView.setText(FirebaseDataList.getMenuList().getUrunIsim(this.getKey(), position));
        countTextView.setText("Fiyat= " + FirebaseDataList.getMenuList().getUrunFiyat(this.getKey(), position));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMusteri().siparisVer(nameTextView.getText().toString(), countTextView.getText().toString());
            }
        });
        return layout;
    }
}
