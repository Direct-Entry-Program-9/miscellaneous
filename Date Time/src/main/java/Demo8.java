import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Demo8 {

    public static void main(String[] args) throws ParseException {

        /* This is via new Date Time API */
        LocalDate date1 = LocalDate.of(2021, 7, 1);
        LocalDate date2 = LocalDate.of(2022, 7, 21);
        Period period = Period.between(date1, date2);
        System.out.printf("New API: Years=%d, Months=%d, Days=%d \n", period.getYears(), period.getMonths(), period.getDays());

        /* Via Legacy */
        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-01");
        Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-01");

        int years = 0, months = 0, days = 0, field = Calendar.YEAR;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d1);

        while(!calendar.getTime().equals(d2)){
            calendar.add(field, 1);
            if (field == Calendar.YEAR) years++;
            if (field == Calendar.MONTH) months++;
            if (field == Calendar.DAY_OF_MONTH) days++;
            if (calendar.getTime().after(d2)){
                calendar.add(field, -1);
                if (field == Calendar.YEAR) years--;
                if (field == Calendar.MONTH) {
                    months--;
                    field = Calendar.DAY_OF_MONTH;
                }else{
                    field = Calendar.MONTH;
                }
            }
        }

//        outer_loop:
//        while(true){
//            calendar.add(Calendar.YEAR, 1);
//            years++;
//
//            if (calendar.getTime().equals(d2)){
//                break;
//            }else if (calendar.getTime().after(d2)){
//                calendar.add(Calendar.YEAR, -1);
//                years--;
//
//                while(true){
//                    calendar.add(Calendar.MONTH, 1);
//                    months++;
//
//                    if (calendar.getTime().equals(d2)){
//                        break outer_loop;
//                    }else if(calendar.getTime().after(d2)){
//                        calendar.add(Calendar.MONTH, -1);
//                        months--;
//
//                        while (!calendar.getTime().equals(d2)){
//                            calendar.add(Calendar.DAY_OF_MONTH, 1);
//                            days++;
//                        }
//                        break outer_loop;
//                    }
//                }
//            }
//        }

        System.out.printf("Old API: Years=%d, Months=%d, Days=%d \n", years, months, days);
    }
}
