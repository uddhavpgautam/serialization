import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

public class LastFriday {

    public static void main(String[] args) {

        String cd1T1 = "2023-02-21T10:00:00Z";
        String cd1T2 = "2023-05-30T10:00:00Z";
        String cd1T3 = "2023-07-10T10:00:00Z";
        String cd1T4 = "2023-09-05T10:00:00Z";

        String helloWorld;
        try {
            Calendar calT1 = ISO8601.toCalendar(cd1T1);
            Calendar calT2 = ISO8601.toCalendar(cd1T2);
            Calendar calT3 = ISO8601.toCalendar(cd1T3);
            Calendar calT4 = ISO8601.toCalendar(cd1T4);

            LocalDate localDate1 = LocalDateTime.ofInstant(calT1.toInstant(), calT1.getTimeZone().toZoneId()).toLocalDate();
            LocalDate localDate2 = LocalDateTime.ofInstant(calT2.toInstant(), calT2.getTimeZone().toZoneId()).toLocalDate();
            LocalDate localDate3 = LocalDateTime.ofInstant(calT3.toInstant(), calT3.getTimeZone().toZoneId()).toLocalDate();
            LocalDate localDate4 = LocalDateTime.ofInstant(calT4.toInstant(), calT4.getTimeZone().toZoneId()).toLocalDate();

            int cycles = 3;
            for (int i = 0; i < cycles; i++) {
                localDate1 = localDate1.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
                localDate2 = localDate2.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
                localDate3 = localDate3.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
                localDate4 = localDate4.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
                helloWorld = "Hello World";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        helloWorld = "Hello World";
    }


}
