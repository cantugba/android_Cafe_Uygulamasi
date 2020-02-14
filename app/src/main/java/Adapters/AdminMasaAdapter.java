package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidcafeuygulama.R;

import FirebaseDataList.FirebaseDataList;
import Islemler.HideShow.ConstraintLayoutHideShow;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdminMasaAdapter extends BaseAdapter {
    Context context;

    public AdminMasaAdapter(Context context){this.context=context;}
    @Override
    public int getCount() {
        return FirebaseDataList.getTableList().getValueName().size();
    }

    @Override
    public String getItem(int position) {
        return FirebaseDataList.getTableList().getFirebaseKey(position);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View layout = LayoutInflater.from(this.context).inflate(R.layout.row_masa,viewGroup,false);
        TextView textView =layout.findViewById(R.id.listTextId);
        CircleImageView imageView= layout.findViewById(R.id.simge);
        textView.setText(FirebaseDataList.getTableList().getValueName(position));
        Glide.with(context).load(R.drawable.masa).into(imageView);

        return layout;
    }
}
