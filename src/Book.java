public class Book {

    String title;
    String author;
    int noOfPages;
    String genre;
    float rating;
    String dateOfRelease;

    public Book(String title, String author, int noOfPages, String genre, float rating, String dateOfRelease) {
        this.title = title;
        this.author = author;
        this.noOfPages = noOfPages;
        this.genre = genre;
        this.rating = rating;
        this.dateOfRelease = dateOfRelease;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}
