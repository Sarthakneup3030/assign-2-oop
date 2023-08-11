public class Movie {
    private String title;
    private String releaseDate;
    private String overview;

    public Movie(String title, String releaseDate, String overview) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nRelease Date: " + releaseDate +
                "\nOverview: " + overview;
    }
}
