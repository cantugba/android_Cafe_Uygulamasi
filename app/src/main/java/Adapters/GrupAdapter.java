package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidcafeuygulama.CafeMenuGrup;
import com.example.androidcafeuygulama.R;

import FirebaseDataList.FirebaseDataList;
import de.hdodenhof.circleimageview.CircleImageView;

public class GrupAdapter extends BaseAdapter {
    CafeMenuGrup cafeMenuGrup;
    Context context;

    public GrupAdapter(Context context,CafeMenuGrup cafeMenuGrup){
        setContext(context);
        setCafeMenuGrup(cafeMenuGrup);

    }

    private CafeMenuGrup getCafeMenuGrup() { return cafeMenuGrup; }
    private void setCafeMenuGrup(CafeMenuGrup cafeMenuGrup){ this.cafeMenuGrup =cafeMenuGrup ;}

    private Context getContext(){ return context; }
    private void setContext(Context context){ this.context = context;}



    @Override
    public int getCount() {
        return FirebaseDataList.getMenuList().getMenuHashMapKey().size();
    }

    @Override
    public String  getItem(int position) {
        return FirebaseDataList.getMenuList().getMenuHashMapKey(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) { //R.layout.row_menu_grup, parent, false
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.row_menu_grup, viewGroup, false);
        Button button = layout.findViewById(R.id.ekleButton);
        final TextView nameTextView = layout.findViewById(R.id.nameTextView);
        TextView countTextView = layout.findViewById(R.id.countTextView);
        CircleImageView groupImg = layout.findViewById(R.id.groupImgId);

        nameTextView.setText(FirebaseDataList.getMenuList().getMenuHashMapKey(position));
        countTextView.setText(String.valueOf(FirebaseDataList.getMenuList().getUrunIsimList(position).size()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cafeMenuGrup.menuGir(nameTextView.getText().toString(), position);
            }
        });
        return layout;
    }
}
