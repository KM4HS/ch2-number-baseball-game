package challenge;

import java.util.ArrayList;
import java.util.List;

public class GameRecordManager {
    private static final List<Integer> recordList = new ArrayList<>();

    public void addRecord(int result) {
        recordList.add(result);
    }

    public List<Integer> getRecord() {
        return recordList;
    }
}
