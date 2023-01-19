
import java.awt.*;

public class Volvo240 extends Car {

    public static final double TRIM_FACTOR = 1.25;

    public Volvo240() {
        super(4, Color.black, 100, "Volvo240");
    }

    public double speedFactor() {
        return enginePower * 0.01 * TRIM_FACTOR;
    }

    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // TODO fix this method according to lab pm

}
