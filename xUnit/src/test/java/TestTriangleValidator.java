import exception.InputException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validator.TriangleValidator;

import static org.testng.Assert.*;


public class TestTriangleValidator {

    TriangleValidator triangleValidator = new TriangleValidator();

    @DataProvider
    public Object[][] positiveCase() {

        return new Object[][]{

                {4, 5, 2.4},
                {10, 15, 12}
        };
    }

    @Test(dataProvider = "positiveCase")
    public void testCheckTrianglePossiblePositiveCase(double sideA, double sideB, double sideC) throws Exception {

        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] negativeCase() {

        return new Object[][]{

                {8, 7, 100},
                {1, 200, 1}
        };
    }
    @Test(dataProvider = "negativeCase")
    public void testCheckTrianglePossibleNegativeCase(double sideA, double sideB, double sideC) throws Exception {

        assertFalse(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] negativeSide() {

        return new Object[][]{

                {1, -2, 6},
                {2.2, -3, 1}
        };
    }
    @Test(dataProvider = "negativeSide", expectedExceptions = InputException.class,
            expectedExceptionsMessageRegExp = "The length of the side must be more than 0")
    public void testCheckTrianglePossibleNegativeSide(double sideA, double sideB, double sideC) throws Exception {

        triangleValidator.checkTrianglePossible(sideA, sideB, sideC);
    }

    @DataProvider
    public Object[][] zeroSide() {

        return new Object[][]{

                {5, 0, 9},
                {11, 11, 0}
        };
    }
    @Test(dataProvider = "zeroSide", expectedExceptions = InputException.class,
            expectedExceptionsMessageRegExp = "The length of the side must be more than 0")
    public void testCheckTrianglePossibleZeroSide(double sideA, double sideB, double sideC) throws Exception {

        triangleValidator.checkTrianglePossible(sideA, sideB, sideC);
    }

    @DataProvider
    public Object[][] egyptianTriangle() {

        return new Object[][]{

                {3, 4, 5},
                {12, 16, 25}
        };
    }

    @Test(dataProvider = "egyptianTriangle")
    public void testCheckTriangleEgyptian(double sideA, double sideB, double sideC) throws Exception {

        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] incorrectSides() {

        return new Object[][]{

                {3, Double.NaN, 5},
                {4, Float.NaN, 6}
        };
    }
    @Test(dataProvider = "incorrectSides", expectedExceptions = InputException.class,
            expectedExceptionsMessageRegExp = "The side can't be NaN")
    public void testCheckTriangleIncorrectSides(double sideA, double sideB, double sideC) throws Exception {

        triangleValidator.checkTrianglePossible(sideA, sideB, sideC);
    }

    @DataProvider
    public Object[][] bigSides() {

        return new Object[][]{

                {Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE},
                {Float.MAX_VALUE - 10, Float.MAX_VALUE - 15, Float.MAX_VALUE - 40}

        };
    }
    @Test(dataProvider = "bigSides")
    public void testCheckTriangleBigSides(double sideA, double sideB, double sideC) throws Exception {

        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] smallSides() {

        return new Object[][]{

                {Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE},
                {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}
        };
    }
    @Test(dataProvider = "smallSides")
    public void testCheckTriangleSmallSides(double sideA, double sideB, double sideC) throws Exception {

        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] equilateralSides() {

        return new Object[][]{

                {777, 777, 777},
                {666, 666, 666}
        };
    }

    @Test(dataProvider = "equilateralSides")
    public void testCheckTriangleEquilateralSides(double sideA, double sideB, double sideC) throws Exception {
        
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] tooBigSides() {
        return new Object[][]{

                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MAX_VALUE - 47, Double.MAX_VALUE - 40, Double.MAX_VALUE - 13}
        };
    }
    @Test(dataProvider = "tooBigSides", expectedExceptions = InputException.class,
            expectedExceptionsMessageRegExp = "Side is big very")
    public void testCheckTriangleTooBigSides(double sideA, double sideB, double sideC) throws Exception {

        triangleValidator.checkTrianglePossible(sideA, sideB, sideC);
    }
}
