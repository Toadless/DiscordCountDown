package uk.toadl3ss.NewYearRPC.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class getCurrentYear {
    private static final String pattern = "yyyy";
    public static String getCurrentYear() {
        final SimpleDateFormat patternFormat = new SimpleDateFormat(pattern);
        patternFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        final String date = patternFormat.format(new Date());
        System.out.println(date);
        return date;
    }
}
