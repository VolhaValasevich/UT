package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculatingSquare {

    Triangle triangle;

    @DataProvider(name = "correctTriangleProvider")
    public Object[][] oneSideNullProviderData() {
        return new Object[][]
                {
                        { new Integer(2), new Integer(4), new Integer(5), new Double(3.7997)},
                        { new Double(5.5), new Double(3.5), new Double(2.2), new Double(1.9996)},
                        { new Double(5.5), new Double(3.5), new Double(2.2), new Double(1.9996)},
                };
    }

    @Test (dataProvider = "incorrectTriangleProvider", dataProviderClass = TestDetectTriangle.class, expectedExceptions = Exception.class)
    public void tstIncorrectTriangleSquare(Integer side_a, Integer side_b, Integer side_c)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        this.triangle.getSquare();
    }

    @Test (dataProvider = "correctTriangleProvider")
    public void tstCorrectTriangleSquare()
    {
        int a = 2, b = 4, c = 5;
        double expected_square = 3.7997, real_square;
        this.triangle = new Triangle(a, b, c);
        real_square = this.triangle.getSquare();
        Assert.assertEquals(real_square, expected_square, 0.0001, "[Square calculation" +
                " failed with a=["+a+"], b=["+b+"], c=["+c+"]; real square: ["+real_square+"], expected: ["+expected_square+"]");
    }

}
