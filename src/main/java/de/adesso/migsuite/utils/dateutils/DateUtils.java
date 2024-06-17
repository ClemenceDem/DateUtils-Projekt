package de.adesso.migsuite.utils.dateutils;

/**
 * Die Klasse DateUtils bietet Hilfsmethoden zur Umwandlung von Datumsangaben in verschiedene Date-Objekte von org.joda.time und java.time.
 * 
 * Diese Klasse enthält Methoden zur Erstellung von LocalDate-Objekten aus übergebenen Strings oder numerischen Werten sowie zur Formatierung und
 * Umwandlung von Datumsstrings in spezifizierte Formate.
 * 
 * Methoden: - elementsToJodaLocalTime: Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen Strings für Tag, Monat und Jahr. -
 * elementsToJodaLocalDate: Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen Integern oder long Werten für Tag, Monat und Jahr. -
 * elementsToTimeLocalTime: Erstellt ein java.time.LocalDate Objekt aus übergebenen Strings, Integern oder long Werten für Tag, Monat und Jahr. -
 * singleStringToJodaLocalTime: Erstellt ein org.joda.time.LocalDate Objekt aus einem übergebenen Datum in einem String ohne Trennzeichen und einem
 * Format. - singleStringToJavaLocalTime: Erstellt ein java.time.LocalDate Objekt aus einem übergebenen Datum in einem String ohne Trennzeichen und
 * einem Format.
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

    public static org.joda.time.LocalDate elementsToJodaLocalTime(String day, String month, String year) {

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
     * Erstellt ein java.time.LocalDate Objekt aus übergebenen Strings für Tag, Monat und Jahr.
     *
     * @param day Tag als String.
     * @param month Monat als String.
     * @param year Jahr als String.
     * @return Ein java.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static java.time.LocalDate elementsToTimeLocalTime(String day, String month, String year) {

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
    public static java.time.LocalDate elementsToTimeLocalTime(int day, int month, int year) {

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
    public static java.time.LocalDate elementsToTimeLocalTime(long day, long month, long year) {

        return java.time.LocalDate.of((int) year, (int) month, (int) day);
    }

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus einem übergebenen Datum in einem String ohne Trennzeichen und einem Format.
     *
     * @param date Der Datumstring ohne Trennzeichen.
     * @param dateFormat Das Format des Datumstrings.
     * @return Ein org.joda.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static org.joda.time.LocalDate singleStringToJodaLocalTime(String date, String dateFormat) {

        org.joda.time.format.DateTimeFormatter dateFormatter = org.joda.time.format.DateTimeFormat.forPattern(dateFormat);
        return org.joda.time.LocalDate.parse(date, dateFormatter);
    }

    /**
     * Erstellt ein org.joda.time.LocalDate Objekt aus einem übergebenen Datum in einem String ohne Trennzeichen und einem Format.
     *
     * @param dateString Der Datumstring ohne Trennzeichen.
     * @param format Das Format des Datumstrings.
     * @return Ein org.joda.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
     */
    public static java.time.LocalDate singleStringToJavaLocalTime(String date, String dateFormat) {

        java.time.format.DateTimeFormatter dateFormatter = java.time.format.DateTimeFormatter.ofPattern(dateFormat);
        return java.time.LocalDate.parse(date, dateFormatter);
    }

}
