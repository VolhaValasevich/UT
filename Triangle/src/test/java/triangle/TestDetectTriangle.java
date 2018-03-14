package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDetectTriangle {
    Triangle triangle;

    @DataProvider(name = "isoscelesProvider")
    public Object[][] isoscelesProviderData() {
        return new Object[][]
                {
                        { new Integer(2), new Integer(3), new Integer(3) },
                        { new Integer(3), new Integer(2), new Integer(3)},
                        { new Integer(3), new Integer(3), new Integer(2)},
                };
    }

    @DataProvider(name = "rectangularProvider")
    public Object[][] rectangularProviderData() {
        return new Object[][]
                {
                        { new Integer(3), new Integer(4), new Integer(5) },
                        { new Integer(3), new Integer(5), new Integer(4)},
                        { new Integer(5), new Integer(3), new Integer(4)},
                };
    }

    @DataProvider(name = "rectangularIsoscelesProvider")
    public Object[][] rectangularIsoscelesProviderData() {
        return new Object[][]
                {
                        { new Double(7), new Double(7), Math.sqrt(7*7 + 7*7) },
                        { new Double(7), Math.sqrt(7*7 + 7*7), new Double(7)},
                        { Math.sqrt(7*7 + 7*7), new Double(7), new Double(7)},
                        { new Double(3), new Double(3), Math.sqrt(3*3 + 3*3) },
                        { new Double(3), Math.sqrt(3*3 + 3*3), new Double(3)},
                        { Math.sqrt(3*3 + 3*3), new Double(3), new Double(3)},
                };
    }

    @DataProvider(name = "incorrectTriangleProvider")
    public static Object[][] incorrectTriangleProviderData() {
        return new Object[][]
                {
                        //one side is longer than the sum of two others
                        { new Integer(1), new Integer(1), new Integer(15) },
                        { new Integer(1), new Integer(15), new Integer(1)},
                        { new Integer(15), new Integer(1), new Integer(1)},
                        //one side equals the sum of two others
                        { new Integer(1), new Integer(2), new Integer(3) },
                        { new Integer(2), new Integer(3), new Integer(1)},
                        { new Integer(3), new Integer(2), new Integer(1)},
                        //one side is zero
                        { new Integer(0), new Integer(1), new Integer(1) },
                        { new Integer(1), new Integer(0), new Integer(1)},
                        { new Integer(1), new Integer(1), new Integer(0)},
                        //one side is negative
                        { new Integer(-1), new Integer(1), new Integer(1) },
                        { new Integer(1), new Integer(-1), new Integer(1)},
                        { new Integer(1), new Integer(1), new Integer(-1)},
                };
    }

    @Test
    public void tstIfEquilateral()
    {
        int a = 3;
        this.triangle = new Triangle(a, a, a);
        Assert.assertEquals(this.triangle.detectTriangle(), triangle.TR_EQUILATERAL|triangle.TR_ISOSCELES, "[Equilateral " +
                "triangle check failed with a=["+a+"], b=["+a+"], c=["+a+"]]");
    }

    @Test
    public void tstIfOrdynary()
    {
        int a = 2, b = 4, c = 5;
        this.triangle = new Triangle(a, b, c);
        Assert.assertEquals(this.triangle.detectTriangle(), triangle.TR_ORDYNARY, "[Ordinary " +
                "triangle check failed with a=["+a+"], b=["+b+"], c=["+c+"]]");
    }

    @Test(dataProvider = "isoscelesProvider")
    public void tstIfIsosceles(Integer side_a, Integer side_b, Integer side_c)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        Assert.assertEquals(this.triangle.detectTriangle(), triangle.TR_ISOSCELES, "[Isosceles " +
                "triangle check failed with a=["+side_a+"], b=["+side_b+"], c=["+side_c+"]]");
    }

    @Test(dataProvider = "rectangularProvider")
    public void tstIfRectangular(Integer side_a, Integer side_b, Integer side_c)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        Assert.assertEquals(this.triangle.detectTriangle(), triangle.TR_RECTANGULAR, "[Rectangular " +
                "triangle check failed with a=["+side_a+"], b=["+side_b+"], c=["+side_c+"]]");
    }

    @Test(dataProvider = "rectangularIsoscelesProvider")
    public void tstIfRectangularIsosceles(Double side_a, Double side_b, Double side_c)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        Assert.assertEquals(this.triangle.detectTriangle(), triangle.TR_RECTANGULAR|triangle.TR_ISOSCELES, "[Rectangular isosceles " +
                "triangle check failed with a=["+side_a+"], b=["+side_b+"], c=["+side_c+"]]");
    }

    @Test(dataProvider = "incorrectTriangleProvider", expectedExceptions = Exception.class)
    public void tstIfIncorrectTriangle(Integer side_a, Integer side_b, Integer side_c)
    {
        this.triangle = new Triangle(side_a, side_b, side_c);
        this.triangle.detectTriangle();
    }

}
