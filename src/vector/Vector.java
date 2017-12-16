package vector;

import complex.ComplexNumber;

import java.util.Arrays;

public class Vector{
    ComplexNumber[] values;
    int dimension;

    public Vector(ComplexNumber... newValues) {
        if (newValues.length <= 1)
            throw new IllegalArgumentException("Choose correct dimension");
        this.dimension = newValues.length;
        this.values = new ComplexNumber[dimension];
        for (int i = 0; i < newValues.length; i++)
            values[i] = newValues[i];
    }

    public static Vector add(Vector v1, Vector v2){
        ComplexNumber[] result = new ComplexNumber[v1.dimension];
        for (int i = 0; i < v1.dimension; i++)
            result[i] = ComplexNumber.add(v1.values[i], v2.values[i]);
        return new Vector(result);
    }

    public static Vector mul(Vector v1, double scalar){
        ComplexNumber[] result = new ComplexNumber[v1.dimension];
        for (int i = 0; i < v1.dimension; i++)
            result[i] = ComplexNumber.scalar(v1.values[i], scalar);
        return new Vector(result);
    }

    public static Vector mul(double scalar, Vector v1){
        return mul(v1, scalar);
    }

    public static Vector sub(Vector v1, Vector v2){
        ComplexNumber[] result = new ComplexNumber[v1.dimension];
        for (int i = 0; i < v1.dimension; i++)
            result[i] = ComplexNumber.add(v1.values[i], ComplexNumber.scalar(v2.values[i], -1));
        return new Vector(result);
    }

    public static ComplexNumber dotProduction(Vector v1, Vector v2){
        ComplexNumber result = new ComplexNumber(0, 0);
        for (int i = 0; i < v1.dimension; i++)
            result.add(ComplexNumber.multiply(v1.values[i], v2.values[i]));
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(values).replace("[", "(").replace("]", ")");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dimension;
        result = prime * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector other = (Vector) obj;
        if (dimension != other.dimension)
            return false;
        if (!Arrays.equals(values, other.values))
            return false;
        return true;
    }
}
