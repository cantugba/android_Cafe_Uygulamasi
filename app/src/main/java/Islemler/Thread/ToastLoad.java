package Islemler.Thread;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;



import androidx.appcompat.app.AppCompatActivity;

import net.steamcrafted.loadtoast.LoadToast;

public class ToastLoad extends AppCompatActivity {

    private LoadToast lt; //
    //load toast kutuphanesi onay işareti veya çarpı işaretine (başarı ve başarısızlık) geçiş yaparak kullanıcıya geri bildirim verecek daha iyi bir tost sağlar.
    // Tostun ömrü tamamen sizin tarafınızdan kontrol edilir.
    private Context context;

    public ToastLoad(Context context, Display display)
    {
        this.setContext(context);
        this.defineLt(display);
    }

    protected Context getContext(){return  context;}
    protected void setContext(Context context) {
        this.context = context;
    }
    private void defineLt(Display display)  // LoadToast tanımlama
    {
        lt = new LoadToast(this.getContext());
        lt.setTranslationY(this.findHeight(display) / 2);
        lt.setTextColor(Color.WHITE).setBackgroundColor(Color.GRAY).setProgressColor(Color.WHITE);
    }

    protected void showLt(String text)
    {
        lt.setText(text);
        lt.show();
    }

    protected void hideLt(){lt.hide();}
    private int findHeight(Display display) // LoadToast'ın telefon ekranında tam ortada gözükmesi icin telefonun height' özelliği bulunuyor
    {
        Point size = new Point();
        display.getSize(size);
        int height = size.y;

        return  height;
    }
}
