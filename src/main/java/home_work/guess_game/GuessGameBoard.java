package home_work.guess_game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GuessGameBoard implements GameBoard{
    private List<Gamer> results = new ArrayList<>();

    @Override
    public void addResult(Gamer gamer) {
        results.add(gamer);
        results.sort(Comparator.comparing(Gamer::getResult));
    }

    @Override
    public List<Gamer> GetTopNResult(int n) {
        if (results.size() <= n) {
            return results;
        }
        return results.subList(0,n);
    }
}
