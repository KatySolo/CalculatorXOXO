package vectors;

/**
 * Created by KatySolo on 25.09.17.
 */
public abstract class Vector implements IVector {

    public int[] coords;
    private int dimension;

    public Vector(int[] inputCoords) {
        coords = inputCoords;
        dimension = coords.length;
    }

    public int getDimension () {return dimension;}

    @Override
    public boolean equals(Object o)
    {
        if (o == null) {
            return false;
        }
        Vector v = (Vector) o;
       if (v.getDimension() != getDimension()) {
           return false;
       }
       for (int i = 0; i < getDimension(); i++) {
           if (v.coords[i] != coords[i]) {
               return false;
           }
       }
       return true;
    }

    @Override
    public int hashCode ()
    {
        return dimension*43+Float.hashCode(coords[0]+coords[1]);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (int i =0; i<getDimension(); i++)
            if (i != getDimension()-1)
                stringBuilder.append(coords[i]).append(',');
            else
                stringBuilder.append(coords[i]);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    protected abstract Vector transform (int[] coords);

    protected Vector add(Vector v) {

        int dim = getDimension();
        int[] newCoords = new int[dim];
        for (int i = 0; i<dim;i++)
            newCoords[i] = coords[i]+v.coords[i];
        return transform(newCoords);
    };

    protected Vector sub(Vector v) {
        int dim = getDimension();
        int[] newCoords = new int[dim];
        for (int i = 0; i<dim;i++)
            newCoords[i] = coords[i]-v.coords[i];
        return transform(newCoords);
    }

    protected double mul(Vector v)
    {
        double result = 0;
        for (int i = 0; i<getDimension();i++)
            result += coords[i] * v.coords[i];
        return result;
    }

    protected Vector scalar(int k)
    {
        int dim = getDimension();
        int[] newCoords = new int[dim];
        for (int i = 0; i<dim;i++)
            newCoords[i] = k*coords[i];
        return transform(newCoords);
    }

}
/*
примерно 6 ноября (13 если нет пары
Lexer l = new Lexer()
Token[] tokens = tokenize()
1+2i+(i,i,i)+(1,1,1)+2i+1 = 2+4i+(1+i,1+i,1+i)
написать калькулятор векторов
любые скобки одного типа поддерживаются (отсылка к задачке про скобки)
отсутствие пробелов(заменить пробелы если есть на упстые скобки)
все операции возведения в степень
2 ридера: комплексный и векторный

 */