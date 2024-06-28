package de.adesso.migsuite.utils.dateutils;

import java.time.LocalDate;

/**
 * Die Klasse DateUtils bietet Hilfsmethoden zur Umwandlung von Datumsangaben in verschiedene Date-Objekte von org.joda.time und java.time.
 * 
 * Diese Klasse enthält Methoden zur Erstellung von LocalDate-Objekten aus übergebenen Strings oder numerischen Werten sowie zur Formatierung und
 * Umwandlung von Datumsstrings in spezifizierte Formate.
 */
public class DateUtils {

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen Strings für Tag, Monat und Jahr.
     *
     * @param day Der Tag als String.
     * @param month Der Monat als String.
     * @param year Das Jahr als String.
     * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
     */

    public static org.joda.time.LocalDate elementsToJodaLocalDate(String day, String month, String year) {

        String dateString = day + "-" + month + "-" + year;
        org.joda.time.format.DateTimeFormatter formatter = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy");
        return org.joda.time.LocalDate.parse(dateString, formatter);
    }

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen Integern für Tag, Monat und Jahr.
     *
     * @param day Der Tag als Integer.
     * @param month Der Monat als Integer.
     * @param year Das Jahr als Integer.
     * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
     */
    public static org.joda.time.LocalDate elementsToJodaLocalDate(int day, int month, int year) {

        return new org.joda.time.LocalDate(year, month, day);
    }

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen long Werten für Tag, Monat und Jahr.
     *
     * @param day Der Tag als long.
     * @param month Der Monat als long.
     * @param year Das Jahr als long.
     * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
     */

    public static org.joda.time.LocalDate elementsToJodaLocalDate(long day, long month, long year) {

        return new org.joda.time.LocalDate((int) year, (int) month, (int) day);
    }

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus einem übergebenen Datum in einem String ohne Trennzeichen und einem Format.
     *
     * @param date Der Datumstring ohne Trennzeichen.
     * @param dateFormat Das Format des Datumstrings.
     * @return Ein org.joda.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static org.joda.time.LocalDate singleStringToJodaLocalDate(String date, String dateFormat) {

        org.joda.time.format.DateTimeFormatter dateFormatter = org.joda.time.format.DateTimeFormat.forPattern(dateFormat);
        return org.joda.time.LocalDate.parse(date, dateFormatter);
    }

    /**
     * Erstellt ein java.time.LocalDate Objekt aus übergebenen Strings für Tag, Monat und Jahr.
     *
     * @param day Tag als String.
     * @param month Monat als String.
     * @param year Jahr als String.
     * @return Ein java.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static java.time.LocalDate elementsToTimeLocalDate(String day, String month, String year) {

        String dateString = day + "-" + month + "-" + year;
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return java.time.LocalDate.parse(dateString, formatter);
    }

    /**
     * Erstellt ein java.time.LocalDate Objekt aus übergebenen int-Werten für Tag, Monat und Jahr.
     *
     * @param day Der Tag als int-Wert.
     * @param month Der Monat als int-Wert.
     * @param year Das Jahr als int-Wert.
     * @return Ein java.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static java.time.LocalDate elementsToTimeLocalDate(int day, int month, int year) {

        return java.time.LocalDate.of(year, month, day);
    }

    /**
     * Erstellt ein java.time.LocalDate Objekt aus übergebenen long-Werten für Tag, Monat und Jahr.
     *
     * @param day Der Tag als long-Wert.
     * @param month Der Monat als long-Wert.
     * @param year Das Jahr als long-Wert.
     * @return Ein java.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static java.time.LocalDate elementsToTimeLocalDate(long day, long month, long year) {

        return java.time.LocalDate.of((int) year, (int) month, (int) day);
    }

    /**
     * Erstellt ein java.time.LocalDate Objekt aus einem übergebenen Datum in einem String ohne Trennzeichen und einem Format.
     *
     * @param dateString Der Datumstring ohne Trennzeichen.
     * @param format Das Format des Datumstrings.
     * @return Ein java.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static java.time.LocalDate singleStringToJavaLocalDate(String date, String dateFormat) {

        java.time.format.DateTimeFormatter dateFormatter = java.time.format.DateTimeFormatter.ofPattern(dateFormat);
        return java.time.LocalDate.parse(date, dateFormatter);
    }


    /**
     * Konvertiert die angegebenen Tag-, Monat- und Jahr-Parameter in ein Joda-Time LocalDate-Objekt.
     * 
     * @param <T> der Typ der Eingabeparameter
     * @param day der Tag-Wert
     * @param month der Monat-Wert
     * @param year der Jahr-Wert
     * @param type der Typ, der verwendet wird, um eine Instanz von org.joda.time.LocalDate zu überprüfen
     * @return ein LocalDate-Objekt, das den angegebenen Tag, Monat und Jahr repräsentiert
     * @throws IllegalArgumentException wenn der type-Parameter keine Instanz von org.joda.time.LocalDate ist
     */
    public static <T> org.joda.time.LocalDate jodaDateFromParameter(T day, T month, T year, T type) {

        if (!(type instanceof org.joda.time.LocalDate)) {
            throw new IllegalArgumentException("Nicht unterstützter Typ. " + type + " ist nicht eine Instanz von org.joda.time.LocalDate.");
        }
        return new org.joda.time.LocalDate(gibTypWertZurueck(year), gibTypWertZurueck(month), gibTypWertZurueck(day));
    }


