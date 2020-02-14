package GetFirebaseData;

public class FirebaseData {
    public void BringData(IGetFirebaseData Data, String CafeID)
    {
        Data.firebaseData(CafeID);
    }
}
