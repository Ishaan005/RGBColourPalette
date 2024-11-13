import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColourTableTest {
    @Test
    void shouldInitializePaletteWithValidSize() {
        new ColourTable(4);
    }

    @Test
    void shouldThrowExceptionForNowPowerOfTwoSizes() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(5));
    }

    @Test
    void shouldAddColourToPalette() {
        ColourTable table = new ColourTable(2);
        table.add(0xFF0000);
        assertEquals(1, table.size());
    }

    @Test
    void shouldThrowExceptionForExceedingBitSize() {
        ColourTable table = new ColourTable(2);
        table.add(0xFF0000);
        assertThrows(IllegalStateException.class, () -> table.add(0xFFFFFFF));
    }

    @Test
    void shouldThrowExceptionForExceedingCapacity() {
        ColourTable table = new ColourTable(2);
        table.add(0xFFFFFF);
        table.add(0xFFFFFF);
        assertThrows(IllegalStateException.class,() -> table.add(0xFF0101));
    }
}