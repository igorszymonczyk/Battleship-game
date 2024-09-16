public class Ship {
    private int size;
    public int hits;

    public Ship(int size) {
        this.size = size;
        this.hits = 0;
    }

    public void hit() {
        hits++;
        System.out.println("Aktualna liczba trafień: " + hits + " / " + size);
    }

    public boolean isSunk() {
        boolean sunk = hits >= size;
        if (sunk) {
            System.out.println("Statek o rozmiarze " + size + " został zatopiony.");
        }
        return sunk;
    }

    public int getSize() {
        return size;
    }
}
