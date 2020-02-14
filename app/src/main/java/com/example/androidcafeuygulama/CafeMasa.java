package com.example.androidcafeuygulama;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import Adapters.Facade;
import FirebaseDataList.FirebaseDataList;
import FirebaseIslem.firebaseVeriEkleme.MasaEkle;
import Kullanici.Admin;

public class CafeMasa extends AppCompatActivity {
    ListView tableList;
    EditText qrKod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_masa);
        tanimla();
        Facade.getNesne().masaAdapter(tableList, this);
        tableList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                qrKod.setText(Admin.getObject().getCafeId()+"ü"+ FirebaseDataList.getTableList().getFirebaseKey(i));
            }
        });
    }
    public void tanimla()
    {
        tableList = findViewById(R.id.tableListId);
        qrKod = findViewById(R.id.MasaQrKod);
    }
    public HashMap<String, String> MapTanimlama(String EklenecekVeri) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("CafeId", Admin.getObject().getCafeId());
        hashMap.put("EklenecekVeri", EklenecekVeri);
        return hashMap;
    }

    public void tableAdd(View view) {

        EditText masaAdi = findViewById(R.id.tableNameId);
        Admin.getObject().getProcess().firebaseEkle(new MasaEkle(), MapTanimlama( masaAdi.getText().toString() ));
        masaAdi.setText("");
    }
}
