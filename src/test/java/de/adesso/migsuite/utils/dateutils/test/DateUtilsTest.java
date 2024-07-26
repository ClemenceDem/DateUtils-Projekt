package de.adesso.migsuite.utils.dateutils.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import de.adesso.migsuite.utils.dateutils.DateUtils;

public class DateUtilsTest {

    /*
     * @Test public void testElementsToJodaLocalDate1() throws ParseException { org.joda.time.LocalDate expectedDate = new
     * org.joda.time.LocalDate(2001, 01, 27); assertEquals(DateUtils.elementsToJodaLocalDate("27", "01", "2001"), expectedDate); }
     * 
     * @Test public void testElementsToJodaLocalDate2() throws ParseException { org.joda.time.LocalDate expectedDate = new
     * org.joda.time.LocalDate(2001, 01, 27); assertEquals(DateUtils.elementsToJodaLocalDate(27, 01, 2001), expectedDate); }
     * 
     * @Test public void testElementsToJodaLocalDate() throws ParseException { org.joda.time.LocalDate expectedDate = new
     * org.joda.time.LocalDate(2001, 01, 27); assertEquals(DateUtils.elementsToJodaLocalDate(27l, 01l, 2001l), expectedDate); }
     */

    private DateUtils dateUtils;

    @BeforeEach
    public void setUp() {
        dateUtils = new DateUtils();
    }

    @AfterEach
    public void tearDown() {
        // Hier können Sie Aufräumarbeiten durchführen
        System.out.println("Test completed. Cleaning up...");
        // Beispiel: Zurücksetzen von Zuständen oder Freigeben von Ressourcen
    }

