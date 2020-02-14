package Islemler.HideShow;

import android.view.View;
import android.widget.RelativeLayout;

public class RelativeLayoutHideShow {

    public static void RelativeLayoutGizle(RelativeLayout relativeLayout)
    {
        relativeLayout.setVisibility(View.GONE);
    }

    public static void RelativeLayoutGoster(RelativeLayout relativeLayout)
    {
        relativeLayout.setVisibility(View.VISIBLE);
    }
}
