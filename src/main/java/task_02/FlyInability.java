package task_02;

public class FlyInability implements FlyBehavior {
    @Override
    public void flyBehavior(Duck duck) {
        duck.speed = 0;
    }
}
