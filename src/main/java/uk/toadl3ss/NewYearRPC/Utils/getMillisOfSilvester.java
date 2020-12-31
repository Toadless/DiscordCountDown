package uk.toadl3ss.NewYearRPC.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getMillisOfSilvester {
    public static long getEndYearDate(int year)  {
        int adjustedYear = year + 1;
        String dateString = "/01/01 00:00:00";

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            Date silvesterThisYear = dateFormat.parse(adjustedYear + dateString);
            long unixFirstJanuary  = silvesterThisYear.getTime() / 1000L;
            return unixFirstJanuary;
        } catch (ParseException ignored) {
            return 0;
        }
    }
}
