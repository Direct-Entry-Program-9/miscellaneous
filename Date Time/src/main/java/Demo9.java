import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Demo9 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2005, 5, 1);
        System.out.println(date);

        LocalDate today = LocalDate.now();
        System.out.println(today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format = formatter.format(date);
        System.out.println(format);
        System.out.println(formatter.format(today));

        LocalDate localDate = today.plusDays(10);
        System.out.println(localDate);

        LocalDate d1 = LocalDate.of(2022, 6, 28);
        LocalDate d2 = LocalDate.of(2022, 8, 2);
        Period period = Period.between(d1, d2);
        System.out.println("Years=" + period.getYears());
        System.out.println("Months=" + period.getMonths());
        System.out.println("Days=" + period.getDays());

        long days = ChronoUnit.DAYS.between(d1, d2);
        System.out.println("Days=" + days);

        String userDate = "2022|05|01";
        LocalDate parse = LocalDate.parse(userDate, DateTimeFormatter.ofPattern("yyyy|MM|dd"));
        System.out.println(parse);
    }
}
