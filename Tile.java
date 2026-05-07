public class Tile {
    int value;
    char letter;
    int numOf;
    
    //initializes the parameters that will be used
    public Tile(int value, char letter, int numOf) {
        this.letter = letter;
        this.value = value;
        this.numOf = numOf;
    }

    //checks to see if a tile is equal to the current tile
    public boolean equals(Tile a) {
        if (this.letter == a.letter) {
            a.numOf -= 1;
            a.value += value;
            System.out.println(a.numOf);
            return true;
        }
       return false;
    }

    //getters to retrieve the values at that instance
    int getValue() {return value;}
    char getLetter() {return letter;}
}
