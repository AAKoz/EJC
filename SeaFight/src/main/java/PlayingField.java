import java.util.Random;

public class PlayingField {
    public int[][] playingField = new int[16][16];

    private void Place4DeckShip(int[][] playingField) {
        Random random = new Random();
        int xAxisPosition = 0;
        int yAxisPosition = 0;
        int directionOfShip = 0;

        xAxisPosition = random.nextInt(10) + 3;
        yAxisPosition = random.nextInt(10) + 3;
        directionOfShip = random.nextInt(2);

        switch (directionOfShip) {
            case 0:
                if (xAxisPosition > 6) {
                    for (int i = 0; i < 4; i++) {
                        playingField[xAxisPosition - i][yAxisPosition] = 1;
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        playingField[xAxisPosition + i][yAxisPosition] = 1;
                    }
                }
                break;
            case 1:
                if (yAxisPosition > 6) {
                    for (int i = 0; i < 4; i++) {
                        playingField[xAxisPosition][yAxisPosition - i] = 1;
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        playingField[xAxisPosition][yAxisPosition + i] = 1;
                    }
                }
                break;
        }
    }

    private void Place3DeckShips(int[][] playingField) {
        Random random = new Random();
        int xAxisPosition = 0;
        int yAxisPosition = 0;
        int directionOfShip = 0;
        boolean isFree = false;

        for (int k = 0; k < 2; k++) {
            xAxisPosition = random.nextInt(10) + 3;
            yAxisPosition = random.nextInt(10) + 3;
            directionOfShip = random.nextInt(2);

            while (isFree != true) {
                while (isFree != true) {
                    if (playingField[xAxisPosition][yAxisPosition] == 1 ||
                            playingField[xAxisPosition - 1][yAxisPosition] == 1 ||
                            playingField[xAxisPosition][yAxisPosition - 1] == 1 ||
                            playingField[xAxisPosition + 1][yAxisPosition] == 1 ||
                            playingField[xAxisPosition][yAxisPosition + 1] == 1 ||
                            playingField[xAxisPosition - 1][yAxisPosition - 1] == 1 ||
                            playingField[xAxisPosition - 1][yAxisPosition + 1] == 1 ||
                            playingField[xAxisPosition + 1][yAxisPosition - 1] == 1 ||
                            playingField[xAxisPosition + 1][yAxisPosition + 1] == 1) {
                        xAxisPosition = random.nextInt(10) + 3;
                        yAxisPosition = random.nextInt(10) + 3;
                    } else {
                        isFree = true;
                    }
                }
                isFree = false;

                switch (directionOfShip) {
                    case 0:
                        if (xAxisPosition > 5) {
                            if (playingField[xAxisPosition - 2][yAxisPosition] == 1 ||
                                    playingField[xAxisPosition - 2][yAxisPosition - 1] == 1 ||
                                    playingField[xAxisPosition - 2][yAxisPosition + 1] == 1 ||
                                    playingField[xAxisPosition - 3][yAxisPosition] == 1 ||
                                    playingField[xAxisPosition - 3][yAxisPosition - 1] == 1 ||
                                    playingField[xAxisPosition - 3][yAxisPosition + 1] == 1) {
                                xAxisPosition = random.nextInt(10) + 3;
                                yAxisPosition = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 3; i++) {
                                    playingField[xAxisPosition - i][yAxisPosition] = 1;
                                }
                                isFree = true;
                            }
                        } else {
                            if (playingField[xAxisPosition + 2][yAxisPosition] == 1 ||
                                    playingField[xAxisPosition + 2][yAxisPosition - 1] == 1 ||
                                    playingField[xAxisPosition + 2][yAxisPosition + 1] == 1 ||
                                    playingField[xAxisPosition + 3][yAxisPosition] == 1 ||
                                    playingField[xAxisPosition + 3][yAxisPosition - 1] == 1 ||
                                    playingField[xAxisPosition + 3][yAxisPosition + 1] == 1) {
                                xAxisPosition = random.nextInt(10) + 3;
                                yAxisPosition = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 3; i++) {
                                    playingField[xAxisPosition + i][yAxisPosition] = 1;
                                }
                                isFree = true;
                            }
                        }
                        break;
                    case 1:
                        if (yAxisPosition > 5) {
                            if (playingField[xAxisPosition][yAxisPosition - 2] == 1 ||
                                    playingField[xAxisPosition - 1][yAxisPosition - 2] == 1 ||
                                    playingField[xAxisPosition + 1][yAxisPosition - 2] == 1 ||
                                    playingField[xAxisPosition][yAxisPosition - 3] == 1 ||
                                    playingField[xAxisPosition - 1][yAxisPosition - 3] == 1 ||
                                    playingField[xAxisPosition + 1][yAxisPosition - 3] == 1) {
                                xAxisPosition = random.nextInt(10) + 3;
                                yAxisPosition = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 3; i++) {
                                    playingField[xAxisPosition][yAxisPosition - i] = 1;
                                }
                                isFree = true;
                            }
                        } else {
                            if (playingField[xAxisPosition][yAxisPosition + 2] == 1 ||
                                    playingField[xAxisPosition - 1][yAxisPosition + 2] == 1 ||
                                    playingField[xAxisPosition + 1][yAxisPosition + 2] == 1 ||
                                    playingField[xAxisPosition][yAxisPosition + 3] == 1 ||
                                    playingField[xAxisPosition - 1][yAxisPosition + 3] == 1 ||
                                    playingField[xAxisPosition + 1][yAxisPosition + 3] == 1) {
                                xAxisPosition = random.nextInt(10) + 3;
                                yAxisPosition = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 3; i++) {
                                    playingField[xAxisPosition][yAxisPosition + i] = 1;
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

    private void Place2DeckShips(int[][] playingField) {
        Random random = new Random();
        int xAxisPosition = 0;
        int yAxisPosition = 0;
        int directionOfShip = 0;
        boolean isFree = false;

        for (int k = 0; k < 3; k++) {
            xAxisPosition = random.nextInt(10) + 3;
            yAxisPosition = random.nextInt(10) + 3;
            directionOfShip = random.nextInt(2);

            while (isFree != true) {
                while (isFree != true) {
                    if (playingField[xAxisPosition][yAxisPosition] == 1 ||
                            playingField[xAxisPosition - 1][yAxisPosition] == 1 ||
                            playingField[xAxisPosition][yAxisPosition - 1] == 1 ||
                            playingField[xAxisPosition + 1][yAxisPosition] == 1 ||
                            playingField[xAxisPosition][yAxisPosition + 1] == 1 ||
                            playingField[xAxisPosition - 1][yAxisPosition - 1] == 1 ||
                            playingField[xAxisPosition - 1][yAxisPosition + 1] == 1 ||
                            playingField[xAxisPosition + 1][yAxisPosition - 1] == 1 ||
                            playingField[xAxisPosition + 1][yAxisPosition + 1] == 1) {
                        xAxisPosition = random.nextInt(10) + 3;
                        yAxisPosition = random.nextInt(10) + 3;
                    } else {
                        isFree = true;
                    }
                }
                isFree = false;
                switch (directionOfShip) {
                    case 0:
                        if (xAxisPosition > 4) {
                            if (playingField[xAxisPosition - 2][yAxisPosition] == 1 ||
                                    playingField[xAxisPosition - 2][yAxisPosition - 1] == 1 ||
                                    playingField[xAxisPosition - 2][yAxisPosition + 1] == 1) {
                                xAxisPosition = random.nextInt(10) + 3;
                                yAxisPosition = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 2; i++) {
                                    playingField[xAxisPosition - i][yAxisPosition] = 1;
                                }
                                isFree = true;
                            }
                        } else {
                            if (playingField[xAxisPosition + 2][yAxisPosition] == 1 ||
                                    playingField[xAxisPosition + 2][yAxisPosition - 1] == 1 ||
                                    playingField[xAxisPosition + 2][yAxisPosition + 1] == 1) {
                                xAxisPosition = random.nextInt(10) + 3;
                                yAxisPosition = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 2; i++) {
                                    playingField[xAxisPosition + i][yAxisPosition] = 1;
                                }
                                isFree = true;
                            }
                        }
                        break;
                    case 1:
                        if (yAxisPosition > 4) {
                            if (playingField[xAxisPosition][yAxisPosition - 2] == 1 ||
                                    playingField[xAxisPosition - 1][yAxisPosition - 2] == 1 ||
                                    playingField[xAxisPosition + 1][yAxisPosition - 2] == 1) {
                                xAxisPosition = random.nextInt(10) + 3;
                                yAxisPosition = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 2; i++) {
                                    playingField[xAxisPosition][yAxisPosition - i] = 1;
                                }
                                isFree = true;
                            }
                        } else {
                            if (playingField[xAxisPosition][yAxisPosition + 2] == 1 ||
                                    playingField[xAxisPosition - 1][yAxisPosition + 2] == 1 ||
                                    playingField[xAxisPosition + 1][yAxisPosition + 2] == 1) {
                                xAxisPosition = random.nextInt(10) + 3;
                                yAxisPosition = random.nextInt(10) + 3;
                            } else {
                                for (int i = 0; i < 2; i++) {
                                    playingField[xAxisPosition][yAxisPosition + i] = 1;
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

    public void Place1DeckShips(int[][] playingField) {
        Random random = new Random();
        int xAxisPosition = 0;
        int yAxisPosition = 0;
        boolean isFree = false;

        for (int k = 0; k < 4; k++) {
            xAxisPosition = random.nextInt(10) + 3;
            yAxisPosition = random.nextInt(10) + 3;

            while (isFree != true) {
                if (playingField[xAxisPosition][yAxisPosition] == 1 ||
                        playingField[xAxisPosition - 1][yAxisPosition] == 1 ||
                        playingField[xAxisPosition][yAxisPosition - 1] == 1 ||
                        playingField[xAxisPosition + 1][yAxisPosition] == 1 ||
                        playingField[xAxisPosition][yAxisPosition + 1] == 1 ||
                        playingField[xAxisPosition - 1][yAxisPosition - 1] == 1 ||
                        playingField[xAxisPosition - 1][yAxisPosition + 1] == 1 ||
                        playingField[xAxisPosition + 1][yAxisPosition - 1] == 1 ||
                        playingField[xAxisPosition + 1][yAxisPosition + 1] == 1) {
                    xAxisPosition = random.nextInt(10) + 3;
                    yAxisPosition = random.nextInt(10) + 3;
                } else {
                    isFree = true;
                }
            }
            playingField[xAxisPosition][yAxisPosition] = 1;
            isFree = false;
        }
    }

    public void PlaceEnemyShips() {
        Place4DeckShip(this.playingField);
        Place3DeckShips(this.playingField);
        Place2DeckShips(this.playingField);
        Place1DeckShips(this.playingField);
    }
}
