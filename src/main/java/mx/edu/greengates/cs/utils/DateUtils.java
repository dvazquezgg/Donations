package mx.edu.greengates.cs.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtils {

    public static Date convertFromLocalDateToDate(LocalDate localDate) {
        // Convert LocalDate to Instant
        // An Instant represents a point in time in the UTC time zone
        // The time part is set to midnight (00:00:00)
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertFromDateToLocalDate(Date date) {
        // Convert Date to Instant
        // An Instant represents a point in time in the UTC time zone
        // The time part is set to midnight (00:00:00)
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertFromStringToDate(String date) {
        // Convert String to LocalDate
        return convertFromLocalDateToDate(LocalDate.parse(date));
    }

    public static Date convertFromStringToDate(String date, String format) throws DateTimeParseException {
        // Convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
        return convertFromLocalDateToDate(localDate);
    }

    public static String convertFromDateToString(Date date, String format) {
        // Convert Date to LocalDate
        LocalDate localDate = convertFromDateToLocalDate(date);
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }

    public static String convertFromDateToString(Date date) {
        // Convert Date to LocalDate
        String format = "yyyy-MM-dd";
        LocalDate localDate = convertFromDateToLocalDate(date);
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }
}
