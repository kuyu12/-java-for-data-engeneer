package home_work.guess_game;
import java.util.List;

public interface GameBoard {
    void addResult(Gamer gamer);
    List<Gamer> GetTopNResult(int n);
}
