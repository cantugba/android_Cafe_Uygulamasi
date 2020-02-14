package FirebaseDataList;

public class MuzikList extends MuzikListParent{
    private static MuzikList ListMuzik;
    private MuzikList(){}

    public static MuzikList getMuzikList(){

        if(ListMuzik == null)
            ListMuzik = new MuzikList();
        return ListMuzik;
    }

}
