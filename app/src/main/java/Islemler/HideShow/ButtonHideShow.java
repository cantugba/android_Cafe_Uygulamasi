package Islemler.HideShow;

import android.view.View;
import android.widget.Button;

public class ButtonHideShow {

    public static void ButtonGizle(Button button)
    {
        button.setVisibility(View.GONE);
    }
    public static void ButtonGoster(Button button)
    {
        button.setVisibility(View.VISIBLE);
    }

}
