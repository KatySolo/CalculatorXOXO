package vectors;

import java.util.InputMismatchException;

/**
 * Created by KatySolo on 02.10.17.
 */
public class Vector2d extends Vector implements IVector {


    public Vector2d(int x, int y) {
        super(new int[]{x, y});
    }

    public Vector2d add(Vector2d v2) {
        return (Vector2d) super.add(v2);
    }

    public Vector2d sub(Vector2d v2) {
        return (Vector2d) super.sub(v2);
    }

    public double mul(Vector2d v2) {
        return super.mul(v2);
    }

    @Override
    protected Vector transform(int[] coords) {
        return new Vector2d(coords[0], coords[1]);
    }

    public Vector2d scalar(int k) {
        return (Vector2d) super.scalar(k);
    }
}
