package task_02;

import java.util.Random;

public class Duck {

    FlyBehavior duckFlyBehavior;
    int speed;

    public void DoSpeedDistribution() {
        Random random = new Random();
        if (random.nextBoolean() == true) {
            this.SetFlyBehavior(new FlyAbility());
            this.PerformFly();
        } else {
            this.SetFlyBehavior(new FlyInability());
            this.PerformFly();
        }
    }

    private void SetFlyBehavior(FlyBehavior flyBehaviorDynamical) {
        duckFlyBehavior = flyBehaviorDynamical;
    }

    private void PerformFly() {
        duckFlyBehavior.flyBehavior(this);
    }
}
