import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo2 {

    public static void main(String[] args) {
        String paragraph = "I see something inside 077-1234567.\n\r But the issue is you don't 078-1234567 that in yourself.";
        String regExp = "\\d{3}-\\d{7}";
        Pattern pattern = Pattern.compile(regExp, Pattern.MULTILINE);
        System.out.println(Pattern.matches(regExp, "077-1234567"));
        System.out.println("077-1234567".matches(regExp));
        Matcher matcher = pattern.matcher(paragraph);
        while(matcher.find()) {
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            System.out.println(paragraph.substring(startIndex, endIndex));
        }
    }
}
