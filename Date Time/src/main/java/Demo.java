import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class Demo {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = getInstance();
        Date date2 = calendar.getTime();
        System.out.println(date2);

        int year = calendar.get(YEAR);
        int month = calendar.get(MONTH) ;
        int dayOfMonth = calendar.get(DAY_OF_MONTH);
        System.out.printf("Date: %04d-%s-%02d\n", year, getMonth(month), dayOfMonth);

        int hours = calendar.get(HOUR_OF_DAY);
        int minutes = calendar.get(MINUTE);
        int seconds = calendar.get(SECOND);
        System.out.printf("Time: %02d:%02d:%02d\n", hours, minutes, seconds);

        int dayOfWeek = calendar.get(DAY_OF_WEEK);
        System.out.printf("Today is: %s", getDayOfWeek(dayOfWeek));
    }

    private static String getDayOfWeek(int dayOfWeek){
        switch (dayOfWeek){
            case SUNDAY:
                return "Sunday";
            case MONDAY:
                return "Monday";
            case TUESDAY:
                return "Tuesday";
            case WEDNESDAY:
                return "Wednesday";
            case THURSDAY:
                return "Thursday";
            case FRIDAY:
                return "Friday";
            case SATURDAY:
                return "Saturday";
            default:
                throw new RuntimeException("Invalid day of week");
        }
    }

    private static String getMonth(int month) {
        switch (month) {
            case JANUARY:
                return "January";
            case FEBRUARY:
                return "February";
            case MARCH:
                return "March";
            case APRIL:
                return "April";
            case MAY:
                return "May";
            case JUNE:
                return "June";
            case JULY:
                return "July";
            case AUGUST:
                return "August";
            case SEPTEMBER:
                return "September";
            case NOVEMBER:
                return "November";
            case DECEMBER:
                return "December";
            default:
                throw new RuntimeException("Invalid month");
        }
    }
}
