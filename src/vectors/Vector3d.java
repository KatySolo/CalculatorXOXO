package vectors;

/**
 * Created by KatySolo on 02.10.17.
 */
public class Vector3d extends Vector {


    public Vector3d(int x, int y, int z) {
        super(new int[]{x, y, z});
    }

    @Override
    protected Vector transform(int[] coords) {
        return new Vector3d(coords[0] , coords[1], coords[2]);
    }

    public Vector3d add(Vector v3) {
        return (Vector3d) super.add(v3);
    }

    public Vector3d sub(Vector v3) {
        return (Vector3d) super.sub(v3);
    }

    public double mul(Vector v3) {
        return super.mul(v3);
    }

    public Vector3d scalar(int k) {
        return (Vector3d) super.scalar(k);
    }
}
