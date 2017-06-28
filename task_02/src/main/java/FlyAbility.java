import java.util.Random;

public class FlyAbility implements FlyBehavior {
    @Override
    public void flyBehavior(Duck duck) {
        Random r = new Random();
        int Low = 10;
        int High = 100;
        duck.speed = (r.nextInt(High - Low) + Low) << 1;
    }
}
