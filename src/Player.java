import java.util.ArrayList;
import java.util.List;

public class Player {
    private Board board;
    public List<Ship> ships;

    public Player(int boardSize) {
        this.board = new Board(boardSize);
        this.ships = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public void addShip(Ship ship, int x, int y, boolean horizontal) {
        ships.add(ship);  // Dodaj statek do listy
        System.out.println("Statek został dodany.");
    }

    public boolean takeShot(int x, int y) {
        return board.shoot(x, y);
    }

    public boolean hasLost() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
