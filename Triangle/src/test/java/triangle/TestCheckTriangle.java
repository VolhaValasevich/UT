package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCheckTriangle {
    Triangle triangle;

    @DataProvider(name = "oneSideLongerProvider")
    public Object[][] oneSideLongerProviderData() {
        return new Object[][]
                {
                        { new Integer(1), new Integer(1), new Integer(15), "a+b<=c"},
                        { new Integer(1), new Integer(15), new Integer(1), "a+c<=b"},
                        { new Integer(15), new Integer(1), new Integer(1), "b+c<=a"},
                        { new Integer(1), new Integer(2), new Integer(3), "a+b<=c"},
                        { new Integer(2), new Integer(3), new Integer(1), "a+c<=b"},
                        { new Integer(3), new Integer(2), new Integer(1), "b+c<=a"},
                };
    }

    @DataProvider(name = "nullSideProvider")
    public Object[][] nullSideProviderData() {
        return new Object[][]
                {
                        { new Integer(0), new Integer(1), new Integer(1), "a<=0"},
                        { new Integer(1), new Integer(0), new Integer(1), "b<=0"},
                        { new Integer(1), new Integer(1), new Integer(0), "c<=0"},
                        { new Integer(0), new Integer(0), new Integer(0), "a<=0"},
                };
    }

    @DataProvider(name = "oneSideNegativeProvider")
    public Object[][] oneSideNegativeProviderData() {
        return new Object[][]
                {
                        { new Integer(-1), new Integer(1), new Integer(1), "a<=0"},
                        { new Integer(1), new Integer(-1), new Integer(1), "b<=0"},
                        { new Integer(1), new Integer(1), new Integer(-1), "c<=0"},
                };
    }

    @Test
    public void tstIntegerSidesTriangle()
    {
        int a = 2, b = 4, c = 5;
        this.triangle = new Triangle(a, b, c);
        Assert.assertEquals(this.triangle.checkTriangle(), true, "[Triangle confirmation" +
                " failed with a=["+a+"], b=["+b+"], c=["+c+"], expected: true]");
    }

    @Test
    public void tstDoubleSidesTriangle()
    {
        double a = 1.5, b = 2.3, c = 3.1;
        this.triangle = new Triangle(a, b, c);
        Assert.assertEquals(this.triangle.checkTriangle(), true, "[Triangle confirmation" +
                " failed with a=["+a+"], b=["+b+"], c=["+c+"], expected: true]");
    }

    @Test(dataProvider = "oneSideLongerProvider")
    public void tstOneSideLongerTriangle(Integer side_a, Integer side_b, Integer side_c, String expected_message)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        Assert.assertEquals(this.triangle.checkTriangle(), false, "[Triangle confirmation" +
                " failed with a=["+side_a+"], b=["+side_b+"], c=["+side_c+"], expected: false]");
        Assert.assertEquals(this.triangle.getMessage(), expected_message, "[Wrong message received; got: " +
                "[" + this.triangle.getMessage() + "], expected: ["+expected_message+"]]");
    }

    @Test(dataProvider = "nullSideProvider")
    public void tstnullSideTriangle(Integer side_a, Integer side_b, Integer side_c, String expected_message)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        Assert.assertEquals(this.triangle.checkTriangle(), false, "[Triangle confirmation" +
                " failed with a=["+side_a+"], b=["+side_b+"], c=["+side_c+"], expected: false]");
        Assert.assertEquals(this.triangle.getMessage(), expected_message, "[Wrong message received; got: " +
                "[" + this.triangle.getMessage() + "], expected: ["+expected_message+"]]");
    }

    @Test(dataProvider = "oneSideNegativeProvider")
    public void tstOneSideNegativeTriangle(Integer side_a, Integer side_b, Integer side_c, String expected_message)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        Assert.assertEquals(this.triangle.checkTriangle(), false, "[Triangle confirmation" +
                " failed with a=["+side_a+"], b=["+side_b+"], c=["+side_c+"], expected: false]");
        Assert.assertEquals(this.triangle.getMessage(), expected_message, "[Wrong message received; got: " +
                "[" + this.triangle.getMessage() + "], expected: ["+expected_message+"]]");
    }

}