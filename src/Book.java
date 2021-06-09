public class Book {

    private int book_id;
    private String title;
    private String author;
    private int noOfPages;
    private int noOfCopies;
    private String genre;
    private float rating;
    private String dateOfRelease;

    public Book(int book_id,int noOfCopies,String title, String author, int noOfPages, String genre, float rating, String dateOfRelease) {
        this.title = title;
        this.author = author;
        this.noOfPages = noOfPages;
        this.genre = genre;
        this.rating = rating;
        this.dateOfRelease = dateOfRelease;
        this.book_id = book_id;
        this.noOfCopies = noOfCopies;
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

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }
}
