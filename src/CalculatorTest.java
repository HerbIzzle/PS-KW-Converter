import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    double PSmultiplier = 1.3596216173;
    double KWmultiplier = 0.73549875;

public static String test(double a, String kw, String ps){

     double PSmultiplier = 1.3596216173;
     double KWmultiplier = 0.73549875;

    if ("KW" == kw && a > 0) {
        return a + " PS sind KW :" + String.format("%.5f", a * PSmultiplier);
    }

    else if ("PS" == ps && a > 0) {
        return a + " KW sind PS :" + String.format("%.5f", a * KWmultiplier);
    }
    return null;
}

public static double val(double a, String kw, String ps){

    if ("KW" == kw) {
       a *= 0.73549875;
    }else if ("PS" == ps){
        a *= 1.3596216173;
}
    return a;
}


    @Test
    void conversionInit() {

    UnitConverter unitConverter = new UnitConverter();

        assertEquals(200 * KWmultiplier, unitConverter.calc(200, KWmultiplier) );
     //   assertEquals(200 * PSmultiplier, val(100, null , "PS"));
     //   assertEquals(200 * KWmultiplier, val(100, null, null));

    }

    /*void conversionRandom(){

   double b = val(200, "KW", null);
        java.util.Random r = new java.util.Random();

    }*/

}