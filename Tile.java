public class Tile {
    char letter;
    int points;
    int amount;

    public Tile(char letter, int points, int amount) {
        this.letter = letter;
        this.points = points;
        this.amount = amount;
    }

    public void setAmount() {
        this.amount = this.amount - 1;
    }

    int getPoints() {return points;}
    char getLetter() {return letter;}
    int getAmount() {return amount;}

}
