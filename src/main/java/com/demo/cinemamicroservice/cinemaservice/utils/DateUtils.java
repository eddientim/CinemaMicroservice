package com.demo.cinemamicroservice.cinemaservice.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {

    private final static String DATE_FORMAT = "dd-MM-YYYY";
    private final static ZoneId ZONE_ID = ZoneId.of("Europe/London");

    /**
     * @param instant instant class method that formats an instant and then returns in the format requested om the
     *                format argument
     * @param format  instant to be converted
     * @return formatted dateTime
     */
    private static String formatDate(Instant instant, String format) {
        if (instant == null) {
            return null;
        }
        return DateTimeFormatter.ofPattern(format)
                .withLocale(Locale.UK)
                .withZone(ZONE_ID)
                .format(instant);
    }

    /**
     * Gets date element from instant element passed and returns it in 'dd-MM-YYYY'
     *
     * @param instant instant parameter
     * @return date element of the date/time parameter
     */
    public static String getDateFromDateTime(Instant instant) {
        return formatDate(instant, DATE_FORMAT);
    }

    /**
     * converts an Instant to a LocalDate for the ZONE_ID specified.
     *
     * @param instant instant to convert into LocalDate
     * @return localdate representation of converted instant
     */
    public static LocalDate convertedInstantToLocalDate(Instant instant) {
        if (instant == null) {
            return null;
        }
        return instant.atZone(ZONE_ID).toLocalDate();

    }
}
