package com.example.androidcafeuygulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.steamcrafted.loadtoast.LoadToast;

import Islemler.CreateToast;
import Islemler.Thread.AdminDataThread;

public class CafeYonetimi extends AppCompatActivity {
    private Button backButton;
    private Button menuButton;
    private Button orderButton;
    private Button tableButton;
    private Button musicButton;
    LoadToast lt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_yonetimi);


        CreateToast.setContext(this);
        this.defineElement();
        AdminDataThread adminDataThread = new AdminDataThread(CafeYonetimi.this, getWindowManager().getDefaultDisplay());
        adminDataThread.firebaseThread(butonDizisi());


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeYonetimi.this, CafeGiris.class);
                startActivity(i);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeYonetimi.this, CafeMenuTercih.class);
                startActivity(i);
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeYonetimi.this, CafeMasa.class);
                startActivity(i);
            }
        });

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeYonetimi.this, CafeMuzik.class);
                startActivity(i);

            }
        });

    }

    public void defineElement() {
        backButton = (Button) findViewById(R.id.backButton);
        menuButton = (Button) findViewById(R.id.menuButton);
        orderButton = (Button) findViewById(R.id.orderButton);
        tableButton = (Button) findViewById(R.id.tableButton);
        musicButton = (Button) findViewById(R.id.musicButton);
    }
    public Button[] butonDizisi()
    {
        Button [] button = new Button[5];
        button[0] = backButton;
        button[1] = menuButton;
        button[2] = orderButton;
        button[3] = tableButton;
        button[4] = musicButton;
        return button;
    }
}
