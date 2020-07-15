package home_work.guess_game;

import javax.swing.*;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        String[] buttons = { "Start Game", "Result board", "Quit"};

        String userName = JOptionPane.showInputDialog("Please enter your name");
        while(true){
            int returnValue = JOptionPane.showOptionDialog(null, "Welcome "+userName, "GuessGame",
                    JOptionPane.WARNING_MESSAGE, 1, null, buttons, buttons[0]);

            if(returnValue == 0){
                game.play(100,userName);
            }

            if(returnValue == 1){
                game.showResults();
            }

            if(returnValue == 2){
                break;
            }
        }
    }
}
