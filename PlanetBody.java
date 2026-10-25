public class PlanetBody
{
    private Body surfaceBody;
    private Body atmosphereBody;
    private Vector velocity;

    public PlanetBody(double mass, double surfaceRadius, double atmosphereRadius, Vector position, Vector velocity)
    {
        surfaceBody = new Body(mass, surfaceRadius, position, velocity);
        atmosphereBody = new Body(0, atmosphereRadius);
        this.velocity = velocity;
    }

    public Vector getPosition()
    {
        return surfaceBody.getPosition();
    }

    public double getMass()
    {
        return surfaceBody.getMass();
    }

    public Body getSurfaceBody()
    {
        return surfaceBody;
    }

    public Vector calculateGravity(Body otherGoober)
    {
        Vector positionVector = Vector.subtractVectors(otherGoober.getPosition(), this.surfaceBody.getPosition());
        double distance = positionVector.getValue(-1);

        Vector gravity = Vector.scaleVector(positionVector.getUnitVector(),
                -1 * (Math.pow(6.674, Math.pow(10, -11)) * this.surfaceBody.getMass() * otherGoober.getMass()) / Math.pow(distance, 2)
        );

        return gravity;
    }
}
