import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;

public class Demo3 {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = getInstance();
        Date date2 = calendar.getTime();
        System.out.println(date2);

        int year = calendar.get(YEAR);
        int month = calendar.get(MONTH);
        int dayOfMonth = calendar.get(DAY_OF_MONTH);
        String strMonth = calendar.getDisplayName(MONTH, SHORT_FORMAT, Locale.ENGLISH);
        System.out.printf("Date: %04d-%s-%02d\n", year, strMonth, dayOfMonth);

        int hours = calendar.get(HOUR_OF_DAY);
        int minutes = calendar.get(MINUTE);
        int seconds = calendar.get(SECOND);
        System.out.printf("Time: %02d:%02d:%02d\n", hours, minutes, seconds);

        int dayOfWeek = calendar.get(DAY_OF_WEEK);
        String strDayOfWeek = calendar.getDisplayName(DAY_OF_WEEK, LONG_FORMAT, Locale.ENGLISH);
        System.out.printf("Today is: %s", strDayOfWeek);
    }
}
