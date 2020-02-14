package Islemler.HideShow;

import android.widget.Button;

public class ButtonsHideShow {
    public void buttonlariGizle(Button button[]){
        HideShow hide = new HideShow();
        for (Button a : button)
        {
            hide.hide(a);
        }

    }

    public void buttonlariGoster(Button button[]){
        HideShow show = new HideShow();

        for (Button a : button)
        {
            show.show(a);
        }

    }
}
