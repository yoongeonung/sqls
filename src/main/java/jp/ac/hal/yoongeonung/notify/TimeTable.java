package jp.ac.hal.yoongeonung.notify;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
 * "BC41\n"+ "ID : 939 0712 5637\n" + "PW : 895568"
 */

@Getter @Setter
public class TimeTable {
    private String subject;
    private String zoomID;
    private String zoomPW;

    public TimeTable(String subject, String zoomID, String zoomPW) {
        this.subject = subject;
        this.zoomID = zoomID;
        this.zoomPW = zoomPW;
    }

    public static List<String> newTuesday() {
        List<String> tuesday = new ArrayList<>();
        tuesday.add(new TimeTable("BC41\n", "ID : 939 0712 5637\n", "PW : 895568\n").toString());
        tuesday.add(new TimeTable("GP41\n", "ID : 933 0334 7265\n", "PW : 424426\n").toString());
        tuesday.add(new TimeTable("FX41\n", "ID : 933 0334 7265\n", "PW : 424426\n").toString());
        return tuesday;
    }

    public static List<String> newWednesday() {
        List<String> wednesday = new ArrayList<>();
        wednesday.add(new TimeTable("GP41\n", "ID : 925 2617 9740\n", "PW : 955098\n").toString());
        wednesday.add(new TimeTable("GP41\n", "ID : 925 2617 9740\n", "PW : 955098\n").toString());
        wednesday.add(new TimeTable("FE4S\n", "ID : 994 6681 4995\n", "PW : 668288\n").toString());
        return wednesday;
    }

    public static List<String> offlineDay() {
        List<String> offline = new ArrayList<>();
        offline.add("今日は登校日です。");
        return offline;
    }

    @Override
    public String toString() {
        return subject + zoomID + zoomPW;
    }
}
