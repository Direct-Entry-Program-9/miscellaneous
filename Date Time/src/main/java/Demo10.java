import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Formatter;

public class Demo10 {

    public static void main(String[] args) throws InterruptedException {
        Instant t1 = Instant.now();
        System.out.println(t1.getEpochSecond());
        System.out.println(t1.getNano());

        Thread.sleep(1000);

        Instant t2 = Instant.now();
        Duration duration = Duration.between(t1, t2);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());

        System.out.println("-------------");

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println(formatter.format(currentTime));

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM);
        System.out.println(isoLocalDateTime.format(now));

        String dateTime = "2022-05-01 02:01 AM";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        LocalDateTime parse = LocalDateTime.parse(dateTime, formatter2);
        System.out.println(parse);
    }
}
