/**
 * @author Olivia Romo
 *         Description: Calculates height of ball
 */
public class ballHeightCalc {
    public static void main(String[] args) {
        ballHeightCompute(4, 4, 4);
    }

    private static double ballHeightCompute(double initHeight, double velocity, double time) {
        final double GRAVITY = 32.174;
        double gravTime = GRAVITY * 0.5 * Math.pow(time, 2);
        return velocity * time - gravTime;
    }

}
