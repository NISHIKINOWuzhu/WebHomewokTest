package com.nchu.test1;

        import org.junit.Assert;
        import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    private String INPUT = "17201104";
    @Test
    public void testLength() {
        Assert.assertEquals(64, App.sha256hex(INPUT).length());
    }
    @Test
    public void testHex() {
        String expected = "66c9c9a96d8160499cd8a8306c298782606f9f8f50978617a26d9ca4fa34635a";
        Assert.assertEquals(expected, App.sha256hex(INPUT));
    }

}
