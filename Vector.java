public class Vector
{
    private double magnitude;
    private double[] values;

    public static Vector addVectors(Vector v1, Vector v2)
    {
        double[] newValues = new double[Math.max(v1.getSize(), v2.getSize())];

        for (int i = 0; i < newValues.length; i++)
        {
            newValues[i] = v1.getValue(i) + v2.getValue(i);
        }

        return new Vector(newValues);
    }

    public static Vector subtractVectors(Vector v1, Vector v2)
    {
        double[] newValues = new double[Math.max(v1.getSize(), v2.getSize())];

        for (int i = 0; i < newValues.length; i++)
        {
            newValues[i] = v1.getValue(i) - v2.getValue(i);
        }

        return new Vector(newValues);
    }

    public static double getDotProduct(Vector v1, Vector v2)
    {
        double dotProduct = 0;

        for (int i = 0; i < Math.max(v1.getSize(), v2.getSize()); i++)
        {
            dotProduct += v1.getValue(i) * v2.getValue(i);
        }

        return dotProduct;
    }

    public static Vector scaleVector(Vector v1, double scale)
    {
        double[] values = new double[v1.getSize()];

        for (int i = 0; i < values.length; i++)
        {
            values[i] = v1.getValue(i) * scale;
        }

        return new Vector(values);
    }

    public static double getCrossProduct(Vector v1, Vector v2)
    {
        return (v1.getValue(0) * v2.getValue(1)) - (v1.getValue(1) * v2.getValue(0));
    }

    public Vector(double magnitude, double[] directions)
    {
        values = new double[directions.length];

        for (int i = 0; i < directions.length; i++)
        {
            values[i] = magnitude * directions[i];
        }

        magnitude = magnitude;
    }

    public Vector(double[] values)
    {
        this.values = values;

        magnitude = 0;

        for (int i = 0; i < values.length; i++)
        {
            magnitude += Math.pow(values[i], 2);
        }

        magnitude = Math.sqrt(magnitude);
    }

    public double getValue(int direction)
    {
        try
        {
            if (direction == -1) {
                return magnitude;
            }
            return values[direction];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return 0.0;
        }
    }

    public Vector getUnitVector()
    {
        double[] values = new double[this.values.length];

        for (int i = 0; i < this.values.length; i++)
        {
            values[i] = this.values[i] / magnitude;
        }

        return new Vector(values);
    }

    public void setValue(int direction, int value)
    {
        if (direction == -1)
        {
            magnitude = value;
        }
        else
        {
            values[direction] = value;
        }
    }

    public void setValues(int[][] directionsAndValues)
    {
        for (int i = 0; i < directionsAndValues.length; i++)
        {
            if  (directionsAndValues[i][0] == -1)
            {
                magnitude = directionsAndValues[i][1];
            }
            else
            {
                values[directionsAndValues[i][0]] = directionsAndValues[i][1];
            }
        }
    }

    public int getSize()
    {
        return values.length;
    }
}
