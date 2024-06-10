import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Test;

import de.adesso.migsuite.utils.dateutils.DateUtils;

public class DateUtilsTest {

    @Test
    public void testlocalDateFromStrings() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.localDateFromStrings("06", "05", "2024"), expectedDate);
    }

    @Test
    public void localDateFromIntegers() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.localDateFromIntegers(06, 05, 2024), expectedDate);
    }

    @Test
    public void localDateFromLongs() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.localDateFromLongs(06l, 05l, 2024l), expectedDate);
    }

    @Test
    public void stringsToLocalDate() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.stringsToLocalDate("06", "05", "2024"), expectedDate);
    }

    @Test
    public void intengersToLocalDate() throws ParseException {
        LocalDate expectedDate = LocalDate.of(2024, 05, 06);
        assertEquals(DateUtils.intengersToLocalDate(06, 05, 2024), expectedDate);
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
        String expectedDate = "06-06-2024";
        assertEquals(DateUtils.localDateToLongs(06l, 06l, 2024l, "dd-MM-yyyy"), expectedDate);
    }
}
