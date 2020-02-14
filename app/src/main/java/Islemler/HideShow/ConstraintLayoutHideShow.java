package Islemler.HideShow;

import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ConstraintLayoutHideShow {

    public static void ConstraintLayoutGizle(ConstraintLayout constraintLayout)
    {
        constraintLayout.setVisibility(View.GONE);
    }

    public static void ConstraintLayoutGoster(ConstraintLayout constraintLayout)
    {
        constraintLayout.setVisibility(View.VISIBLE);
    }
}
