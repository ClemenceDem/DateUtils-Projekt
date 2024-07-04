package de.adesso.migsuite.utils.dateutils;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Die Klasse DateUtils bietet Hilfsmethoden zur Umwandlung von Datumsangaben in verschiedene Date-Objekte von org.joda.time und java.time.
 * 
 * Diese Klasse enthält Methoden zur Erstellung von LocalDate-Objekten aus übergebenen Strings oder numerischen Werten sowie zur Formatierung und
 * Umwandlung von Datumsstrings in spezifizierte Formate.
 */
public class DateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);
    /*
    *//**
        * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen Strings für Tag, Monat und Jahr.
        *
        * @param day Der Tag als String.
        * @param month Der Monat als String.
        * @param year Das Jahr als String.
        * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
        * @throws IllegalArgumentException Wenn das Datumsformat ungültig ist/Wenn der Tag, Monat oder Jahr ungültige Werte haben.
        */
    /*
     * public static org.joda.time.LocalDate elementsToJodaLocalDate(String day, String month, String year) throws
     * org.joda.time.IllegalFieldValueException { try { // Kombiniere den Tag, Monat und Jahr in einen einzelnen String im Format "dd-MM-yyyy" String
     * dateString = day + "-" + month + "-" + year; org.joda.time.format.DateTimeFormatter formatter =
     * org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy"); return org.joda.time.LocalDate.parse(dateString, formatter); } catch
     * (IllegalArgumentException e) { LOGGER.info("Das Datumsformat ist ungültig: {}-{}-{}", day, month, year, e); throw new
     * IllegalArgumentException("Das Datumsformat ist ungültig: " + day + "-" + month + "-" + year, e); } }
     *//**
        * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen Integern für Tag, Monat und Jahr.
        *
        * @param day Der Tag als Integer.
        * @param month Der Monat als Integer.
        * @param year Das Jahr als Integer.
        * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
        */
    /*
     * public static org.joda.time.LocalDate elementsToJodaLocalDate(int day, int month, int year) {
     * 
     * return new org.joda.time.LocalDate(year, month, day); }
     * 
     *//**
        * Erstellt ein org.joda.time.LocalDate Objekt aus übergebenen long Werten für Tag, Monat und Jahr.
        *
        * @param day Der Tag als long.
        * @param month Der Monat als long.
        * @param year Das Jahr als long.
        * @return Ein org.joda.time.LocalDate Objekt, das das übergebene Datum repräsentiert.
        *//*
           * 
           * public static org.joda.time.LocalDate elementsToJodaLocalDate(long day, long month, long year) {
           * 
           * return new org.joda.time.LocalDate((int) year, (int) month, (int) day); }
           */
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
    /*
     * public static java.time.LocalDate elementsToTimeLocalDate(String day, String month, String year) {
     * 
     * try { String dateString = day + "-" + month + "-" + year; java.time.format.DateTimeFormatter formatter =
     * java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"); return java.time.LocalDate.parse(dateString, formatter);
     * 
     * } catch (DateTimeParseException e) { LOGGER.info("Ungültiges Datumsformat: {}-{}-{}", day, month, year, e); throw new
     * IllegalArgumentException("Ungültiges Datumsformat: " + day + "-" + month + "-" + year, e); } catch (IllegalArgumentException e) {
     * LOGGER.info("Ungültige Datumswerte: Tag={}, Monat={}, Jahr={}", day, month, year, e); throw new
     * IllegalArgumentException("Ungültige Datumswerte: Tag=" + day + ", Monat=" + month + ", Jahr=" + year, e); } }
     * 
     *//**
        * Erstellt ein java.time.LocalDate Objekt aus übergebenen int-Werten für Tag, Monat und Jahr.
        *
        * @param day Der Tag als int-Wert.
        * @param month Der Monat als int-Wert.
        * @param year Das Jahr als int-Wert.
        * @return Ein java.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
        */
    /*
     * public static java.time.LocalDate elementsToTimeLocalDate(int day, int month, int year) {
     * 
     * return java.time.LocalDate.of(year, month, day); }
     * 
     *//**
        * Erstellt ein java.time.LocalDate Objekt aus übergebenen long-Werten für Tag, Monat und Jahr.
        *
        * @param day Der Tag als long-Wert.
        * @param month Der Monat als long-Wert.
        * @param year Das Jahr als long-Wert.
        * @return Ein java.time.LocalDate Objekt, das das angegebene Datum repräsentiert.
        *//*
           * public static java.time.LocalDate elementsToTimeLocalDate(long day, long month, long year) {
           * 
           * return java.time.LocalDate.of((int) year, (int) month, (int) day); }
           */
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
        try {
        if (!(type instanceof org.joda.time.LocalDate)) {
            throw new IllegalArgumentException("Nicht unterstützter Typ. " + type + " ist nicht eine Instanz von org.joda.time.LocalDate.");
        }
            org.joda.time.LocalDate result = new org.joda.time.LocalDate(gibTypWertZurueck(year), gibTypWertZurueck(month), gibTypWertZurueck(day));
            LOGGER.info("Datum erfolgreich erstellt: {}", result);
            return result;
        } catch (IllegalArgumentException e) {
            LOGGER.error("Fehler beim Erstellen des Datums mit den Werten: Tag={}, Monat={}, Jahr={}, Typ={}", day, month, year, type, e);
            throw e;
        }

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
        try {
        if (!(type instanceof java.time.LocalDate)) {
            throw new IllegalArgumentException("Nicht unterstützter Typ. " + type + " ist nicht eine Instanz von java.time.LocalDate.");
        }
            java.time.LocalDate result = java.time.LocalDate.of(gibTypWertZurueck(year), gibTypWertZurueck(month), gibTypWertZurueck(day));
            LOGGER.info("Datum erfolgreich erstellt: {}", result);
            return result;
        } catch (IllegalArgumentException e) {
            LOGGER.error("Fehler beim Erstellen des Datums mit den Werten: Tag={}, Monat={}, Jahr={}, Typ={}", day, month, year, type, e);
            throw e;
        }
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
        try {
        if (wert instanceof String) {
            if (((String) wert).matches("[0-9]+")) {
                    int result = Integer.parseInt((String) wert);
                    LOGGER.info("Der String-Wert '{}' wurde erfolgreich in einen Integer-Wert konvertiert: {}", wert, result);
                    return result;
            } else {
                    throw new IllegalArgumentException("Nicht unterstützter Typ. " + wert + " kann nicht in Integer umgewandelt werden");
            }
        } else if (wert instanceof Long) {
                int result = ((Long) wert).intValue();
                LOGGER.info("Der Long-Wert '{}' wurde erfolgreich in einen Integer-Wert konvertiert: {}", wert, result);
                return result;
        } else if (wert instanceof Integer) {
                LOGGER.info("Der Integer-Wert '{}' wurde direkt zurückgegeben", wert);
                return (Integer) wert;
        } else {
                throw new IllegalArgumentException("Nicht unterstützter Typ. " + wert + " kann nicht in Integer umgewandelt werden");
        }
        } catch (IllegalArgumentException e) {
            LOGGER.error("Fehler beim Konvertieren des Wertes: {}", wert, e);
            throw e;
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
    public static <T> LocalDate elementsToTimeLocalDate(T day, T month, T year) {
        try {
            LOGGER.info("Datum erfolgreich erstellt: {}", LocalDate.of(gibTypWertZurueck(year), gibTypWertZurueck(month), gibTypWertZurueck(day)));
            return LocalDate.of(gibTypWertZurueck(year), gibTypWertZurueck(month), gibTypWertZurueck(day));
        } catch (IllegalArgumentException e) {
            LOGGER.error("Fehler beim Erstellen des Datums mit den Werten: Tag={}, Monat={}, Jahr={}", day, month, year, e);
            throw e;
    }
    }

    public static void main(String[] args) throws Exception {

        System.out.println(javaTimeDateFromParameter("25", "1", "2023", LocalDate.now()));

    }

}
