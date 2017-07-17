import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeaFight {
    private int[][] enemyField = new int[16][16];
    private int tryiesCount = 40;
    private int deckCount = 20;

    public void ShowIntroAndStartGame() {
        SeaFight seaFight = new SeaFight();
        PlayingField playingField = new PlayingField();
        String userInput;
        boolean isRightInput = false;
        char firstChar = 'x';
        int xAxisNum = 0;
        int yAxisNum = 0;

        System.out.println("Welcome to SeaFight game!\n" +
                "Enemy have one 4-deck, two 3-deck, three 2-deck and four 1-deck ships\n" +
                "You have 40 tries to kill them all - if you'll destroy all, you win, in other case - lose\n" +
                "Example of command \"a1\", to exit press q\n" +
                "Go on!");
        playingField.PlaceEnemyShips();
        seaFight.ShowField(this.enemyField);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (this.tryiesCount > 0 || this.deckCount > 0) {
                while (!isRightInput) {
                    userInput = reader.readLine().toLowerCase();
                    if (userInput.length() > 3 || (userInput.length() == 3 && userInput.substring(1).intern() != "10")) {
                        System.err.println("Wrong input");
                    } else {
                        if (userInput.length() == 1) {
                            if (userInput.charAt(0) == 'q') {
                                System.exit(0);
                            }
                            else{
                                System.err.println("Wrong input");
                            }
                        } else {
                            firstChar = userInput.charAt(0);
                            xAxisNum = Integer.parseInt(userInput.substring(1));
                            isRightInput = true;
                        }
                    }
                }

                switch (firstChar) {
                    case 'a':
                        yAxisNum = 1;
                        break;
                    case 'b':
                        yAxisNum = 2;
                        break;
                    case 'c':
                        yAxisNum = 3;
                        break;
                    case 'd':
                        yAxisNum = 4;
                        break;
                    case 'e':
                        yAxisNum = 5;
                        break;
                    case 'f':
                        yAxisNum = 6;
                        break;
                    case 'g':
                        yAxisNum = 7;
                        break;
                    case 'h':
                        yAxisNum = 8;
                        break;
                    case 'i':
                        yAxisNum = 9;
                        break;
                    case 'j':
                        yAxisNum = 10;
                        break;
                    default:
                        System.err.println("Wrong input");
                        break;
                }
                CheckField(playingField.playingField, xAxisNum + 2, yAxisNum + 2);
                System.out.println("You have " + (this.tryiesCount - 1) + " tries");
                seaFight.ShowField(this.enemyField);
                this.tryiesCount--;
                isRightInput = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowField(int[][] enemyField) {
        System.out.println("   A B C D E F G H I J");
        for (int i = 3; i < 13; i++) {
            if (i == 12) {
                System.out.print(i - 2 + " ");
            } else {
                System.out.print(i - 2 + "  ");
            }
            for (int j = 3; j < 13; j++) {
                if (enemyField[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    if (enemyField[i][j] == 1) {
                        System.out.print("x ");
                    } else {
                        if (enemyField[i][j] == -1) {
                            System.out.print("o ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private void CheckField(int[][] playingField, int xAxisNum, int yAxisNum) {
        if (this.enemyField[xAxisNum][yAxisNum] == 1 || this.enemyField[xAxisNum][yAxisNum] == -1) {
            System.out.println("You cant't shoot there");
            this.tryiesCount++;
            System.out.println();
        } else {
            if (playingField[xAxisNum][yAxisNum] == 1) {
                if (playingField[xAxisNum - 1][yAxisNum] != 1 &&
                        playingField[xAxisNum - 1][yAxisNum + 1] != 1 &&
                        playingField[xAxisNum + 1][yAxisNum] != 1 &&
                        playingField[xAxisNum + 1][yAxisNum - 1] != 1 &&
                        playingField[xAxisNum][yAxisNum - 1] != 1 &&
                        playingField[xAxisNum][yAxisNum + 1] != 1 &&
                        playingField[xAxisNum + 1][yAxisNum + 1] != 1 &&
                        playingField[xAxisNum - 1][yAxisNum - 1] != 1) {
                    if (playingField[xAxisNum - 1][yAxisNum] == -1 ||
                            playingField[xAxisNum + 1][yAxisNum] == -1 ||
                            playingField[xAxisNum][yAxisNum - 1] == -1 ||
                            playingField[xAxisNum][yAxisNum + 1] == -1) {
                        if ((playingField[xAxisNum - 1][yAxisNum] == -1
                                && playingField[xAxisNum - 2][yAxisNum] == -1
                                && playingField[xAxisNum - 3][yAxisNum] == 1) ||
                                (playingField[xAxisNum + 1][yAxisNum] == -1
                                        && playingField[xAxisNum + 2][yAxisNum] == -1
                                        && playingField[xAxisNum + 3][yAxisNum] == 1) ||
                                (playingField[xAxisNum][yAxisNum - 1] == -1
                                        && playingField[xAxisNum][yAxisNum - 2] == -1
                                        && playingField[xAxisNum][yAxisNum - 3] == 1) ||
                                (playingField[xAxisNum][yAxisNum + 1] == -1
                                        && playingField[xAxisNum][yAxisNum + 2] == -1
                                        && playingField[xAxisNum][yAxisNum + 3] == 1)) {
                            System.out.println("Harmed");
                            this.deckCount--;
                            System.out.println();
                            playingField[xAxisNum][yAxisNum] = -1;
                            this.enemyField[xAxisNum][yAxisNum] = 1;
                        } else {
                            if (playingField[xAxisNum - 2][yAxisNum] == -1 ||
                                    playingField[xAxisNum + 2][yAxisNum] == -1 ||
                                    playingField[xAxisNum][yAxisNum - 2] == -1 ||
                                    playingField[xAxisNum][yAxisNum + 2] == -1) {
                                System.out.println("Dead");
                                this.deckCount--;
                                playingField[xAxisNum][yAxisNum] = -1;
                                System.out.println();
                                for (int i = 3; i < 13; i++) {
                                    for (int j = 3; j < 13; j++) {
                                        if (playingField[i][j] == -1) {
                                            this.enemyField[i][j] = 1;
                                            this.enemyField[i - 1][j + 1] = -1;
                                            this.enemyField[i + 1][j - 1] = -1;
                                            this.enemyField[i + 1][j + 1] = -1;
                                            this.enemyField[i - 1][j - 1] = -1;
                                            if (playingField[i - 1][j] != -1) {
                                                this.enemyField[i - 1][j] = -1;
                                            }
                                            if (playingField[i + 1][j] != -1) {
                                                this.enemyField[i + 1][j] = -1;
                                            }
                                            if (playingField[i][j - 1] != -1) {
                                                this.enemyField[i][j - 1] = -1;
                                            }
                                            if (playingField[i][j + 1] != -1) {
                                                this.enemyField[i][j + 1] = -1;
                                            }
                                        }
                                    }
                                }
                            } else {
                                if ((playingField[xAxisNum - 1][yAxisNum] == -1
                                        && playingField[xAxisNum - 2][yAxisNum] == 1) ||
                                        (playingField[xAxisNum + 1][yAxisNum] == -1
                                                && playingField[xAxisNum + 2][yAxisNum] == 1) ||
                                        (playingField[xAxisNum][yAxisNum - 1] == -1
                                                && playingField[xAxisNum][yAxisNum - 2] == 1) ||
                                        (playingField[xAxisNum][yAxisNum + 1] == -1
                                                && playingField[xAxisNum][yAxisNum + 2] == 1)) {
                                    System.out.println("Harmed");
                                    this.deckCount--;
                                    System.out.println();
                                    playingField[xAxisNum][yAxisNum] = -1;
                                    this.enemyField[xAxisNum][yAxisNum] = 1;
                                } else {
                                    System.out.println("Dead");
                                    this.deckCount--;
                                    playingField[xAxisNum][yAxisNum] = -1;
                                    System.out.println();
                                    for (int i = 3; i < 13; i++) {
                                        for (int j = 3; j < 13; j++) {
                                            if (playingField[i][j] == -1) {
                                                this.enemyField[i][j] = 1;
                                                this.enemyField[i - 1][j + 1] = -1;
                                                this.enemyField[i + 1][j - 1] = -1;
                                                this.enemyField[i + 1][j + 1] = -1;
                                                this.enemyField[i - 1][j - 1] = -1;
                                                if (playingField[i - 1][j] != -1) {
                                                    this.enemyField[i - 1][j] = -1;
                                                }
                                                if (playingField[i + 1][j] != -1) {
                                                    this.enemyField[i + 1][j] = -1;
                                                }
                                                if (playingField[i][j - 1] != -1) {
                                                    this.enemyField[i][j - 1] = -1;
                                                }
                                                if (playingField[i][j + 1] != -1) {
                                                    this.enemyField[i][j + 1] = -1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    } else {
                        System.out.println("Dead");
                        this.deckCount--;
                        System.out.println();

                        this.enemyField[xAxisNum][yAxisNum] = 1;
                        this.enemyField[xAxisNum - 1][yAxisNum + 1] = -1;
                        this.enemyField[xAxisNum + 1][yAxisNum] = -1;
                        this.enemyField[xAxisNum + 1][yAxisNum - 1] = -1;
                        this.enemyField[xAxisNum][yAxisNum - 1] = -1;
                        this.enemyField[xAxisNum][yAxisNum + 1] = -1;
                        this.enemyField[xAxisNum + 1][yAxisNum + 1] = -1;
                        this.enemyField[xAxisNum - 1][yAxisNum - 1] = -1;
                        this.enemyField[xAxisNum - 1][yAxisNum] = -1;
                    }
                } else {
                    System.out.println("Harmed");
                    this.deckCount--;
                    System.out.println();
                    playingField[xAxisNum][yAxisNum] = -1;
                    this.enemyField[xAxisNum][yAxisNum] = 1;
                }
            } else {
                if (playingField[xAxisNum][yAxisNum] == 0) {
                    System.out.println("Missed");
                    System.out.println();
                    this.enemyField[xAxisNum][yAxisNum] = -1;
                }

            }
        }
    }
}
