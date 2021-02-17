package br.com.devx.trade.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    public static final String DD_MM_YYYY = "MM/dd/yyyy";

    public static LocalDate toLocalDate(String date, String format) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, formatter);
    }

    public static LocalDate toLocalDate(String date) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY);
        return LocalDate.parse(date, formatter);
    }
}
