package home_work.guess_game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
public class GuessGame {
    private final String SELECT_NUMBER_MESSAGE = "Please Select a Number,\n For stop the game insert 'quit'";
    private final String SELECT_NEW_NUMBER_MESSAGE = "%s ,Please Select a new Number,\n For stop the game insert 'quit'";
    private final String USER_WIN = "You win with: %s tries";
    private final String USER_QUIT = "Thank you for playing";
    private final String HIGH_RESULT = "Too High!!";
    private final String LOW_RESULT = "Too Low!!";


    private final static Random random = new Random();
    private GuessGameBoard results = new GuessGameBoard();

    public void play(int max, String userName) {
        int drawnNumber = random.nextInt(max);
        int numberOfTries = 1;
        int guessNumber = -1;
        String userAnswer = "";

        // Get first answer from user
        userAnswer = JOptionPane.showInputDialog(SELECT_NUMBER_MESSAGE);
        if (userAnswer.matches("-?\\d+")) {
            guessNumber = Integer.parseInt(userAnswer);
        }

        while (guessNumber != drawnNumber && userAnswer.toLowerCase() != "quit"){
            numberOfTries++;
            String message = guessNumber > drawnNumber ? HIGH_RESULT : LOW_RESULT;
            userAnswer = JOptionPane.showInputDialog(String.format(SELECT_NEW_NUMBER_MESSAGE,message));

            if (userAnswer.matches("-?\\d+")) {
                guessNumber = Integer.parseInt(userAnswer);
            }
        }

        if (userAnswer.toLowerCase() == "quit") {
            JOptionPane.showMessageDialog(null, USER_QUIT);
        }else {
            JOptionPane.showMessageDialog(null, String.format(USER_WIN,numberOfTries));
            results.addResult(new Gamer(userName,numberOfTries));
        }
    }

    public void showResults(){
        String message = "\n Results records \n ";
        List<Gamer> results_records = results.GetTopNResult(10);
        message += results_records.stream().map(Gamer::toString).collect(Collectors.joining("\n"));
        JOptionPane.showMessageDialog(null, message);
    }
}
