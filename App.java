import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class App extends JFrame {

   public static Tile randomTile(ArrayList<Tile> alphabet) {
      Random rand = new Random();

      int total = 0;

      for (Tile t : alphabet) {
         total += t.numOf;
      }

      int randomNum = rand.nextInt(total);

      for (Tile t : alphabet) {
         randomNum -= t.numOf;

         if (randomNum < 0) {
            return t;
         }
      }
      return null;
   }
   public static void main(String[] args) throws Exception {
      Scanner in = new Scanner(System.in);
      JFrame mainFrame = new JFrame();

      ArrayList<Tile> alphabet = new ArrayList<>();
      alphabet.add(new Tile(1, 'a', 9));
      alphabet.add(new Tile(3, 'b', 2));
      alphabet.add(new Tile(3, 'c', 2));
      alphabet.add(new Tile(2, 'd', 4));
      alphabet.add(new Tile(1, 'e', 12));
      alphabet.add(new Tile(4, 'f', 2));
      alphabet.add(new Tile(2, 'g', 3));
      alphabet.add(new Tile(4, 'h', 2));
      alphabet.add(new Tile(1, 'i', 9));
      alphabet.add(new Tile(8, 'j', 1));
      alphabet.add(new Tile(5, 'k', 1));
      alphabet.add(new Tile(1, 'l', 4));
      alphabet.add(new Tile(3, 'm', 2));
      alphabet.add(new Tile(1, 'n', 6));
      alphabet.add(new Tile(1, 'o', 8));
      alphabet.add(new Tile(3, 'p', 2));
      alphabet.add(new Tile(10, 'q', 1));
      alphabet.add(new Tile(1, 'r', 6));
      alphabet.add(new Tile(1, 's', 4));
      alphabet.add(new Tile(1, 't', 6));
      alphabet.add(new Tile(1, 'u', 4));
      alphabet.add(new Tile(4, 'v', 2));
      alphabet.add(new Tile(4, 'w', 2));
      alphabet.add(new Tile(8, 'x', 1));
      alphabet.add(new Tile(4, 'y', 2));
      alphabet.add(new Tile(10, 'z', 1));

      Tile chosen = randomTile(alphabet);

      mainFrame.setTitle("SCRABBLE TIME");
      mainFrame.setSize(400, 300);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setLayout(new GridLayout(3, 1, 10, 10)); // (rows, cols, hgap, vgap)
      JPanel topPanel = new JPanel();
      JLabel lbIntro1 = new JLabel("Welcome to Scrabble!");
      JLabel lbIntro2 = new JLabel("Here are 7 letters, gain points based on how many you can fit into a word!");
      topPanel.add(lbIntro1);
      topPanel.add(lbIntro2);
      mainFrame.add(topPanel);
      JPanel centralPanel = new JPanel();
      JTextField guessWord = new JTextField(10);
      centralPanel.add(guessWord);
      mainFrame.add(centralPanel);

      JPanel bottomPanel = new JPanel();
      JButton OkButton = new JButton("OK");
      bottomPanel.add(OkButton);
      mainFrame.add(bottomPanel);

      OkButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           String firstName = guessWord.getText(); // gets the text from the TextField component
           lbIntro1.setText("Hello " + firstName + "!");
           mainFrame.setLayout(new GridLayout(4, 1, 10, 10));
           OkButton.setText("Yes!");
           System.out.print(chosen);
        }
    });


      mainFrame.setVisible(true); // this must be the last statement
   }
}

