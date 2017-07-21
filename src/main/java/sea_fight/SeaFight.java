package sea_fight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeaFight {
    private int[][] enemyField = new int[16][16];
    private int tryiesCount = 40;
    private int deckCount = 20;

    /**
     * Shows introduction to the game and releases game process.
     * Gets shoots, check them and shows log.
     */
    public void showIntroAndStartGame() {
        SeaFight seaFight = new SeaFight();
        PlayingField playingField = new PlayingField();
        String userInput;
        boolean isRightInput = false;
        char firstChar = 'x';
        int axisNumX = 0;
        int axisNumY = 0;

        System.out.println("Welcome to SeaFight game!\n" +
                "Enemy have one 4-deck, two 3-deck, three 2-deck and four 1-deck ships\n" +
                "You have 40 tries to kill them all - if you'll destroy all, you win, in other case - lose\n" +
                "Example of command \"a1\", to exit press q\n" +
                "Go on!");
        playingField.placeEnemyShips();
        seaFight.showField(this.enemyField);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (this.tryiesCount > 0 || this.deckCount > 0) {
                while (!isRightInput) {
                    userInput = reader.readLine().toLowerCase();
                    if (userInput.length() > 3 || (userInput.length() == 3
                            && userInput.substring(1).intern() != "10")) {
                        System.err.println("Wrong input");
                    } else {
                        if (userInput.length() == 1) {
                            if (userInput.charAt(0) == 'q') {
                                System.exit(0);
                            } else {
                                System.err.println("Wrong input");
                            }
                        } else {
                            firstChar = userInput.charAt(0);
                            axisNumX = Integer.parseInt(userInput.substring(1));
                            isRightInput = true;
                        }
                    }
                }
                switch (firstChar) {
                    case 'a':
                        axisNumY = 1;
                        break;
                    case 'b':
                        axisNumY = 2;
                        break;
                    case 'c':
                        axisNumY = 3;
                        break;
                    case 'd':
                        axisNumY = 4;
                        break;
                    case 'e':
                        axisNumY = 5;
                        break;
                    case 'f':
                        axisNumY = 6;
                        break;
                    case 'g':
                        axisNumY = 7;
                        break;
                    case 'h':
                        axisNumY = 8;
                        break;
                    case 'i':
                        axisNumY = 9;
                        break;
                    case 'j':
                        axisNumY = 10;
                        break;
                    default:
                        System.err.println("Wrong input");
                        break;
                }
                checkField(playingField.playingField, axisNumX + 2, axisNumY + 2);
                System.out.println("You have " + (this.tryiesCount - 1) + " tries");
                seaFight.showField(this.enemyField);
                this.tryiesCount--;
                isRightInput = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows current position of all ships on field.
     *
     * @param enemyField field shown to the player
     */
    private void showField(int[][] enemyField) {
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

    /**
     * Checks shoots, made by player and writes the result to console.
     *
     * @param axisNumX coordinate on X-axis
     * @param axisNumY coordinate on Y-axis
     * @param playingField field which consists placement of all ships
     */
    private void checkField(int[][] playingField, int axisNumX, int axisNumY) {
        if (this.enemyField[axisNumX][axisNumY] == 1 || this.enemyField[axisNumX][axisNumY] == -1) {
            System.out.println("You cant't shoot there");
            this.tryiesCount++;
            System.out.println();
        } else {
            if (playingField[axisNumX][axisNumY] == 1) {
                if (playingField[axisNumX - 1][axisNumY] != 1 &&
                        playingField[axisNumX - 1][axisNumY + 1] != 1 &&
                        playingField[axisNumX + 1][axisNumY] != 1 &&
                        playingField[axisNumX + 1][axisNumY - 1] != 1 &&
                        playingField[axisNumX][axisNumY - 1] != 1 &&
                        playingField[axisNumX][axisNumY + 1] != 1 &&
                        playingField[axisNumX + 1][axisNumY + 1] != 1 &&
                        playingField[axisNumX - 1][axisNumY - 1] != 1) {
                    if (playingField[axisNumX - 1][axisNumY] == -1 ||
                            playingField[axisNumX + 1][axisNumY] == -1 ||
                            playingField[axisNumX][axisNumY - 1] == -1 ||
                            playingField[axisNumX][axisNumY + 1] == -1) {
                        if ((playingField[axisNumX - 1][axisNumY] == -1
                                && playingField[axisNumX - 2][axisNumY] == -1
                                && playingField[axisNumX - 3][axisNumY] == 1) ||
                                (playingField[axisNumX + 1][axisNumY] == -1
                                        && playingField[axisNumX + 2][axisNumY] == -1
                                        && playingField[axisNumX + 3][axisNumY] == 1) ||
                                (playingField[axisNumX][axisNumY - 1] == -1
                                        && playingField[axisNumX][axisNumY - 2] == -1
                                        && playingField[axisNumX][axisNumY - 3] == 1) ||
                                (playingField[axisNumX][axisNumY + 1] == -1
                                        && playingField[axisNumX][axisNumY + 2] == -1
                                        && playingField[axisNumX][axisNumY + 3] == 1)) {
                            System.out.println("Harmed");
                            this.deckCount--;
                            System.out.println();
                            playingField[axisNumX][axisNumY] = -1;
                            this.enemyField[axisNumX][axisNumY] = 1;
                        } else {
                            if (playingField[axisNumX - 2][axisNumY] == -1 ||
                                    playingField[axisNumX + 2][axisNumY] == -1 ||
                                    playingField[axisNumX][axisNumY - 2] == -1 ||
                                    playingField[axisNumX][axisNumY + 2] == -1) {
                                System.out.println("Dead");
                                this.deckCount--;
                                playingField[axisNumX][axisNumY] = -1;
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
                                if ((playingField[axisNumX - 1][axisNumY] == -1
                                        && playingField[axisNumX - 2][axisNumY] == 1) ||
                                        (playingField[axisNumX + 1][axisNumY] == -1
                                                && playingField[axisNumX + 2][axisNumY] == 1) ||
                                        (playingField[axisNumX][axisNumY - 1] == -1
                                                && playingField[axisNumX][axisNumY - 2] == 1) ||
                                        (playingField[axisNumX][axisNumY + 1] == -1
                                                && playingField[axisNumX][axisNumY + 2] == 1)) {
                                    System.out.println("Harmed");
                                    this.deckCount--;
                                    System.out.println();
                                    playingField[axisNumX][axisNumY] = -1;
                                    this.enemyField[axisNumX][axisNumY] = 1;
                                } else {
                                    System.out.println("Dead");
                                    this.deckCount--;
                                    playingField[axisNumX][axisNumY] = -1;
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
                        this.enemyField[axisNumX][axisNumY] = 1;
                        this.enemyField[axisNumX - 1][axisNumY + 1] = -1;
                        this.enemyField[axisNumX + 1][axisNumY] = -1;
                        this.enemyField[axisNumX + 1][axisNumY - 1] = -1;
                        this.enemyField[axisNumX][axisNumY - 1] = -1;
                        this.enemyField[axisNumX][axisNumY + 1] = -1;
                        this.enemyField[axisNumX + 1][axisNumY + 1] = -1;
                        this.enemyField[axisNumX - 1][axisNumY - 1] = -1;
                        this.enemyField[axisNumX - 1][axisNumY] = -1;
                    }
                } else {
                    System.out.println("Harmed");
                    this.deckCount--;
                    System.out.println();
                    playingField[axisNumX][axisNumY] = -1;
                    this.enemyField[axisNumX][axisNumY] = 1;
                }
            } else {
                if (playingField[axisNumX][axisNumY] == 0) {
                    System.out.println("Missed");
                    System.out.println();
                    this.enemyField[axisNumX][axisNumY] = -1;
                }
            }
        }
    }
}
