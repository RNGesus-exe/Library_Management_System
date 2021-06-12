public class IssueBook {
    private String issue_date;
    private String book_title;
    private String due_date;

    public IssueBook() { }

    public IssueBook(String issue_date, String book_title, String due_date) {
        this.issue_date = issue_date;
        this.book_title = book_title;
        this.due_date = due_date;
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
}
