public class Contestant {
    private final String name;
    private final double score;

    public Contestant(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " - " + score;
    }
}
