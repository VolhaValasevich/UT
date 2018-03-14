package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculatingSquare {

    Triangle triangle;

    @DataProvider(name = "correctTriangleProvider")
    public Object[][] correctTriangleProviderData() {
        return new Object[][]
                {
                        { 2, 4, 5, 3.7997},
                        { 5.5, 3.5, 2.2, 1.9996},
                        { 5, 3.5, 2.2, 3.3033},
                        { 5.5, 3, 2.6, 1.4448},
                        { 5.5, 3.5, 3, 4.7434},
                        /*{ new Double(2), new Double(4), new Double(5), new Double(3.7997)},
                        { new Double(5.5), new Double(3.5), new Double(2.2), new Double(1.9996)},
                        { new Double(5), new Double(3.5), new Double(2.2), new Double(3.3033)},
                        { new Double(5.5), new Double(3), new Double(2.6), new Double(1.4448)},
                        { new Double(5.5), new Double(3.5), new Double(3), new Double(4.7434)},*/
                };
    }

    @Test (dataProvider = "incorrectTriangleProvider", dataProviderClass = TestDetectTriangle.class, expectedExceptions = Exception.class)
    public void tstIncorrectTriangleSquare(Integer side_a, Integer side_b, Integer side_c)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        this.triangle.getSquare();
    }

    @Test (dataProvider = "correctTriangleProvider")
    public void tstCorrectTriangleSquare(double side_a, double side_b, double side_c, double expected_square)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        double real_square = this.triangle.getSquare();
        Assert.assertEquals(real_square, expected_square, 0.0001, "[Square calculation" +
                " failed with a=["+side_a+"], b=["+side_b+"], c=["+side_c+"]; real square: ["+real_square+"], expected: ["+expected_square+"]");
    }

}
