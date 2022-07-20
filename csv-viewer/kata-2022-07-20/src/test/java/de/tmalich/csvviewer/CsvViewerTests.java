package de.tmalich.csvviewer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvViewerTests {

    CsvViewer csvViewer;

    @BeforeEach
    void setup() {
        csvViewer = new CsvViewer(new String[]{"./src/test/resources/csv.csv"});
    }

    @Test
    void constructorWithNullArgument_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new CsvViewer(null));
    }

    @Test
    void constructorWithEmptyArray_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new CsvViewer(new String[0]));
    }

    @Test
    public void load_loadsValidInputStream() throws Exception {
        csvViewer.load();
        assertNotNull(csvViewer.lines);
        assertEquals(8, csvViewer.lines.size());
    }


    @Test
    public void inputList_returnSingleHeader() {
		// expexcted
		// |h1|
		// |--|
        csvViewer.lines = List.of("h1");

        assertEquals(Arrays.asList("|h1|", "|--|"), csvViewer.getFormattedLines());
    }

    @Test
    public void inputList_returnHeaderWithTwoColumns() {
		// expexcted
		// |h1|h2|
		// |--|--|
        csvViewer.lines = List.of("h1;h2");

        assertEquals(List.of("|h1|h2|", "|--|--|"), csvViewer.getFormattedLines());
    }


//    @Test
//    public void inputList_isReturnedFormatted() {
//        csvViewer.lines = Arrays.asList("h1;h2", "v-1;v-2");
//        // assertEquals(Arrays.asList("h1 |h2 ", "v-1|v-2"), csvViewer.getFormattedLines());
//    }
}
