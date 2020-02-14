package FirebaseDataList;

import java.util.ArrayList;
import java.util.List;

public class MuzikListParent extends ParentList {
    private List<Integer> oy;

    public void listClear(){
        super.listClear();
        oy.clear();
    }

    public int getOy(int Id){ return oy.get(Id);}

    public List<Integer> getOy(){ return oy;}

    public void setOy(){ oy =new ArrayList<Integer>();}

    public void setOy(int Oy){oy.add(Oy);}


}
