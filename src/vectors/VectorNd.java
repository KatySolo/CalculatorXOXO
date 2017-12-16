package vectors;

import java.util.InputMismatchException;

/**
 * Created by KatySolo on 02.10.17.
 */
public class VectorNd extends Vector {

    public VectorNd(int[] coords) {super(coords);}

    @Override
    protected Vector transform(int[] coords) {
        return new VectorNd(coords);
    }

    public VectorNd add(VectorNd vNd) {
        if (getDimension()==vNd.getDimension())
        {
           return (VectorNd)super.add(vNd);
        }
        else
            throw new InputMismatchException("Different dimensions");
    }

    public VectorNd sub(VectorNd vNd) {

        if (getDimension()==vNd.getDimension())
        {
            return (VectorNd)super.sub(vNd);
        }
        else
            throw new InputMismatchException("Different dimensions");
    }

    public VectorNd scalar(int k) {
       return (VectorNd) super.scalar(k);
    }

    @Override
    public double mul(Vector vNd) {
        if (getDimension()==vNd.getDimension())
        {
           return super.mul(vNd);
        }
        else
            throw new InputMismatchException("Different dimensions");
    }

}
