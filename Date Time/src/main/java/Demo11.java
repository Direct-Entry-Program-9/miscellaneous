import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Demo11 {

    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-01");
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);

        LocalTime localTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        System.out.println(localDate);
        System.out.println(localDateTime);

        System.out.println("-------------------");

        Date from = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(from);
    }
}
