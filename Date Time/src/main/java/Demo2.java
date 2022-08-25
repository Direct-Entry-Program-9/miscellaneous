import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class Demo2 {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = getInstance();
        Date date2 = calendar.getTime();
        System.out.println(date2);

        int year = calendar.get(YEAR);
        int month = calendar.get(MONTH);
        int dayOfMonth = calendar.get(DAY_OF_MONTH);
        System.out.printf("Date: %04d-%s-%02d\n", year, getMonth(month), dayOfMonth);

        int hours = calendar.get(HOUR_OF_DAY);
        int minutes = calendar.get(MINUTE);
        int seconds = calendar.get(SECOND);
        System.out.printf("Time: %02d:%02d:%02d\n", hours, minutes, seconds);

        int dayOfWeek = calendar.get(DAY_OF_WEEK);
        System.out.printf("Today is: %s", getDayOfWeek(dayOfWeek));
    }

    private static String getDayOfWeek(int dayOfWeek) {
        return new String[]{"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"}[dayOfWeek - 1];
    }

    private static String getMonth(int month) {
        return new String[]{"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"}[month];
    }
}
