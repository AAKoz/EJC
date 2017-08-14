package task_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class DuckRaces {
    private final int FLYTIME = 10;

    public void startRace() {
        Player player = new Player();
        Duck marty = new Duck();
        Duck melvin = new Duck();
        Duck mervin = new Duck();
        Duck gaben = new Duck();
        Duck joe = new Duck();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ducksPosition = new int[5];

        while (player.cash != 0) {
            doRegularOutput(player);
            try {
                while (player.duckNumber > 5 || player.duckNumber < 1) {
                    player.duckNumber = Integer.parseInt(reader.readLine());
                    if (player.duckNumber > 5 || player.duckNumber < 1)
                        System.err.println("This duck's number doesn't exists");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.cash -= 100;
            System.out.println("Race begins!");

            for (int i = 0; i < FLYTIME; ++i) {
                doSpeedDistributionForAllDucks(marty, melvin, mervin, gaben, joe);
                letOutDucks(marty, melvin, mervin, gaben, joe, ducksPosition);
                System.out.println("");
            }
            if (findWinner(ducksPosition) == (player.duckNumber - 1)) {
                System.out.println("Your duck win\'s");
                System.out.println("");
                player.cash += 200;
            } else {
                System.out.println("Your duck loses");
                System.out.println("");
            }
            nullPositionAndDucksNumber(player, ducksPosition);
        }
        System.out.println("You lose!");
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doRegularOutput(Player player) {
        System.out.println("Your cash: " + player.cash);
        System.out.println("Choose your duck's number:   1.Marty");
        System.out.println("                             2.Melvin");
        System.out.println("                             3.Mervin");
        System.out.println("                             4.Gaben");
        System.out.println("                             5.Joe");
    }

    private void doSpeedDistributionForAllDucks(Duck Marty, Duck Melvin, Duck Mervin, Duck Gaben, Duck Joe) {
        Marty.doSpeedDistribution();
        Melvin.doSpeedDistribution();
        Mervin.doSpeedDistribution();
        Gaben.doSpeedDistribution();
        Joe.doSpeedDistribution();
    }

    private void letOutDucks(Duck Marty, Duck Melvin, Duck Mervin, Duck Gaben, Duck Joe, int[] ducksPosition) {
        ducksPosition[0] += Marty.speed;
        System.out.println("Marty' s position = " + ducksPosition[0]);
        ducksPosition[1] += Melvin.speed;
        System.out.println("Melvin' s position = " + ducksPosition[1]);
        ducksPosition[2] += Mervin.speed;
        System.out.println("Mervin' s position = " + ducksPosition[2]);
        ducksPosition[3] += Gaben.speed;
        System.out.println("Gaben' s position = " + ducksPosition[3]);
        ducksPosition[4] += Joe.speed;
        System.out.println("Joe' s position = " + ducksPosition[4]);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int findWinner(int[] ducksPosition) {
        int maxIndex = 0;
        for (int i = 0; i < ducksPosition.length; i++) {
            if (ducksPosition[maxIndex] < ducksPosition[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void nullPositionAndDucksNumber(Player player, int[] ducksPosition) {
        player.duckNumber = 0;
        for (int i = 0; i < ducksPosition.length; i++) {
            ducksPosition[i] = 0;
        }
    }
}

