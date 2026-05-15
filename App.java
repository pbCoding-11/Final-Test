/**
 * CIS 254 FINAL
 * Description: A program that is able to run the game Scrabble as single player, 
 * giving the user a chance to input 
 * 
 * @author Patrick Bowlus
 * @since 4/28/2026
 */
import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

public class App {

    static int totalPoints = 0;
    static int lengthOfSet = 7;

    /**
     * Method to generate Frame in organized and coherent fashion 
     * (I did not like the way it was before)
     * @return Frame ready to be opened within main
     */
    public static JFrame box() {
        //creates the Frame, and designs it
        JFrame theBigOne = new JFrame("SCRABBLE");
        theBigOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        theBigOne.setSize(700, 300);
        theBigOne.setLayout(new GridLayout(5, 1, 10, 10));
        theBigOne.setBackground(Color.BLUE);

        //creates and adds the panels
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();
        JPanel panelFour = new JPanel();
        JPanel panelFive = new JPanel();

        theBigOne.add(panelOne);
        theBigOne.add(panelTwo);
        theBigOne.add(panelThree);
        theBigOne.add(panelFour);
        theBigOne.add(panelFive);

        //creates and adds textfield labels
        JLabel gameOutput = new JLabel("Welcome! You will receive 5 letters; build a word to earn points!");
        JLabel letterSet = new JLabel("");
        JTextField theGuess = new JTextField(10);
        JLabel score = new JLabel("Current Score: " + totalPoints);

        panelOne.add(gameOutput);
        panelTwo.add(letterSet);
        panelThree.add(theGuess);
        panelFour.add(score);

        return theBigOne;
    }

    /**Creates random set of letters to be given to the player 
     * @param alphabet is used to ensure they are letters of the alphabet with their own values, count
     * @return a random set for use
    */
    public static ArrayList<Tile> getRandomTiles(ArrayList<Tile> alphabet) {
        Random rand = new Random();
        ArrayList<Tile> randomSet = new ArrayList<>();

            int[] vowels = {0, 4, 8, 14, 20};
            int randomVowel = rand.nextInt(vowels.length);

            randomSet.add(alphabet.get(vowels[randomVowel]));

            while (randomSet.size() < lengthOfSet) {
                int randomGrab = rand.nextInt(alphabet.size());
                randomSet.add(alphabet.get(randomGrab));
            }

        System.out.println("Random Set Size: " + randomSet.size());

        return randomSet;
    }

    /**
     * Used to compare letters in a user's input with the set of tiles given
     * @param givenSet,userWord used as references when 
     * @return boolean factz
     */
    public static boolean compareLetters(ArrayList<Tile> givenSet, char[] userWord) {
        int count = 0;
        boolean factz = false;

        for (Tile j : givenSet) {
            for (char c : userWord) {
                if (c == j.getLetter()) {
                    count++;
                }
            }
        }
        if (count >= userWord.length) {
            factz = true;
        }
        return factz;
    }

    /**
     * updates the amount or count of times a tile is still available for use
     * @param alphabet removes a count of Tile from alphabet list
     * @param givenSet checks to make sure proper letters are removed
     * @param userWord references with givenSet to ensure validity
     * @return alphabet size so that there is no exceptions being made
     */
    public static int updateAmounts(ArrayList<Tile> alphabet, ArrayList<Tile> givenSet, char[] userWord) {
        for (char c : userWord) {
            for (Tile j : givenSet) {
                if (c == j.getLetter()) {
                    j.setAmount();
                }
                if (j.getAmount() == 0) {
                    alphabet.remove(j);
                }
            }
        }
        return alphabet.size();
    }

    /**
     * Creates the point system where players earn points for their words
     * @param givenSet references with
     * @param userWord to make sure proper points are received depending on the letter
     * @return int of gained points which is added to total points
     */
    public static int receivePoints(ArrayList<Tile> givenSet, char[] userWord) {
        int gainedPoints = 0;
        for (char c : userWord) {
            int onlyOne = 0;
            for (Tile j : givenSet) {
                if (c == j.getLetter() && onlyOne < 1) {
                    onlyOne++;
                    gainedPoints += j.getPoints();
                }
            }
        }
        return gainedPoints;
    }

    /**
     * Updates tile to remove used tiles and prepare/insert new ones. Similar to getRandomTiles, but doesn't need to
     * @return anythin
     * @param alphabet List where new random tiles are grabbed
     * @param givenSet Given list of letters that are changed after submission and success of creating a word
     * @param userWord The user's word itself, being used as cross-reference for proper updating
     */
    public static void updateTiles(ArrayList<Tile> alphabet, ArrayList<Tile> givenSet, char[] userWord) {
        for (char c : userWord) {
            for (int i = 0; i < givenSet.size(); i++) {
                if (c == givenSet.get(i).getLetter()) {
                    givenSet.remove(i);
                    break;
                }
            }
        }
        Random rand = new Random();

        while (givenSet.size() < lengthOfSet) {
            int randomGrab = rand.nextInt(alphabet.size());
            givenSet.add(alphabet.get(randomGrab));
        }
    }

