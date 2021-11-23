import Exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

//gueltige Aequivalenzklassen
    // gÄK1: [0, ..., 5000]        -- Räpresentant     666


//ungueltige Aequivalenzklassen
    // uÄK1: [MIN_INT, ..., 0[     --Räpresentant     -500
    // uÄK2: ]5000, ..., MAX_INT]  --Räpresentant   2.000.000


    @Test
    void testKwToPs() {

        String[] units = {"KW", "PS"};
        double WERT = 666;
        double EXPECTED = 905.5079971218;
        UnitConverter converter = new UnitConverter();
        double ACTUAL = 0;


        try {
            ACTUAL = converter.assignUnitToCalc(units[1], WERT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(EXPECTED, ACTUAL);
    }


    @Test
    void testPsToKw() {

        String[] units = {"KW", "PS"};
        double WERT = 666;
        double EXPECTED = 489.84216749999996;
        UnitConverter converter = new UnitConverter();
        double ACTUAL = 0;


        try {
            ACTUAL = converter.assignUnitToCalc(units[0], WERT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(EXPECTED, ACTUAL);

    }


    @Test
    void testForNegativeInput() {

        String[] units = {"KW", "PS"};
        double WERT = -500;
        String inputZeroOrLessMsg = "Der Wert ist zu klein oder 0";

        try {
            UnitConverter converter = new UnitConverter();
            converter.assignUnitToCalc(units[0], WERT);
            fail();

        } catch (InvalidNumberException e) {
            assertEquals(inputZeroOrLessMsg, e.getMessage());
        }
    }


    @Test
    void testForExcessiveInputValue() {

        String[] units = {"KW", "PS"};
        UnitConverter converter = new UnitConverter();

        Exception e = assertThrows(InvalidNumberException.class, () -> converter.assignUnitToCalc(units[1], 2_000_000));

        assertEquals("Der Wert ist zu groß", e.getMessage());
    }



}