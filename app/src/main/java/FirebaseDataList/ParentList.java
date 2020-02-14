package FirebaseDataList;

import java.util.ArrayList;
import java.util.List;

public class ParentList extends SoyutList {
    @Override
    public void listClear() {

        this.FirebaseKey.clear();
        this.ValueName.clear();
    }

    @Override
    public List<String> getValueName() {
        return this.ValueName;
    }

    @Override
    public String getValueName(int Id) {
        return this.ValueName.get(Id);
    }

    @Override
    public void setValueName(String Name) {
        this.ValueName.add(Name);
    }

    @Override
    public void setValueName() {
        this.ValueName = new ArrayList<String>();
    }

    @Override
    public List<String> getFirebaseKey() {
        return this.FirebaseKey;
    }

    @Override
    public String getFirebaseKey(int Id) {
        return this.FirebaseKey.get(Id);
    }

    @Override
    public void setFirebaseKey(String Key) {
      this.FirebaseKey.add(Key);
    }

    @Override
    public void setFirebaseKey() {
        this.FirebaseKey = new ArrayList<String>();
    }
}
