public class Movie {
    private final String title;
    private final int year;
    private final String genre;
    private final String director;

    public Movie(String title, int year, String genre, String director) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return title + " (" + year + ") - " + genre + " | Dir: " + director;
    }    
    
}