    /**
     * Main function that initializes the alphabet ArrayList, and
     * is the executing portion of the frame.
     * ActionListener adheres to a click protocol and step-by-step function to call other functions.
     */
    public static void main(String args[]) {

        ArrayList<Tile> alphabet = new ArrayList<>();
        alphabet.add(new Tile('a', 1, 9));
        alphabet.add(new Tile('b', 3, 2));
        alphabet.add(new Tile('c', 3, 2));
        alphabet.add(new Tile('d', 2, 4));
        alphabet.add(new Tile('e', 1, 12));
        alphabet.add(new Tile('f', 4, 2));
        alphabet.add(new Tile('g', 2, 3));
        alphabet.add(new Tile('h', 4, 2));
        alphabet.add(new Tile('i', 1, 9));
        alphabet.add(new Tile('j', 8, 1));
        alphabet.add(new Tile('k', 5, 1));
        alphabet.add(new Tile('l', 1, 4));
        alphabet.add(new Tile('m', 3, 2));
        alphabet.add(new Tile('n', 1, 6));
        alphabet.add(new Tile('o', 1, 8));
        alphabet.add(new Tile('p', 3, 2));
        alphabet.add(new Tile('q', 10, 1));
        alphabet.add(new Tile('r', 1, 6));
        alphabet.add(new Tile('s', 1, 4));
        alphabet.add(new Tile('t', 1, 6));
        alphabet.add(new Tile('u', 1, 4));
        alphabet.add(new Tile('v', 4, 2));
        alphabet.add(new Tile('w', 4, 2));
        alphabet.add(new Tile('x', 8, 1));
        alphabet.add(new Tile('y', 4, 2));
        alphabet.add(new Tile('z', 10, 1));



        //create widget
        SwingUtilities.invokeLater(() -> {
            JFrame theBigOne = box();
            
            JButton click = new JButton("Enter");

            JPanel addButton = (JPanel) theBigOne.getContentPane().getComponent(4);
            addButton.add(click);

            ArrayList<Tile> givenSet = getRandomTiles(alphabet);

            //sets the given set of tiles to be shown in "letterSet" label
            StringBuilder showSet = new StringBuilder();
            for(int i = 0; i < givenSet.size(); i++){
                showSet.append(givenSet.get(i).getLetter() + " ");
            }
            JPanel addSet = (JPanel) theBigOne.getContentPane().getComponent(1);
            JLabel addingSet = (JLabel) addSet.getComponent(0);
            addingSet.setText(showSet.toString());

            JPanel panelOne = (JPanel) theBigOne.getContentPane().getComponent(0);
            JLabel updateOutput = (JLabel) panelOne.getComponent(0);

            JPanel panelThree = (JPanel) theBigOne.getContentPane().getComponent(2);
            JTextField getInput = (JTextField) panelThree.getComponent(0);

            //What happens when the user clicks "Enter"
            click.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    //gets text and turns into string
                    String input = getInput.getText();
                    char[] inputAsList = new char[input.length()]; //changes string to char[] list
                    if (inputAsList.length == 0) {
                        updateOutput.setText("Please enter a word");
                    }
                    else {
                        for (int i = 0; i < inputAsList.length; i++) { //puts letters into char[] list
                            inputAsList[i] = input.charAt(i);
                        }
                        boolean winner = compareLetters(givenSet, inputAsList);
                        if (winner == true) { //if you win, call functions updateAmount and updateTiles
                            updateOutput.setText("Congrats! you've earned points!");
                            totalPoints += receivePoints(givenSet, inputAsList);
                            updateAmounts(alphabet, givenSet, inputAsList);
                            updateTiles(alphabet, givenSet, inputAsList);
                            if (alphabet.size() == 0) {
                                JFrame winFrame = new JFrame("The Winner!");
                                winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                winFrame.setSize(200, 100);
                                winFrame.setLayout(new GridLayout(1, 1));
                                winFrame.setBackground(Color.PINK);

                                JPanel winPanel = new JPanel();

                                JLabel winningMsg = new JLabel("Congrats! You win!");

                                winFrame.add(winPanel);
                                winPanel.add(winningMsg);

                                showSet.setLength(0);
                            }
                            //resets/refreshes the set and updates Frame with new information
                            JPanel panelFour = (JPanel) theBigOne.getContentPane().getComponent(3);
                            JLabel updatedPoints = (JLabel) panelFour.getComponent(0);
                            System.out.print("Total Points: " + totalPoints);
                            updatedPoints.setText("Current Score: " + totalPoints);
                            showSet.setLength(0);
                            for(int i = 0; i < givenSet.size(); i++){
                                showSet.append(givenSet.get(i).getLetter() + " ");
                            }
                            addingSet.setText(showSet.toString());

                            theBigOne.getContentPane().revalidate();;
                        } 
                        else {
                            updateOutput.setText("Sorry, your word uses a letter not in the set :(");
                        }
                    }
                }
            }); 


            theBigOne.setVisible(true); //must be last statement
        });
    }
}
