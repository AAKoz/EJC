package task_02;

import java.util.Random;

public class Duck {

    FlyBehavior duckFlyBehavior;
    int speed;

    public void doSpeedDistribution() {
        Random random = new Random();
        if (random.nextBoolean() == true) {
            this.setFlyBehavior(new FlyAbility());
            this.performFly();
        } else {
            this.setFlyBehavior(new FlyInability());
            this.performFly();
        }
    }

    private void setFlyBehavior(FlyBehavior flyBehaviorDynamical) {
        duckFlyBehavior = flyBehaviorDynamical;
    }

    private void performFly() {
        duckFlyBehavior.flyBehavior(this);
    }
}
