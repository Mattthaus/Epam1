package validator;

import exception.InputException;

public class TriangleValidator {
    public boolean checkTrianglePossible(double sideA, double sideB, double sideC) throws InputException {

        if (Double.isNaN(sideA) || Double.isNaN(sideB) || Double.isNaN(sideC)){

            throw new InputException("The side can't be NaN");
        }

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {

            throw new InputException("The length of the side must be more than 0");
        }

        if (sideA == Double.MAX_VALUE || sideB == Double.MAX_VALUE || sideC == Double.MAX_VALUE){

            throw new InputException("Side is big very");
        }

        return 2 * Math.max(Math.max(sideA, sideB), sideC) < sideA + sideB + sideC;
    }
}
