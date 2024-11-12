import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class ColourTableTest {
    @Test
    void shouldInitializePaletteWithValidSize() {
        ColourTable table = new ColourTable(4);
    }

    @Test
    void shouldThrowExceptionForNowPowerOfTwoSizes() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(5));
    }

    @Test
    void shouldAddColourToPalette() {
        ColourTable table = new ColourTable(2);
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(255);
        testList.add(255);
        testList.add(255);
        table.add(testList);
        assertEquals(1, table.size());
    }

    @Test
    void shouldThrowExceptionForExceedingBitSize() {
        ColourTable table = new ColourTable(2);
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(255);
        testList.add(255);
        testList.add(256);
        assertThrows(IllegalStateException.class, () -> table.add(testList));
    }

    @Test
    void shouldThrowExceptionForExceedingCapacity() {
        ColourTable table = new ColourTable(2);

        ArrayList<Integer> testList1 = new ArrayList<>();
        testList1.add(255);
        testList1.add(5);
        testList1.add(25);
        table.add(testList1);

        ArrayList<Integer> testList2 = new ArrayList<>();
        testList2.add(67);
        testList2.add(2);
        testList2.add(9);
        table.add(testList2);

        ArrayList<Integer> testList3 = new ArrayList<>();
        testList3.add(67);
        testList3.add(2);
        testList3.add(9);
        assertThrows(IllegalStateException.class,() -> table.add(testList3));
    }
}