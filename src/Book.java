public class Book {

    private int book_id;
    private String title;
    private String author;
    private int noOfCopies;
    private String genre;
    private float rating;
    private String dateOfRelease;

    public Book() { }

    public Book(int book_id, int noOfCopies, String title, String author, String genre, float rating, String dateOfRelease) {
        this.title = title;
        this.author = author;
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

    public Object[] getBookObject(){
        Object[] bookInfo = {title,author,genre,rating,noOfCopies,dateOfRelease};
        return bookInfo;
    }
    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", noOfCopies=" + noOfCopies +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", dateOfRelease='" + dateOfRelease + '\'' +
                '}';
    }
}
