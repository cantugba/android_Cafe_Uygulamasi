package Islemler;

import android.content.Context;
import android.widget.Toast;

public class CreateToast {
    //Toast ile istenilen bir yazı veya hazırlanan bir View belli bir süre ekranda gözükür ve kaybolur.
    private static Context context;

    public static Context getContext(){
        return context;
    }

    public static void setContext(Context context){
        CreateToast.context=context;
    }

    public static void makeToast(String Message)
    {
        Toast.makeText(CreateToast.getContext(),Message,Toast.LENGTH_LONG).show();
    }
}
