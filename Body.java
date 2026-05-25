public class Body
{
    private double mass;
    private double radius;
    private Vector position;

    public Body(double mass, double radius)
    {
        this.mass = mass;
        this.radius = radius;
        this.position = null;
    }

    public Body(double mass, double radius, Vector position)
    {
        this.mass = mass;
        this.radius = radius;
        this.position = position;
    }

    public double getMass()
    {
        return mass;
    }

    public double getRadius()
    {
        return radius;
    }

    public Vector getPosition()
    {
        return position;
    }

    public void setMass(double mass)
    {
        this.mass = mass;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public void setPosition(Vector position)
    {
        this.position = position;
    }
}
