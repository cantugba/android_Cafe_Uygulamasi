package Islemler.HideShow;

import android.view.View;
import android.widget.LinearLayout;

public class LinearLayoutHideShow {

    public static void LinearLayoutGizle(LinearLayout linearLayout)
    {
        linearLayout.setVisibility(View.GONE);
    }

    public static void LinearLayoutGoster(LinearLayout linearLayout)
    {
        linearLayout.setVisibility(View.VISIBLE);
    }

}
