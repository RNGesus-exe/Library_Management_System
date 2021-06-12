public class ReturnBook {
    private String issue_date;
    private String book_title;
    private String due_date;
    private String date_of_return;

    public ReturnBook() { }

    public ReturnBook(String issue_date, String book_title, String due_date, String date_of_return) {
        this.issue_date = issue_date;
        this.book_title = book_title;
        this.due_date = due_date;
        this.date_of_return = date_of_return;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getDate_of_return() {
        return date_of_return;
    }

    public void setDate_of_return(String date_of_return) {
        this.date_of_return = date_of_return;
    }
}
