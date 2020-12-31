package uk.toadl3ss.NewYearRPC.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getCurrentYear {
    private static final String pattern = "Y";
    private static final SimpleDateFormat patternFormat = new SimpleDateFormat(pattern);
    public static final String date = patternFormat.format(new Date());
    public static String getCurrentYear() {
        return date;
    }
}
