package Islemler.HideShow;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class HideShow {
    public void hide(Button button){ButtonHideShow.ButtonGizle(button);}
    public void hide(LinearLayout linearLayout){LinearLayoutHideShow.LinearLayoutGizle(linearLayout);}
    public void hide(ConstraintLayout constraintLayout){ConstraintLayoutHideShow.ConstraintLayoutGizle(constraintLayout);}
    public void hide(RelativeLayout relativeLayout){RelativeLayoutHideShow.RelativeLayoutGizle(relativeLayout);}

    public void show(Button button){ButtonHideShow.ButtonGoster(button);}
    public void show(LinearLayout linearLayout){LinearLayoutHideShow.LinearLayoutGoster(linearLayout);}
    public void show(ConstraintLayout constraintLayout){ConstraintLayoutHideShow.ConstraintLayoutGoster(constraintLayout);}

    public void show(RelativeLayout relativeLayout){RelativeLayoutHideShow.RelativeLayoutGoster(relativeLayout);}




}
