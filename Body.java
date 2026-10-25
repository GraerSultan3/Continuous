public class Body
{
    final double graviationalConstant = 6.67 * Math.pow(10, -11);
    // Attributes
    private double mass;
    private double radius;
    private Vector position;
    private Vector velocity;

    // Constructors
    public Body(double mass, double radius)
    {
        this.mass = mass;
        this.radius = radius;
        this.position = null;
        this.velocity = null;
    }

    public Body(double mass, double radius, Vector position, Vector velocity)
    {
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
    }

    // Getters/setters
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

    public Vector getVelocity()
    {
        return velocity;
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

    // Normal meths
    public void applyAcceleration(Vector acceleration, double timeStep)
    {
        velocity = Vector.addVectors(
            velocity, 
            Vector.scaleVector(
                acceleration, timeStep
            )
        );

        position = Vector.addVectors(
            position,
            Vector.scaleVector(
                velocity, timeStep
            )
        );
    }

    public Vector calculateGravity(Body otherBody)
    {
        Vector gravity = Vector.scaleVector(
            Vector.pow(
                Vector.subtractVectors(this.position, otherBody.getPosition()), -2.0
            ),
            (graviationalConstant * otherBody.getMass())
        );

        return gravity;
    }
}