    /**
     * Konvertiert die angegebenen Tag-, Monat- und Jahr-Parameter in ein java.time.LocalDate-Objekt.
     * 
     * @param <T> der Typ der Eingabeparameter
     * @param day der Tag-Wert
     * @param month der Monat-Wert
     * @param year der Jahr-Wert
     * @param type der Typ, der verwendet wird, um eine Instanz von java.time.LocalDate zu überprüfen
     * @return ein LocalDate-Objekt, das den angegebenen Tag, Monat und Jahr repräsentiert
     * @throws IllegalArgumentException wenn der type-Parameter keine Instanz von java.time.LocalDate ist
     */
    public static <T> java.time.LocalDate javaTimeDateFromParameter(T day, T month, T year, T type) {

        if (!(type instanceof java.time.LocalDate)) {
            throw new IllegalArgumentException("Nicht unterstützter Typ. " + type + " ist nicht eine Instanz von java.time.LocalDate.");
        }
        return java.time.LocalDate.of(gibTypWertZurueck(year), gibTypWertZurueck(month), gibTypWertZurueck(day));
    }

    /**
     * Extrahiert einen Integer-Wert aus dem gegebenen Parameter.
     * 
     * Diese Methode unterstützt die Konvertierung von String, Long und Integer-Typen in einen Integer-Wert.
     * 
     * @param <T> der Typ des Eingabeparameters
     * @param wert der zu extrahierende Wert
     * @return der extrahierte Integer-Wert
     * @throws IllegalArgumentException wenn der Eingabeparameter nicht in einen Integer-Wert konvertiert werden kann
     */
    private static <T> int gibTypWertZurueck(T wert) {
        if (wert instanceof String) {
            if (((String) wert).matches("[0-9]+")) {
                return Integer.parseInt((String) wert);
            } else {
                throw new IllegalArgumentException("Nicht unterstützter Typ. " + wert + " kann nicht in Intenger umgewandelt werden");
            }
        } else if (wert instanceof Long) {
            return ((Long) wert).intValue();
        } else if (wert instanceof Integer) {
            return (Integer) wert;
        } else {
            throw new IllegalArgumentException("Nicht unterstützter Typ. " + wert + " kann nicht in Intenger umgewandelt werden");
        }
    }

    /**
     * Erstellt ein java.time.LocalDate Objekt aus übergebenen Werten für Tag, Monat und Jahr. Unterstützt String, int und long als Eingabetypen.
     *
     * @param day Tag als String, int oder long.
     * @param month Monat als String, int oder long.
     * @param year Jahr als String, int oder long.
     * @return Ein java.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static <T, U, V> LocalDate elementsToTimeLocalDate(T day, U month, V year) {
        int dayInt = convertToInt(day);
        int monthInt = convertToInt(month);
        int yearInt = convertToInt(year);

        return LocalDate.of(yearInt, monthInt, dayInt);
    }

    /**
     * Konvertiert einen beliebigen Typ (String, int oder long) in einen int-Wert.
     *
     * @param value Der Wert als String, int oder long.
     * @return Der konvertierte Wert als int.
     */
    private static <T> int convertToInt(T value) {
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        } else if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof Long) {
            return ((Long) value).intValue();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + value.getClass().getName());
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println(elementsToTimeLocalDate("20", "02", "2024"));

    }

}
