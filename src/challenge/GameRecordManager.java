package challenge;

import java.util.ArrayList;
import java.util.List;

// 시도 횟수 기록을 위한 클래스
public class GameRecordManager {
    private static final List<Integer> recordList = new ArrayList<>();

    /**
     * 기록을 추가함
     *
     * @param result : 게임 종료 시점의 시도 횟수를 받음
     */
    public void addRecord(int result) {
        recordList.add(result);
    }

    /**
     * 시도 횟수 기록을 반환함
     *
     * @return : 시도 횟수 리스트
     */
    public List<Integer> getRecord() {
        return recordList;
    }
}
