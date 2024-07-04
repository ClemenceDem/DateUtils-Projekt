package de.adesso.migsuite.utils.dateutils.test;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Test;

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

    @Test
    public void testElementsToTimeLocalDate1() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.elementsToTimeLocalDate("06", "05", "2024"), expectedDate);
    }

    @Test
    public void testElementsToTimeLocalDate2() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.elementsToTimeLocalDate(06, 05, 2024), expectedDate);
    }

    @Test
    public void testElementsToTimeLocalDate() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.elementsToTimeLocalDate(06L, 05L, 2024L), expectedDate);
    }

    @Test
    public void testSingleStringToJodaLocalTime() throws ParseException {
        org.joda.time.LocalDate expectedDate = new org.joda.time.LocalDate(2024, 05, 06);
        assertEquals(DateUtils.singleStringToJodaLocalDate("06052024", "ddMMyyyy"), expectedDate);
    }

    @Test
    public void testSingleStringToJavaLocalTime() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.singleStringToJavaLocalDate("06052024", "ddMMyyyy"), expectedDate);
    }

    @Test
    public void jodaDateFromParameter() throws ParseException {
        org.joda.time.LocalDate expectedDate = new org.joda.time.LocalDate(2024, 02, 03);
        assertEquals(DateUtils.jodaDateFromParameter(03L, "02", 2024, expectedDate), expectedDate);
    }

    @Test
    public void javaDateFromParameter() throws ParseException {
        java.time.LocalDate expectedDate = java.time.LocalDate.of(2024, 02, 03);
        assertEquals(DateUtils.javaTimeDateFromParameter(03L, "02", 2024, expectedDate), expectedDate);
    }

    @Test
    public void elementsToTimeLocalDate() throws ParseException {
        java.time.LocalDate expectedDate = java.time.LocalDate.of(2024, 02, 03);
        assertEquals(DateUtils.javaTimeDateFromParameter(03L, "02", 2024, expectedDate), expectedDate);
    }

}
