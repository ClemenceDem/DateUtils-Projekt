package de.adesso.migsuite.utils.dateutils;


import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

//  Methoden zur Manipulation von Datumsangaben.
public class DateUtils {

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen Strings für Tag, Monat und Jahr.
     *
     * @param day Der Tag als String.
     * @param month Der Monat als String.
     * @param year Das Jahr als String.
     * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
     */

    public static LocalDate elementsToJodaLocalTime(String day, String month, String year) {

        String dateString = day + "-" + month + "-" + year;
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen Integern für Tag, Monat und Jahr.
     *
     * @param day Der Tag als Integer.
     * @param month Der Monat als Integer.
     * @param year Das Jahr als Integer.
     * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
     */
    public static LocalDate elementsToJodaLocalDate(int day, int month, int year) {

        return new LocalDate(year, month, day);
    }

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen long Werten für Tag, Monat und Jahr.
     *
     * @param day Der Tag als long.
     * @param month Der Monat als long.
     * @param year Das Jahr als long.
     * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
     */

    public static LocalDate elementsToJodaLocalDate(long day, long month, long year) {

        return new LocalDate((int) year, (int) month, (int) day);
    }


    public static LocalDate stringsToLocalDate(String day, String month, String year) {

        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }
        

    public static LocalDate intengersToLocalDate(int day, int month, int year) {

        return LocalDate.of(year, month, day);
    }

    public static LocalDate longsToLocalDate(long day, long month, long year) {

        return LocalDate.of((int) year, (int) month, (int) day);
    }

    public static String localDateToString(String day, String month, String year, String format) {

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(format);
        return elementsToJodaLocalTime(day, month, year).format(outputFormatter);
    }

    public static String localDateToIntengers(int day, int month, int year, String format) {

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(format);
        return elementsToJodaLocalDate(day, month, year).format(outputFormatter);
    }

    /*
     * public static String localDateToLongs(long day, long month, long year, String format) {
     * 
     * DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(format); return localDateFromLongs((int) day, (int) month, (int)
     * year).format(outputFormatter); }
     */

    public static LocalDate addDayToLocalDateNow(long day) {
        return LocalDate.now().plusDays(day);
    }

    /*
     * public static String addDay(LocalDate date, long day) {
     * 
     * String format = "dd.MM.yyyy"; return format.plusDays(day); }
     */
    public static void main(String[] args) throws Exception {

        System.out.println(elementsToJodaLocalDate(27, 01, 2001));
    }

    }

