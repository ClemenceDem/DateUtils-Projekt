package de.adesso.migsuite.utils.dateutils;

import java.time.DateTimeException;
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
        int dayValue = gibTypWertZurueck(day);
        int monthValue = gibTypWertZurueck(month);
        int yearValue = gibTypWertZurueck(year);
        org.joda.time.LocalDate result = null;
        try {
            if (!(type instanceof org.joda.time.LocalDate)) {
                LOGGER.error("Ungueltiger Typ.");
                throw new IllegalArgumentException("Nicht unterstuetzter Typ " + type + " ist nicht eine Instanz von joda.time.LocalDate.");
            }
            result = new org.joda.time.LocalDate(yearValue, monthValue, dayValue);
            LOGGER.info("Datum erfolgreich erstellt: {}", result);

        } catch (IllegalArgumentException e) {
            // LOGGER.error("Fehler beim Erstellen des Datums mit den Werten: Tag={}, Monat={}, Jahr={}, Typ={}", day, month, year, type, e);
            //throw new IllegalArgumentException("Nicht unterstuetzter Typ" + type + " ist nicht eine Instanz von joda.time.LocalDate.");
            // LOGGER.error(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
        return result;

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
        int dayValue = gibTypWertZurueck(day);
        int monthValue = gibTypWertZurueck(month);
        int yearValue = gibTypWertZurueck(year);
        java.time.LocalDate result = null;
        try {
            if (!(type instanceof java.time.LocalDate)) {
                LOGGER.error("Ungueltiger Typ.");
                throw new IllegalArgumentException("Nicht unterstuetzter Typ " + type + " ist nicht eine Instanz von java.time.LocalDate.");
            }
            result = java.time.LocalDate.of(yearValue, monthValue, dayValue);
            LOGGER.info("Datum erfolgreich erstellt: {}", result);
        } catch (IllegalArgumentException e) {
            // LOGGER.error("Fehler beim Erstellen des Datums mit den Werten: Tag={}, Monat={}, Jahr={}, Typ={}", day, month, year, type, e);
            throw new IllegalArgumentException(e.getMessage());
        }
        return result;
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
    public static <T> int gibTypWertZurueck(T wert) {
        int result = 0;
        if (wert == null) {
            LOGGER.warn("ungültiger Parameter Typ. 0 wird zurückgeliefert");
            throw new IllegalArgumentException("Input cannot be null");
        } else {

        if (wert instanceof String) {
            if (((String) wert).isEmpty()) {
                throw new IllegalArgumentException("Input cannot be null or empty");
            }

            try {
                result = Integer.parseInt((String) wert);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Input is not a valid integer");
            }
        } else if (wert instanceof Long) {
            Long longValue = (Long) wert;
            result = longValue.intValue();
            LOGGER.info("Der Long-Wert '{}' wurde erfolgreich in einen Integer-Wert konvertiert: {}", wert, result);

        } else if (wert instanceof Integer) {
            result = (Integer) wert;
            LOGGER.info("Der Integer-Wert '{}' wurde direkt zurückgegeben", wert);
            }
        }
        return result;
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
        int dayValue = gibTypWertZurueck(day);
        int monthValue = gibTypWertZurueck(month);
        int yearValue = gibTypWertZurueck(year);
        try {
            LOGGER.info("Datum erfolgreich erstellt: {}", LocalDate.of(yearValue, monthValue, dayValue));

        } catch (DateTimeException e) {
            LOGGER.error("Datum könnte nicht erstellt werden.");
            throw new DateTimeException("Fehler beim Erstellen des Datums.");
        }
        return LocalDate.of(yearValue, monthValue, dayValue);
    }

    

}
