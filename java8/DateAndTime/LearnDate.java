package java8.DateAndTime;

import org.apache.tomcat.jni.Local;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LearnDate {
    public static void main(String[] args) {
        // local date
//        LocalDate now = LocalDate.now();
//        System.out.println(now);
//        int year = now.getYear();
//        Month month = now.getMonth();
//        int dayOfMonth = now.getDayOfMonth();
//        System.out.println(year + " " + month + " " + dayOfMonth);

        // get a random date from today
//        LocalDate threeDaysBack = now.minusDays(3);
//        System.out.println(threeDaysBack);
//
//        if (now.isAfter(threeDaysBack)) System.out.println(true);

        // create a date
//        LocalDate myDate = LocalDate.of(2025, 3, 4);
//        System.out.println(myDate);

        // ---------------------------------------------------

        // local time
//        LocalTime now = LocalTime.now();
//        System.out.println(now);
//        System.out.println(now.getHour() + " " + now.getMinute() + " " + now.getSecond() + " " + now.getNano());
//
//        LocalTime customTime = LocalTime.of(14, 20, 10, 1000);
//        System.out.println(customTime);

        // parsing time
//        String timeInString = "15:35:30";
//        LocalTime parsedTime = LocalTime.parse(timeInString);
//        System.out.println(parsedTime);

        // calculate time
//        LocalTime minusHours = now.minusHours(2);
//        System.out.println(minusHours);
//        if (now.isAfter(minusHours)) System.out.println("Yes");
//        if (now.isBefore(parsedTime)) System.out.println("Yes");


        // ---------------------------------------------------

        // local date time
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime);

//        LocalDateTime parsed = LocalDateTime.parse("2025-11-01T12:20:02");
//        // format should be exactly same, otherwise we will get DateTimeParseException
//        System.out.println(parsed);


        // ---------------------------------------------------

        // zoned date time
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        System.out.println(zonedDateTime);

        // zoned date time - gives the time based on a zone. Total 24 zones available across the world.
        // UTC is like a global time, which is same across the whole world. For any point of time, UTC time will
        // be same for any of the zones.
//        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        // availableZoneIds.forEach(System.out::println);
        // if we print, we will get more than 24 zones. But primary are the 24 ones.

        // custom data in a specific zone
//        ZonedDateTime iceland = ZonedDateTime.of(2022, 11, 10, 13, 21,
//                20, 30, ZoneId.of("Iceland"));
//        System.out.println(iceland);

        // date diff of now vs other zone
//        ZonedDateTime kolkataNow = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
//        ZonedDateTime icelandNow = ZonedDateTime.now(ZoneId.of("Iceland"));
//        System.out.println(kolkataNow + " " + icelandNow);


        // ---------------------------------------------------

        // Instant
//        Instant now = Instant.now();
//        System.out.println(now);
//        long epochMilli = now.toEpochMilli();
//        System.out.println(epochMilli);


        // ---------------------------------------------------

        // Duration
//        Instant now = Instant.now();
//        List<Integer> arr1 = Arrays.asList(20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1);
//        List<List<Integer>> arr2 = Arrays.asList(Arrays.asList(2,3,4,1),
//                                Arrays.asList(8,7,6,5), Arrays.asList(12,11,10,9),
//                                Arrays.asList(16,15,14,13), Arrays.asList(20,19,18,17));
//         Collections.sort(arr1);
//        for (List<Integer> l: arr2) { Collections.sort(l); }
//        System.out.println(arr2);
//        Instant end = Instant.now();
//        Duration between = Duration.between(now, end);
//        System.out.println(between);


//        Duration d1 = Duration.between(now, end);
//        Duration d2 = Duration.of(1, ChronoUnit.MILLIS);
//        System.out.println(d1);
//        System.out.println(d2);
//        System.out.println(d1.compareTo(d2));
//        System.out.println(d2.compareTo(d1));
//        System.out.println(d1.compareTo(d1));


        // ---------------------------------------------------

        // Period
//        LocalDate now = LocalDate.now();
//        LocalDate then = LocalDate.of(1897, 3, 12);
//        Period period = Period.between(now, then);
//        System.out.println(period);


        // ---------------------------------------------------

        // date time formatter
        // all the classes we use, to parse a date within those classes we have to use a proper format.
        // such as localdatetime has this format:  2025-11-01T12:20:02.
        // for this, we can use date time formatter. So that we can send the date in our format, and it
        // still gets parsed.
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("02/11/1998");
        LocalDate localDate = LocalDate.now();
        String format1 = localDate.format(myFormat);
        System.out.println(format1);

        String date = "11/05/1880";  // the 05 - should be written with a 0 before 5, otherwise error will be thrown
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // the months, should be written as MM
        // LocalDate parse = LocalDate.parse(date);  // given date time exception because of the "date" format.
        LocalDate parsed = LocalDate.parse(date, format);
        System.out.println(parsed);

        String dateTimeString = "2020-03-28 13:35:30 IST";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        ZonedDateTime parseDateTime = ZonedDateTime.parse(dateTimeString, formatter);
        System.out.println(parseDateTime);
        // if we give IST in the dateTimeString, that might coz issue. So we will give offset, which means
        // how far our time zone is from UTC. Such as IST is "+05:30" from UTC. So instead of "IST" we will
        // give this "+05:30".
        // ALso for formatter to understand, we will use "XXX" instead of "z".
        // However, if we have written "Asia/Calcutta" instead of "IST", then with "z" only we can get our
        // parsed date directly.


        String dateTimeString2 = "2020-03-28 13:35:30+05:30";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
        ZonedDateTime parseDateTime2 = ZonedDateTime.parse(dateTimeString, formatter);
        System.out.println(parseDateTime2);

    }
}

/*
Why new time date, when we already have an time-date api?
1. The output we used to get from the existing time and date api used to be a mutable object, which means
    we can change them. Because of that, these date and time were not thread safe also.
2. Used to provide limited functionality, when it comes to zones or time difference.

Total of 8 classes were introduced in java 8 for the updated date time api:
1. local date  --  represents a date without timezone.
2. local time  --  represents a time without a date or time zone.
3. local date time  --  represents a date and time without a time zone.
4. zoned date time  --  represents a date and time with a time zone.
5. instant  --  represents an instantaneous point on the timeline, typically used for machine timestamps.
6. period  --  represents a duration of time (in milliseconds) between two times.
7. duration  --  represents a duration of time (in year, month, day) between two dates.
8. date time formatter  --  formats and parses date and time.
 */