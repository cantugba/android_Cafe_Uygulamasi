package FirebaseDataList;

public class MasaList extends MasaListParent {

    private static MasaList ListMasa;
    private MasaList(){}

    public static MasaList getMasaList(){
        if(ListMasa == null)
            ListMasa = new MasaList();
         return ListMasa;
    }




}