    @Test
    public void testElementsToTimeLocalDate1() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        LocalDate expectedDate2 = LocalDate.of(2028, 12, 06);
        assertEquals(dateUtils.elementsToTimeLocalDate(06L, 05L, 2024L), expectedDate);
        assertEquals(dateUtils.elementsToTimeLocalDate("06", "12", "2028"), expectedDate2);
    }

    @Test
    public void testElementsToTimeLocalDate2() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        LocalDate expectedDate2 = LocalDate.of(2028, 12, 06);
        assertEquals(dateUtils.elementsToTimeLocalDate(06L, 05L, 2024L), expectedDate);
        assertEquals(dateUtils.elementsToTimeLocalDate("06", "12", "2028"), expectedDate2);
    }

    @Test
    public void testElementsToTimeLocalDate() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        LocalDate expectedDate2 = LocalDate.of(2025, 05, 06);
        assertEquals(dateUtils.elementsToTimeLocalDate(06L, 05L, 2024L), expectedDate);
        assertEquals(dateUtils.elementsToTimeLocalDate(06L, 05L, 2025L), expectedDate2);
    }

    @Test
    public void testSingleStringToJodaLocalTime() throws ParseException {
        org.joda.time.LocalDate expectedDate = new org.joda.time.LocalDate(2024, 05, 06);
        org.joda.time.LocalDate expectedDate2 = new org.joda.time.LocalDate(2025, 05, 06);
        assertEquals(dateUtils.singleStringToJodaLocalDate("06052024", "ddMMyyyy"), expectedDate);
        assertEquals(dateUtils.singleStringToJodaLocalDate("06052025", "ddMMyyyy"), expectedDate2);
    }

    @Test
    public void testSingleStringToJavaLocalTime() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        LocalDate expectedDate2 = LocalDate.of(2026, 05, 06);
        assertEquals(dateUtils.singleStringToJavaLocalDate("06052024", "ddMMyyyy"), expectedDate);
        assertEquals(dateUtils.singleStringToJavaLocalDate("06052026", "ddMMyyyy"), expectedDate2);
    }

    @Test
    public void jodaDateFromParameter() throws ParseException {
        org.joda.time.LocalDate expectedDate = new org.joda.time.LocalDate(2024, 02, 03);
        org.joda.time.LocalDate expectedDate2 = new org.joda.time.LocalDate(2024, 03, 03);
        assertEquals(dateUtils.jodaDateFromParameter(03L, "02", 2024, expectedDate), expectedDate);
        assertEquals(dateUtils.jodaDateFromParameter(03L, "03", 2024, expectedDate2), expectedDate2);
    }

    @Test
    public void javaDateFromParameter() throws ParseException {
        java.time.LocalDate expectedDate = java.time.LocalDate.of(2024, 02, 03);
        java.time.LocalDate expectedDate2 = java.time.LocalDate.of(2099, 04, 03);
        assertEquals(dateUtils.javaTimeDateFromParameter(03L, "02", 2024, expectedDate), expectedDate);
        assertEquals(dateUtils.javaTimeDateFromParameter(03L, "04", 2099, expectedDate2), expectedDate2);
    }

    @Test
    public void elementsToTimeLocalDate() throws ParseException {
        java.time.LocalDate expectedDate = java.time.LocalDate.of(2024, 02, 03);
        java.time.LocalDate expectedDate2 = java.time.LocalDate.of(2027, 11, 04);
        assertEquals(dateUtils.javaTimeDateFromParameter(03L, "02", 2024, expectedDate), expectedDate);
        assertEquals(dateUtils.javaTimeDateFromParameter(04L, "11", 2027, expectedDate2), expectedDate2);
    }

    @Test
    public void gibTypWertZurueck() throws ParseException {

        Executable nullString = () -> dateUtils.gibTypWertZurueck("");
        Executable nullValue = () -> dateUtils.gibTypWertZurueck(null);
        Executable invalidStringValue1 = () -> dateUtils.gibTypWertZurueck("abc");
        Executable invalidStringValue2 = () -> dateUtils.gibTypWertZurueck("123abc");
        Executable validIntValue = () -> dateUtils.gibTypWertZurueck("123");

        IllegalArgumentException nullStringException = assertThrows(IllegalArgumentException.class, nullString);
        IllegalArgumentException nullValueException = assertThrows(IllegalArgumentException.class, nullValue);
        IllegalArgumentException invalidIntegerException1 = assertThrows(IllegalArgumentException.class, invalidStringValue1);
        IllegalArgumentException invalidIntegerException2 = assertThrows(IllegalArgumentException.class, invalidStringValue2);

        assertTrue(nullStringException.getMessage().contains("Input cannot be null or empty"));
        assertTrue(nullValueException.getMessage().contains("Input cannot be null"));
        assertTrue(invalidIntegerException1.getMessage().contains("Input is not a valid integer"));
        assertTrue(invalidIntegerException2.getMessage().contains("Input is not a valid integer"));
    }

    @Test
    public void testExceptionOfElementsToTimeLocalDate() throws ParseException {
        int tag = 1234;
        int monat = 7;
        int jahr = 2024;
        Executable executable = () -> dateUtils.elementsToTimeLocalDate(tag, monat, jahr);

        DateTimeException exception = assertThrows(DateTimeException.class, executable);
        assertTrue(exception.getMessage().contains("Fehler beim Erstellen des Datums."));
    }

    @Test
    public void testUngültigerTypJodaTime() {
        int tag = 15;
        int monat = 7;
        int jahr = 2024;
        String typ = "UngültigerTyp";
        Executable executable = () -> dateUtils.jodaDateFromParameter(tag, monat, jahr, typ);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertTrue(exception.getMessage().contains("Nicht unterstuetzter Typ"));
    }

    /*
     * @Test public void testUngültigesDatum() { int tag = 32; // Ungültiger Tag int monat = 7; int jahr = 2024; LocalDate typ = new LocalDate(jahr,
     * monat, tag);
     * 
     * Executable executable = () -> DateUtils.jodaDateFromParameter(tag, monat, jahr, typ);
     * 
     * assertThrows(IllegalArgumentException.class, executable); }
     */

    @Test
    public void testNullTypJodaTime() {
        int tag = 15;
        int monat = 7;
        int jahr = 2024;
        LocalDate typ = null;

        Executable executable = () -> dateUtils.jodaDateFromParameter(tag, monat, jahr, typ);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertTrue(exception.getMessage().contains("Nicht unterstuetzter Typ"));
    }

    @Test
    public void testUngültigerTypJavaTime() {
        int tag = 15;
        int monat = 7;
        int jahr = 2024;
        String typ = "UngültigerTyp";

        Executable executable = () -> dateUtils.javaTimeDateFromParameter(tag, monat, jahr, typ);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertTrue(exception.getMessage().contains("Nicht unterstuetzter Typ"));
    }

    /*
     * @Test public void testUngültigesDatum() { int tag = 32; // Ungültiger Tag int monat = 7; int jahr = 2024; LocalDate typ = new LocalDate(jahr,
     * monat, tag);
     * 
     * Executable executable = () -> DateUtils.jodaDateFromParameter(tag, monat, jahr, typ);
     * 
     * assertThrows(IllegalArgumentException.class, executable); }
     */

    @Test
    public void testNullTypJavaTime() {
        int tag = 15;
        int monat = 7;
        int jahr = 2024;
        LocalDate typ = null;

        Executable executable = () -> dateUtils.javaTimeDateFromParameter(tag, monat, jahr, typ);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertTrue(exception.getMessage().contains("Nicht unterstuetzter Typ"));
    }

}
