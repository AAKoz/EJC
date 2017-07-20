import java.io.IOException;

public class Rabbit {
    public volatile static boolean isScary = false;

    public static void main(String[] args) {
        new Rabbit.CarrotEater().start();
        new Rabbit.ScaredRabbit().start();
    }

    public static class ScaredRabbit extends Thread {
        @Override
        public void run() {
            try {
                int enter = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isScary = true;
            System.err.println("You made him run away");
        }
    }

    public static class CarrotEater extends Thread {
        @Override
        public void run() {
            while (!isScary) {
                System.err.println("Rabbit is eating your carrots!");
            }
        }
    }
}
