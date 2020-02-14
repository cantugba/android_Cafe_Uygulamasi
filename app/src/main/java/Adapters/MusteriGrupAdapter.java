package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidcafeuygulama.R;

import FirebaseDataList.FirebaseDataList;

public class MusteriGrupAdapter extends BaseAdapter {


    private Context context;


    public MusteriGrupAdapter(Context context) {
        setContext(context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return FirebaseDataList.getMenuList().getMenuHashMapKey().size();
    }

    @Override
    public Object getItem(int position) {
        return FirebaseDataList.getMenuList().getMenuHashMapKey(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) { //R.layout.row_menu_group, parent, false
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.row_musteri_menu_grup, viewGroup, false);
        // View layout = LayoutInflater.from(getContext()).inflate(R.layout.row_customer_menu_group, viewGroup, false);
        TextView nameTextView = layout.findViewById(R.id.nameTextView);
        TextView countTextView = layout.findViewById(R.id.countTextView);

        nameTextView.setText(FirebaseDataList.getMenuList().getMenuHashMapKey(position));
        countTextView.setText(String.valueOf(FirebaseDataList.getMenuList().getUrunIsimList(position).size()));

        return layout;
    }
}
