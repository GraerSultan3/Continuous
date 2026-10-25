public class Main
{
    public static void main(String[] args)
    {
        final double graviationalConstant = 6.67 * Math.pow(10, -11);
        Body vessel = new Body(100, 1, new Vector(new double[]{150000 + 6371000, 0}), new Vector(new double[]{0, -7820}));
        PlanetBody earth = new PlanetBody(5.9722 * Math.pow(10, 24), 6371000, 6381000, new Vector(new double[]{0, 0}), new Vector(new double[]{0, 0}));
        

        Vector gravity;
        //System.out.println(vessel.getPosition() + "\n" + vessel.getVelocity() + "\n" + vessel.calculateGravity(earth.getSurfaceBody()));
        
        gravity = vessel.calculateGravity(earth.getSurfaceBody());
        vessel.applyAcceleration(gravity, 0.01);
        System.out.println("\n" + vessel.getPosition() + "\n" + vessel.getVelocity() + "\n" + gravity);

        gravity = vessel.calculateGravity(earth.getSurfaceBody());
        vessel.applyAcceleration(gravity, 0.01);
        System.out.println("\n" + vessel.getPosition() + "\n" + vessel.getVelocity() + "\n" + gravity);
    }
}
