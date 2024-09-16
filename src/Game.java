import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public Game(int boardSize) {
        this.player1 = new Player(boardSize);
        this.player2 = new Player(boardSize);
        this.scanner = new Scanner(System.in);
    }

    public void setup() {
        System.out.println("Gracz 1 rozmieszcza statki:");
        setupPlayerShips(player1);

        System.out.println("Gracz 2 rozmieszcza statki:");
        setupPlayerShips(player2);
    }

    private void setupPlayerShips(Player player) {
        int[] shipSizes = {2, 3, 4};
        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                try {
                    System.out.println("Rozmieszczanie statku o wielkości " + size);
                    System.out.print("Podaj współrzędną początkową x: ");
                    int x = scanner.nextInt();
                    System.out.print("Podaj współrzędną początkową y: ");
                    int y = scanner.nextInt();
                    System.out.print("Czy statek ma być poziomy? (true/false): ");
                    boolean horizontal = scanner.nextBoolean();

                    Ship ship = new Ship(size);
                    placed = player.getBoard().placeShip(x, y, ship, horizontal);
                    if (placed) {
                        player.addShip(ship, x, y, horizontal);
                        System.out.println("Statek został rozmieszczony.");
                        player.getBoard().display();
                    } else {
                        System.out.println("Nie udało się rozmieszczanie statku. Spróbuj ponownie.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Niepoprawne dane wejściowe, spróbuj ponownie.");
                    scanner.nextLine();
                }
            }
        }
    }

    public void play() {
        Player currentPlayer = player1;
        Player opponent = player2;

        while (true) {
            System.out.println("Tura gracza: " + (currentPlayer == player1 ? "Gracz 1" : "Gracz 2"));
            opponent.getBoard().display();

            boolean validInput = false;
            int x = -1, y = -1;

            while (!validInput) {
                try {
                    System.out.print("Podaj współrzędne strzału (x y): ");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Niepoprawne dane wejściowe, spróbuj ponownie.");
                    scanner.nextLine();
                }
            }

            boolean hit = opponent.takeShot(x, y);
            if (hit) {
                System.out.println("Trafiony! Gracz ma kolejny ruch.");
            } else {
                System.out.println("Pudło.");
                Player temp = currentPlayer;
                currentPlayer = opponent;
                opponent = temp;
            }

            if (opponent.hasLost()) {
                System.out.println("Gracz " + (currentPlayer == player1 ? "1" : "2") + " wygrał!");
                break;
            }
        }
    }
}
