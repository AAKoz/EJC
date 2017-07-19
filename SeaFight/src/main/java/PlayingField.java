import java.util.Random;

public class PlayingField {
    public int[][] playingField = new int[16][16];

    /**
     * Places one 4-deck ship on playing field in random position and direction.
     *
     * @param playingField playing field where ships are placing
     */
    private void place4DeckShip(int[][] playingField) {
        Random random = new Random();
        int axisPositionX = 0;
        int axisPositionY = 0;
        int directionOfShip = 0;

        axisPositionX = random.nextInt(10) + 3;
        axisPositionY = random.nextInt(10) + 3;
        directionOfShip = random.nextInt(2);

        switch (directionOfShip) {
            case 0:
                if (axisPositionX > 6) {
                    for (int i = 0; i < 4; i++) {
                        playingField[axisPositionX - i][axisPositionY] = 1;
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        playingField[axisPositionX + i][axisPositionY] = 1;
                    }
                }
                break;
            case 1:
                if (axisPositionY > 6) {
                    for (int i = 0; i < 4; i++) {
                        playingField[axisPositionX][axisPositionY - i] = 1;
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        playingField[axisPositionX][axisPositionY + i] = 1;
                    }
                }
                break;
        }
    }

    /**
     * Places two 3-deck ships on playing field in random position and direction.
     *
     * @param playingField playing field where ships are placing
     */
    private void place3DeckShips(int[][] playingField) {
        Random random = new Random();
        int axisPositionX = 0;
        int axisPositionY = 0;
        int directionOfShip = 0;
        boolean isFree = false;

        for (int k = 0; k < 2; k++) {
            axisPositionX = random.nextInt(10) + 3;
            axisPositionY = random.nextInt(10) + 3;
            directionOfShip = random.nextInt(2);

            while (!isFree) {
                while (!isFree) {
                    if (playingField[axisPositionX][axisPositionY] == 1 ||
                            playingField[axisPositionX - 1][axisPositionY] == 1 ||
                            playingField[axisPositionX][axisPositionY - 1] == 1 ||
                            playingField[axisPositionX + 1][axisPositionY] == 1 ||
                            playingField[axisPositionX][axisPositionY + 1] == 1 ||
                            playingField[axisPositionX - 1][axisPositionY - 1] == 1 ||
                            playingField[axisPositionX - 1][axisPositionY + 1] == 1 ||
                            playingField[axisPositionX + 1][axisPositionY - 1] == 1 ||
                            playingField[axisPositionX + 1][axisPositionY + 1] == 1) {
                        axisPositionX = random.nextInt(10) + 3;
                        axisPositionY = random.nextInt(10) + 3;
                    } else {
                        isFree = true;
                    }
                }
                isFree = false;

                switch (directionOfShip) {
                    case 0:
                        if (axisPositionX > 5) {
                            if (playingField[axisPositionX - 2][axisPositionY] == 1 ||
                                    playingField[axisPositionX - 2][axisPositionY - 1] == 1 ||
                                    playingField[axisPositionX - 2][axisPositionY + 1] == 1 ||
                                    playingField[axisPositionX - 3][axisPositionY] == 1 ||
                                    playingField[axisPositionX - 3][axisPositionY - 1] == 1 ||
                                    playingField[axisPositionX - 3][axisPositionY + 1] == 1) {
                                axisPositionX = random.nextInt(10) + 3;
                                axisPositionY = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 3; i++) {
                                    playingField[axisPositionX - i][axisPositionY] = 1;
                                }
                                isFree = true;
                            }
                        } else {
                            if (playingField[axisPositionX + 2][axisPositionY] == 1 ||
                                    playingField[axisPositionX + 2][axisPositionY - 1] == 1 ||
                                    playingField[axisPositionX + 2][axisPositionY + 1] == 1 ||
                                    playingField[axisPositionX + 3][axisPositionY] == 1 ||
                                    playingField[axisPositionX + 3][axisPositionY - 1] == 1 ||
                                    playingField[axisPositionX + 3][axisPositionY + 1] == 1) {
                                axisPositionX = random.nextInt(10) + 3;
                                axisPositionY = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 3; i++) {
                                    playingField[axisPositionX + i][axisPositionY] = 1;
                                }
                                isFree = true;
                            }
                        }
                        break;
                    case 1:
                        if (axisPositionY > 5) {
                            if (playingField[axisPositionX][axisPositionY - 2] == 1 ||
                                    playingField[axisPositionX - 1][axisPositionY - 2] == 1 ||
                                    playingField[axisPositionX + 1][axisPositionY - 2] == 1 ||
                                    playingField[axisPositionX][axisPositionY - 3] == 1 ||
                                    playingField[axisPositionX - 1][axisPositionY - 3] == 1 ||
                                    playingField[axisPositionX + 1][axisPositionY - 3] == 1) {
                                axisPositionX = random.nextInt(10) + 3;
                                axisPositionY = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 3; i++) {
                                    playingField[axisPositionX][axisPositionY - i] = 1;
                                }
                                isFree = true;
                            }
                        } else {
                            if (playingField[axisPositionX][axisPositionY + 2] == 1 ||
                                    playingField[axisPositionX - 1][axisPositionY + 2] == 1 ||
                                    playingField[axisPositionX + 1][axisPositionY + 2] == 1 ||
                                    playingField[axisPositionX][axisPositionY + 3] == 1 ||
                                    playingField[axisPositionX - 1][axisPositionY + 3] == 1 ||
                                    playingField[axisPositionX + 1][axisPositionY + 3] == 1) {
                                axisPositionX = random.nextInt(10) + 3;
                                axisPositionY = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 3; i++) {
                                    playingField[axisPositionX][axisPositionY + i] = 1;
                                }
                                isFree = true;
                            }
                        }
                        break;
                }
            }
            isFree = false;
        }
    }

    /**
     * Places three 2-deck ships on playing field in random position and direction.
     *
     * @param playingField playing field where ships are placing
     */
    private void place2DeckShips(int[][] playingField) {
        Random random = new Random();
        int axisPositionX = 0;
        int axisPositionY = 0;
        int directionOfShip = 0;
        boolean isFree = false;

        for (int k = 0; k < 3; k++) {
            axisPositionX = random.nextInt(10) + 3;
            axisPositionY = random.nextInt(10) + 3;
            directionOfShip = random.nextInt(2);

            while (!isFree) {
                while (!isFree) {
                    if (playingField[axisPositionX][axisPositionY] == 1 ||
                            playingField[axisPositionX - 1][axisPositionY] == 1 ||
                            playingField[axisPositionX][axisPositionY - 1] == 1 ||
                            playingField[axisPositionX + 1][axisPositionY] == 1 ||
                            playingField[axisPositionX][axisPositionY + 1] == 1 ||
                            playingField[axisPositionX - 1][axisPositionY - 1] == 1 ||
                            playingField[axisPositionX - 1][axisPositionY + 1] == 1 ||
                            playingField[axisPositionX + 1][axisPositionY - 1] == 1 ||
                            playingField[axisPositionX + 1][axisPositionY + 1] == 1) {
                        axisPositionX = random.nextInt(10) + 3;
                        axisPositionY = random.nextInt(10) + 3;
                    } else {
                        isFree = true;
                    }
                }
                isFree = false;
                switch (directionOfShip) {
                    case 0:
                        if (axisPositionX > 4) {
                            if (playingField[axisPositionX - 2][axisPositionY] == 1 ||
                                    playingField[axisPositionX - 2][axisPositionY - 1] == 1 ||
                                    playingField[axisPositionX - 2][axisPositionY + 1] == 1) {
                                axisPositionX = random.nextInt(10) + 3;
                                axisPositionY = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 2; i++) {
                                    playingField[axisPositionX - i][axisPositionY] = 1;
                                }
                                isFree = true;
                            }
                        } else {
                            if (playingField[axisPositionX + 2][axisPositionY] == 1 ||
                                    playingField[axisPositionX + 2][axisPositionY - 1] == 1 ||
                                    playingField[axisPositionX + 2][axisPositionY + 1] == 1) {
                                axisPositionX = random.nextInt(10) + 3;
                                axisPositionY = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 2; i++) {
                                    playingField[axisPositionX + i][axisPositionY] = 1;
                                }
                                isFree = true;
                            }
                        }
                        break;
                    case 1:
                        if (axisPositionY > 4) {
                            if (playingField[axisPositionX][axisPositionY - 2] == 1 ||
                                    playingField[axisPositionX - 1][axisPositionY - 2] == 1 ||
                                    playingField[axisPositionX + 1][axisPositionY - 2] == 1) {
                                axisPositionX = random.nextInt(10) + 3;
                                axisPositionY = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 2; i++) {
                                    playingField[axisPositionX][axisPositionY - i] = 1;
                                }
                                isFree = true;
                            }
                        } else {
                            if (playingField[axisPositionX][axisPositionY + 2] == 1 ||
                                    playingField[axisPositionX - 1][axisPositionY + 2] == 1 ||
                                    playingField[axisPositionX + 1][axisPositionY + 2] == 1) {
                                axisPositionX = random.nextInt(10) + 3;
                                axisPositionY = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 2; i++) {
                                    playingField[axisPositionX][axisPositionY + i] = 1;
                                }
                                isFree = true;
                            }
                        }
                        break;
                }
            }
            isFree = false;
        }
    }

    /**
     * Places four 1-deck ships on playing field in random position and direction.
     *
     * @param playingField playing field where ships are placing
     */
    public void place1DeckShips(int[][] playingField) {
        Random random = new Random();
        int axisPositionX = 0;
        int axisPositionY = 0;
        boolean isFree = false;

        for (int k = 0; k < 4; k++) {
            axisPositionX = random.nextInt(10) + 3;
            axisPositionY = random.nextInt(10) + 3;

            while (!isFree) {
                if (playingField[axisPositionX][axisPositionY] == 1 ||
                        playingField[axisPositionX - 1][axisPositionY] == 1 ||
                        playingField[axisPositionX][axisPositionY - 1] == 1 ||
                        playingField[axisPositionX + 1][axisPositionY] == 1 ||
                        playingField[axisPositionX][axisPositionY + 1] == 1 ||
                        playingField[axisPositionX - 1][axisPositionY - 1] == 1 ||
                        playingField[axisPositionX - 1][axisPositionY + 1] == 1 ||
                        playingField[axisPositionX + 1][axisPositionY - 1] == 1 ||
                        playingField[axisPositionX + 1][axisPositionY + 1] == 1) {
                    axisPositionX = random.nextInt(10) + 3;
                    axisPositionY = random.nextInt(10) + 3;
                } else {
                    isFree = true;
                }
            }
            playingField[axisPositionX][axisPositionY] = 1;
            isFree = false;
        }
    }

    /**
     * Places all ships on playing field
     */
    public void placeEnemyShips() {
        place4DeckShip(this.playingField);
        place3DeckShips(this.playingField);
        place2DeckShips(this.playingField);
        place1DeckShips(this.playingField);
    }
}
