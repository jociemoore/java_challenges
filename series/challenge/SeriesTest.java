package challenge;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class SeriesTest {

    private Series series;

    @Before
    public void setUp() throws Exception {
        series = new Series("01234");
    }

    @Test
    public void shouldReturnSliceOfOne() throws Exception {
        String expectedSlicesString = "[0], [1], [2], [3], [4]";

        List<Integer[]> slices = series.getSlices(1);
        String slicesString = getSlicesAsString(slices);

        assertEquals(expectedSlicesString, slicesString);
    }


    @Test
    public void shouldReturnSlicesOfTwo() throws Exception {
        String expectedSlicesString = "[0, 1], [1, 2], [2, 3], [3, 4]";

        List<Integer[]> slices = series.getSlices(2);
        String slicesString = getSlicesAsString(slices);

        assertEquals(expectedSlicesString, slicesString);
    }

    @Test
    public void shouldReturnSlicesOfThree() throws Exception {
        String expectedSlicesString = "[0, 1, 2], [1, 2, 3], [2, 3, 4]";

        List<Integer[]> slices = series.getSlices(3);
        String slicesString = getSlicesAsString(slices);

        assertEquals(expectedSlicesString, slicesString);
    }

    @Test
    public void shouldReturnSlicesOfFive() throws Exception {
        String expectedSlicesString = "[0, 1, 2, 3, 4]";

        List<Integer[]> slices = series.getSlices(5);
        String slicesString = getSlicesAsString(slices);

        assertEquals(expectedSlicesString, slicesString);
    }

    @Test
    public void shouldNotAllowSlicingLargerThanStringLength() throws Exception {
        String expectedSlicesString = "";
        ExpectedException.none().expect(StringIndexOutOfBoundsException.class);
        ExpectedException.none().expectMessage("Slice is too large.");

        List<Integer[]> slices = series.getSlices(6);
        String slicesString = getSlicesAsString(slices);

        assertEquals(expectedSlicesString, slicesString);
    }


    private String getSlicesAsString(List<Integer[]> slices) {
        String slicesString = "";
        for (Integer[] slice : slices) {
            String sliceOutput = Arrays.toString(slice);
            if (slicesString.isEmpty()) {
                slicesString += sliceOutput;
            } else {
                slicesString += ", " + sliceOutput;
            }
        }
        return slicesString;
    }

}