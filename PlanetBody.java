public class PlanetBody
{
    private Body surfaceBody;
    private Body atmosphereBody;

    public PlanetBody(double mass, double surfaceRadius, double atmosphereRadius, Vector position)
    {
        surfaceBody = new Body(mass, surfaceRadius, position);
        atmosphereBody = new Body(0, atmosphereRadius);
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
