package utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanEqualityTest {

    @Test
    public void equalBooleans() {
        boolean boolVar1 = true;
        boolean boolVar2 = true;


        Boolean boolVar3 = new Boolean(true);
        boolean boolVar4 = false;

        assertTrue(boolVar1 == boolVar2);
        assertTrue(boolVar3.equals(boolVar2));
        assertFalse(boolVar3.equals(boolVar4));
    }
}
