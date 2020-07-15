package home_work.guess_game;

/**
 * @author Evgeny Borisov
 */
public class Gamer {
    private String name;
    private Integer result;

    public Gamer(String name,int result){
        this.name = name;
        this.result = result;
    }

    public Integer getResult() {
        return result;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name=" + name + ", result=" + result;
    }
}
