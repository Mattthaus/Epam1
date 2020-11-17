package planes;

import models.ClassificationLevel;

import java.util.Objects;

public class ExperimentalPlane extends Plane{

    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ExperimentalPlane) {
            return super.equals(object) && classificationLevel == ((ExperimentalPlane) object).classificationLevel;
        }
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classificationLevel);
    }

    @Override
    public String toString() {
        return "experimental" +
                super.toString().replace("}",
                        ", model='" + model + '\'' +
                                '}');
    }
}