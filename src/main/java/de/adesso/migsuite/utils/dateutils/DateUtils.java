package de.adesso.migsuite.utils.dateutils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static LocalDate localDateFromStrings(String day, String month, String year) {

        String strdate = day + "-" + month + "-" + year;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(strdate, formatter);
    }

    public static LocalDate localDateFromIntegers(int day, int month, int year) {

        return LocalDate.of(year, month, day);
    }

    public static LocalDate localDateFromLongs(long day, long month, long year) {

        return LocalDate.of((int) year, (int) month, (int) day);
    }

    public static LocalDate stringsToLocalDate(String day, String month, String year) {

        int dayValue = Integer.parseInt(day);
        int monthValue = Integer.parseInt(month);
        int yearValue = Integer.parseInt(year);
        return LocalDate.of(yearValue, monthValue, dayValue);
    }

    public static LocalDate intengersToLocalDate(int day, int month, int year) {

        return LocalDate.of(year, month, day);
    }

    public static LocalDate longsToLocalDate(long day, long month, long year) {

        return LocalDate.of((int) year, (int) month, (int) day);
    }

    public static String localDateToString(String day, String month, String year, String format) {

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(format);
        return localDateFromStrings(day, month, year).format(outputFormatter);
    }

    public static String localDateToIntengers(int day, int month, int year, String format) {

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(format);
        return localDateFromIntegers(day, month, year).format(outputFormatter);
    }

    public static String localDateToLongs(long day, long month, long year, String format) {

            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(format);
            return localDateFromLongs((int) day, (int) month, (int) year).format(outputFormatter);
        }

    public static void main(String[] args) throws Exception {
        System.out.println(localDateToString("06", "06", "2024", "dd-MM-yyyy"));
    }

    }

