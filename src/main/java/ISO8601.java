import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ISO8601 {
    public static Calendar toCalendar(String input) throws ParseException {
        Calendar calendar = GregorianCalendar.getInstance();
        String s = input.replace("Z", "+00:00");
        s = s.substring(0, 22) + s.substring(23);
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(s);
        calendar.setTime(date);
        return calendar;
    }

    public GregorianCalendar iso8601GregorianCalendar(String input) throws ParseException {
        long timeInMillis = toCalendar(input).getTimeInMillis();
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(timeInMillis);
        gregorianCalendar.setTimeZone(timeZone);
        return gregorianCalendar;
    }
}
