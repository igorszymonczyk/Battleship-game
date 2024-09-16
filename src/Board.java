public class Board {
    private Object[][] board;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.board = new Object[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '~';
            }
        }
    }

    public boolean placeShip(int x, int y, Ship ship, boolean horizontal) {
        int shipSize = ship.getSize();

        if (horizontal) {
            if (y + shipSize > size) return false;
            for (int i = 0; i < shipSize; i++) {
                if (!(board[x][y + i] instanceof Character) || (char) board[x][y + i] != '~') {
                    System.out.println("Space occupied at (" + x + ", " + (y + i) + ")");
                    return false;
                }
            }
            for (int i = 0; i < shipSize; i++) {
                board[x][y + i] = ship;
            }
        } else { // Vertical placement
            if (x + shipSize > size) return false;
            for (int i = 0; i < shipSize; i++) {
                if (!(board[x + i][y] instanceof Character) || (char) board[x + i][y] != '~') {
                    System.out.println("Space occupied at (" + (x + i) + ", " + y + ")");
                    return false;
                }
            }
            // Place the ship
            for (int i = 0; i < shipSize; i++) {
                board[x + i][y] = ship;
            }
        }
        System.out.println("Placing ship at (" + x + ", " + y + "), horizontal: " + horizontal);

        display();

        return true;
    }

    public boolean shoot(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            System.out.println("Strzał poza planszę!");
            return false;
        }

        if (board[x][y] instanceof Ship) {
            Ship hitShip = (Ship) board[x][y];
            hitShip.hit();
            board[x][y] = 'X';
            return true;
        } else if (board[x][y] instanceof Character && (char) board[x][y] == '~') {
            board[x][y] = 'O';
            return false;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] instanceof Ship) {
                    System.out.print('S' + " ");
                } else if (board[i][j] instanceof Character) {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
