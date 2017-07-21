package task_04;

public class SausageShop {

    public static int cash = 1000;
    public static int sausageValue = 250;

    public static void main(String[] args) {
        openShop();
    }

    private synchronized static void openShop() {
        while (cash > 0) {
            new SausageShop.CarrotEater().start();
        }
    }

    public static class CarrotEater extends Thread {
        @Override
        public void run() {
            if (cash > 0) {
                cash -= sausageValue;
                System.err.println("Barsik bought sausage. His cash = " + cash);
            }
                else System.err.println("Not enough money");
        }
    }
}
