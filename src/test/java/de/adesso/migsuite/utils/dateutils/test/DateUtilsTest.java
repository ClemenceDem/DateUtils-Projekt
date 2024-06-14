package de.adesso.migsuite.utils.dateutils.test;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Test;

import de.adesso.migsuite.utils.dateutils.DateUtils;

public class DateUtilsTest {

    @Test
    public void testElementsToJodaLocalTime() throws ParseException {
        org.joda.time.LocalDate expectedDate = new org.joda.time.LocalDate(2001, 01, 27);
        assertEquals(DateUtils.elementsToJodaLocalTime("27", "01", "2001"), expectedDate);
    }

    @Test
    public void testElementsToJodaLocalDate1() throws ParseException {
        org.joda.time.LocalDate expectedDate = new org.joda.time.LocalDate(2001, 01, 27);
        assertEquals(DateUtils.elementsToJodaLocalDate(27, 01, 2001), expectedDate);
    }

    @Test
    public void testElementsToJodaLocalDate() throws ParseException {
        org.joda.time.LocalDate expectedDate = new org.joda.time.LocalDate(2001, 01, 27);
        assertEquals(DateUtils.elementsToJodaLocalDate(27l, 01l, 2001l), expectedDate);
    }

    @Test
    public void testElementsToTimeLocalTime1() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.elementsToTimeLocalTime("06", "05", "2024"), expectedDate);
    }

    @Test
    public void testElementsToTimeLocalTime() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.elementsToTimeLocalTime(06, 05, 2024), expectedDate);
    }

    @Test
    public void longsToLocalDate() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.longsToLocalDate(06l, 05l, 2024l), expectedDate);
    }

    @Test
    public void localDateToString() throws ParseException {
        String expectedDate = "06-06-2024";
        assertEquals(DateUtils.localDateToString("06", "06", "2024", "dd-MM-yyyy"), expectedDate);
    }

    @Test
    public void localDateToIntengers() throws ParseException {
        String expectedDate = "06-06-2024";
        assertEquals(DateUtils.localDateToIntengers(06, 06, 2024, "dd-MM-yyyy"), expectedDate);
    }

    @Test
    public void localDateToLongs() throws ParseException {
        String expectedDate = "2024-06-06";
        assertEquals(DateUtils.elementsToJodaLocalDate(06l, 06l, 2024l), expectedDate);
    }

}
