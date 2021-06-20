import javax.swing.*;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DatabaseManager(Connection connection) {
        this.connection = connection;
    }

    public void createTables() {
        try {
            Statement statement = connection.createStatement();
            //Users Table
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS Users (user_id INT PRIMARY KEY AUTO_INCREMENT,
                                        first_name VARCHAR(20) NOT NULL
                                       ,last_name VARCHAR(20) NOT NULL
                                       ,password VARCHAR(30) NOT NULL
                                       ,dateTime TIMESTAMP default current_timestamp
                                       ,cnic VARCHAR(14)\t  UNIQUE NOT NULL
                                       ,address VARCHAR(255)  NOT NULL
                                       ,username VARCHAR(30) UNIQUE NOT NULL
                                       ,phoneNumber VARCHAR(12) NOT NULL
                                       ,securityQuestion INT NOT NULL
                                       ,securityAnswer VARCHAR(30) NOT NULL);""");
            //Books Table
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS Books (book_id INT PRIMARY KEY AUTO_INCREMENT,
                                        book_title VARCHAR(255) NOT NULL
                                       ,book_author VARCHAR(255) NOT NULL
                                       ,book_genre VARCHAR(20) NOT NULL
                                       ,book_copies_sold VARCHAR(20)
                                       ,book_rating FLOAT
                                       ,book_release_year INT);""");
            //Levels Table
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS Levels (level_id INT PRIMARY KEY AUTO_INCREMENT,
                                        user_id INT NOT NULL
                                       ,level_experience TINYINT NOT NULL
                                       ,level_status TINYINT AS (level_experience / 2)
                                       ,book_issue_limit SMALLINT AS (level_experience * 2)
                                       ,FOREIGN KEY (user_id) REFERENCES Users(user_id));""");
            //IssuedBook Table
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS IssuedBook (borrow_id INT PRIMARY KEY AUTO_INCREMENT,
                                                              user_id INT
                                                              ,book_id INT
                                                              ,issue_time DATETIME UNIQUE DEFAULT NOW()
                                                              ,due_time DATETIME generated always as (issue_time + interval 7 day) stored
                                                              ,FOREIGN KEY(user_id) REFERENCES Users(user_id)
                                                              ,FOREIGN KEY(book_id) REFERENCES Books(book_id));""");
            //ReturnedBook Table
            statement.execute("""
                            CREATE TABLE IF NOT EXISTS ReturnedBook (return_id INT PRIMARY KEY AUTO_INCREMENT,
                                                                 borrow_id INT
                                                                ,returned_time timestamp default current_timestamp
                                                                ,FOREIGN KEY(borrow_id) REFERENCES IssuedBook(borrow_id));""");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean recoverPassword(String username, int securityQuestion, String answer){
        String query = "SELECT * " +
                "FROM Users " +
                "WHERE username = ? AND securityQuestion = ? AND securityAnswer = ?;";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1, username);
            ppStatement.setInt(2,securityQuestion);
            ppStatement.setString(3,answer);
            ResultSet rs = ppStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeUser(int user_id) throws SQLException {
        String query = """
                DELETE FROM Users
                WHERE Users.user_id = ?;
                """;
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(1, user_id);
        ppStatement.executeUpdate();
    }

    public void updateUser(int user_id,String first_name,String last_name,String mobileNumber,String address) throws SQLException {
        String query = "UPDATE Users " +
                "SET first_name = ?, last_name = ?,phoneNumber = ?,address = ? " +
                "WHERE user_id = ?";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(5, user_id);
        ppStatement.setString(1,first_name);
        ppStatement.setString(2, last_name);
        ppStatement.setString(3,mobileNumber);
        ppStatement.setString(4, address);
        ppStatement.executeUpdate();
    }

    public void addBook(Book book) throws IOException{
        String query = "INSERT INTO Users (book_title,book_author,book_genre,book_copies_sold,book_rating,book_release_year)" +
                " VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1, book.getTitle());
            ppStatement.setString(2, book.getAuthor());
            ppStatement.setString(3, book.getGenre());
            ppStatement.setInt(4, book.getNoOfCopies());
            ppStatement.setFloat(5, book.getRating());
            ppStatement.setString(6, book.getDateOfRelease());
            ppStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        new FileManager().writeBook(book);
    }

    public void removeBook(int book_id) throws SQLException {
        String query = """
                DELETE FROM Books
                WHERE Books.book_id = ?;
                """;
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(1,book_id);
        ppStatement.executeUpdate();
    }

    public void updateBook(int book_id,String book_title,String book_author,String book_genre, int copies, float rating, int release_year) throws SQLException {
        String query = "UPDATE Books " +
                "SET book_title = ?, book_author = ?, book_genre = ?, book_copies_sold = ?, book_rating, book_release_year = ? " +
                "WHERE book_id = ?";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(7, book_id);
        ppStatement.setString(1, book_title);
        ppStatement.setString(2, book_author);
        ppStatement.setString(3, book_genre);
        ppStatement.setInt(4, copies);
        ppStatement.setFloat(5, rating);
        ppStatement.setInt(6, release_year);
        ppStatement.executeUpdate();
    }

    public ArrayList<IssueBook> getIssuedBooks(int user_id) throws SQLException {
        String query = """
                SELECT IssuedBook.issue_time,Books.book_title,IssuedBook.due_time
                                FROM IssuedBook
                                INNER JOIN Books\s
                						ON Books.book_id = IssuedBook.book_id
                                WHERE IssuedBook.user_id = ? AND IssuedBook.borrow_id NOT IN (
                                        SELECT ReturnedBook.borrow_id
                                		FROM ReturnedBook);""";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(1, user_id);
        ResultSet rs = ppStatement.executeQuery();
        ArrayList<IssueBook> issued_books = new ArrayList<>();
        IssueBook issued_book = null;
        if (rs.next()) {
            do {
                issued_book = new IssueBook();
                issued_book.setBook_title(rs.getString(2));
                issued_book.setIssue_date(rs.getString(1));
                issued_book.setDue_date(rs.getString(3));
                issued_books.add(issued_book);
            } while (rs.next());
            return issued_books;
        }
        return null;
    }

    public int isBookIssued(int book_id){
     String query = """
             SELECT IF(IssuedBook.book_id = ?,1,0) AS STATUS
              FROM IssuedBook
              	WHERE IssuedBook.user_id = ? AND IssuedBook.book_id = ? AND IssuedBook.borrow_id NOT IN\s
             		(
                 	SELECT ReturnedBook.borrow_id
                     FROM ReturnedBook
             		);""";
        try{
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1, book_id);
            ppStatement.setInt(2, Driver.currentUser.getUser_id());
            ppStatement.setInt(3, book_id);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int getIssuedBooksCount(int user_id) {
        String query = """
                SELECT COUNT(*)
                FROM IssuedBook
                WHERE IssuedBook.user_id = ? AND IssuedBook.borrow_id NOT IN (
                        SELECT ReturnedBook.borrow_id
                		FROM ReturnedBook);""";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1, user_id);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void increaseLevelExperience(int user_id) throws SQLException {
        String query = "UPDATE Levels " +
                "SET level_experience = level_experience + 2 " +
                "WHERE user_id = ?";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(1, user_id);
        ppStatement.executeUpdate();
    }

    public void decreaseLevelExperience(int user_id) throws SQLException {
        String query = "UPDATE Levels " +
                "SET level_experience = level_experience - 2 " +
                "WHERE user_id = ?";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(1, user_id);
        ppStatement.executeUpdate();
    }

    public void addIssueBookReceipt(int user_id,int book_id){
        String query = "INSERT INTO IssuedBook (user_id,book_id) VALUES(?,?)";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1, user_id);
            ppStatement.setInt(2, book_id);
            ppStatement.execute();
            this.increaseLevelExperience(user_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<User> getAllUsers() throws SQLException {
        String query= """
                SELECT * FROM `Users` WHERE 1;
                """;
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ResultSet rs = ppStatement.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        User user = null;
        if(rs.next()) {
            do{
                user = new User();
                user.setUser_id(rs.getInt(1));
                user.setEmail(rs.getString(8));
                user.setPassword(rs.getString(4));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAddress(rs.getString(7));
                user.setCnic(rs.getString(6));
                user.setMobileNumber(rs.getString(9));
                users.add(user);
            }while (rs.next());
            return users;
        }
        return null;

    }

    public ArrayList<Book> getAllBooks() throws SQLException {
        String query= """
                SELECT * FROM `Books` WHERE 1;
                """;
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ResultSet rs = ppStatement.executeQuery();
        ArrayList<Book> books = new ArrayList<>();
        Book book = null;
        if(rs.next()) {
            do{
                book = new Book();
                book.setBook_id(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setGenre(rs.getString(4));
                book.setNoOfCopies(rs.getInt(5));
                book.setRating(rs.getFloat(6));
                book.setDateOfRelease(rs.getString(7));
                books.add(book);
            }while (rs.next());
            return books;
        }
        return null;
    }

    public void resetPassword(String password) throws SQLException {
        String query = "UPDATE Users " +
                "SET password = ? " +
                "WHERE user_id = ?";
        PreparedStatement  ppStatement = connection.prepareStatement(query);
        ppStatement.setString(1,password);
        ppStatement.setInt(2,Driver.currentUser.getUser_id());
        ppStatement.executeUpdate();
    }

    public void decreaseBookCopy(int book_id) throws SQLException {
        String query = """
                UPDATE Books
                SET book_copies_sold = book_copies_sold - 1
                WHERE book_id = ?;""";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(1, book_id);
        ppStatement.executeUpdate();
    }

    public void increaseBookCopy(int book_id) throws SQLException {
        String query = """
                UPDATE Books
                SET book_copies_sold = book_copies_sold + 1
                WHERE book_id = ?;""";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(1, book_id);
        ppStatement.executeUpdate();
    }

    public ArrayList<ReturnBook> getReturnedBooks() throws SQLException {
        String query = """
                SELECT Books.book_title,IssuedBook.issue_time,IssuedBook.due_time,ReturnedBook.returned_time
                                                      FROM ReturnedBook
                                                      INNER JOIN IssuedBook
                                                      ON IssuedBook.borrow_id = ReturnedBook.borrow_id
                                                      INNER JOIN Books
                                                      ON Books.book_id = IssuedBook.book_id
                                                      WHERE IssuedBook.user_id = ?;""";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ppStatement.setInt(1,Driver.currentUser.getUser_id());
        ResultSet rs = ppStatement.executeQuery();
        ArrayList<ReturnBook> returned_books = new ArrayList<>();
        ReturnBook returned_book = null;
        if(rs.next()) {
            do{
                returned_book = new ReturnBook();
                returned_book.setBook_title(rs.getString(1));
                returned_book.setIssue_date(rs.getString(2));
                returned_book.setDue_date(rs.getString(3));
                returned_book.setDate_of_return(rs.getString(4));
                returned_books.add(returned_book);
            }while (rs.next());
            return returned_books;
        }
        return null;
    }

    public int getBookId(String book_title){
        String query = """
                SELECT Books.book_id
                FROM Books
                WHERE Books.book_title = ?;""";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1, book_title);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getBorrowId(IssueBook book){
        String query = """
                SELECT IssuedBook.borrow_id
                FROM IssuedBook
                WHERE IssuedBook.user_id = ?  AND IssuedBook.book_id = ? AND IssuedBook.issue_time = ? AND IssuedBook.due_time = ?;""";
        try{
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1, Driver.currentUser.getUser_id());
            ppStatement.setInt(2, this.getBookId(book.getBook_title()));
            ppStatement.setTimestamp(3,Timestamp.valueOf(book.getIssue_date()));
            ppStatement.setTimestamp(4,Timestamp.valueOf(book.getDue_date()));
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public Timestamp getBookReturnTime(int borrow_id){
        String query = """
                SELECT ReturnedBook.returned_time
                FROM ReturnedBook
                WHERE ReturnedBook.borrow_id = ?;""";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1, borrow_id);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp(1);
            } else {
                return null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addReturnReceipt(IssueBook book){
        String query = "INSERT INTO ReturnedBook(ReturnedBook.borrow_id) VALUES (?)";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1,this.getBorrowId(book));
            ppStatement.execute();
            this.increaseBookCopy(this.getBookId(book.getBook_title()));
            Timestamp returnTime = this.getBookReturnTime(this.getBorrowId(book));
            Timestamp dueTime = Timestamp.valueOf(book.getDue_date());
            int user_xp = this.getUserExperience(Driver.currentUser.getUser_id());
            if(returnTime.compareTo(dueTime) > 0){
                if(user_xp - 2 > 0) {
                    this.decreaseLevelExperience(Driver.currentUser.getUser_id());
                }
            }
            else{
                if(user_xp + 2 < 10 ) {
                    this.increaseLevelExperience(Driver.currentUser.getUser_id());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> searchBooksByAuthor(String keyword){
        String query = "SELECT * FROM Books WHERE book_author LIKE '%"+keyword+"%'";
        try{
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ResultSet rs = ppStatement.executeQuery();
            ArrayList<Book> books = null;
            Book book = null;
            if(rs.next()){
                books = new ArrayList<>();
                do{
                    book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setAuthor(rs.getString(3));
                    book.setTitle(rs.getString(2));
                    book.setGenre(rs.getString(4));
                    book.setNoOfCopies(rs.getInt(5));
                    book.setRating(rs.getFloat(6));
                    book.setDateOfRelease(rs.getString(7));
                    books.add(book);
                }while(rs.next());
            }
            return books;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> searchBooksByGenre(String keyword){
        String query = "SELECT * FROM Books WHERE book_genre LIKE '%"+keyword+"%'";
        try{
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ResultSet rs = ppStatement.executeQuery();
            ArrayList<Book> books = null;
            Book book = null;
            if(rs.next()){
                books = new ArrayList<>();
                do{
                    book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setAuthor(rs.getString(3));
                    book.setTitle(rs.getString(2));
                    book.setGenre(rs.getString(4));
                    book.setNoOfCopies(rs.getInt(5));
                    book.setRating(rs.getFloat(6));
                    book.setDateOfRelease(rs.getString(7));
                    books.add(book);
                }while(rs.next());
            }
            return books;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> searchBooksByYear(int date){
        String query = "SELECT * FROM Books WHERE book_title = ?";
        try{
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1,date);
            ResultSet rs = ppStatement.executeQuery();
            ArrayList<Book> books = null;
            Book book = null;
            if(rs.next()){
                books = new ArrayList<>();
                do{
                    book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setAuthor(rs.getString(3));
                    book.setTitle(rs.getString(2));
                    book.setGenre(rs.getString(4));
                    book.setNoOfCopies(rs.getInt(5));
                    book.setRating(rs.getFloat(6));
                    book.setDateOfRelease(rs.getString(7));
                    books.add(book);
                }while(rs.next());
            }
            return books;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> searchBooksByRating(float rating){
        String query = "SELECT * FROM Books WHERE book_rating = ?";
        try{
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setFloat(1,rating);
            ResultSet rs = ppStatement.executeQuery();
            ArrayList<Book> books = null;
            Book book = null;
            if(rs.next()){
                books = new ArrayList<>();
                do{
                    book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setAuthor(rs.getString(3));
                    book.setTitle(rs.getString(2));
                    book.setGenre(rs.getString(4));
                    book.setNoOfCopies(rs.getInt(5));
                    book.setRating(rs.getFloat(6));
                    book.setDateOfRelease(rs.getString(7));
                    books.add(book);
                }while(rs.next());
            }
            return books;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //Reference SearchBook
    public ArrayList<Book> searchBooksByTitle(String keyword){
        String query = "SELECT * FROM Books WHERE book_title LIKE '%"+keyword+"%'";
        try{
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ResultSet rs = ppStatement.executeQuery();
            ArrayList<Book> books = null;
            Book book = null;
            if(rs.next()){
                books = new ArrayList<>();
                do{
                    book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setAuthor(rs.getString(3));
                    book.setTitle(rs.getString(2));
                    book.setGenre(rs.getString(4));
                    book.setNoOfCopies(rs.getInt(5));
                    book.setRating(rs.getFloat(6));
                    book.setDateOfRelease(rs.getString(7));
                    books.add(book);
                }while(rs.next());
            }
            return books;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //Reference Driver
    public boolean isBookTableEmpty(){
        String query = "SELECT COUNT(*) FROM Books";
        try{
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            } else {
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //Reference Driver
    public void uploadBooksToDatabase(){
        FileManager fileManager = new FileManager();
        ArrayList<Book> books = null;
        try {
            books = fileManager.readBooksData();
        }catch(IOException e){
            e.printStackTrace();
        }
        if(books != null) {
            String query = "INSERT INTO Books (book_title,book_author,book_genre," +
                    "book_copies_sold,book_rating,book_release_year) VALUES(?,?,?,?,?,?)";
            try {
                for (Book book : books) {
                    PreparedStatement ppStatement = connection.prepareStatement(query);
                    ppStatement.setString(1, book.getTitle());
                    ppStatement.setString(2, book.getAuthor());
                    ppStatement.setString(3, book.getGenre());
                    ppStatement.setString(4, Integer.toString(book.getNoOfCopies()));
                    ppStatement.setString(5, Float.toString(book.getRating()));
                    ppStatement.setString(6, book.getDateOfRelease());
                    ppStatement.execute();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There was an issue with the File Manager!",
                    "File Upload Error to DB", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Reference
    public int getUserExperience(int user_id){
        String query = """
                SELECT Levels.level_experience
                FROM Levels\s
                WHERE Levels.user_id = ?""";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1,user_id);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Reference SignUp
    public void addUser(User user,String securityAnswer,int securityQuestion) {
        //User is added
        String query = "INSERT INTO Users (username,password,first_name,last_name,address,phoneNumber,cnic,securityQuestion,securityAnswer)" +
                " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1, user.getEmail());
            ppStatement.setString(2, user.getPassword());
            ppStatement.setString(3, user.getFirstName());
            ppStatement.setString(4, user.getLastName());
            ppStatement.setString(5, user.getAddress());
            ppStatement.setString(6, user.getMobileNumber());
            ppStatement.setString(7, user.getCnic());
            ppStatement.setInt(8,securityQuestion);
            ppStatement.setString(9,securityAnswer);
            ppStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Level is added
        query = "INSERT INTO Levels (user_id,level_experience) VALUES(?,?)";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1, getId(user.getEmail(),user.getPassword()));
            ppStatement.setInt(2, 2);
            ppStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Reference SignUp
    public boolean checkUserRepetition(String username) {
        String query = "SELECT * FROM Users where username = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1, username);
            ResultSet rs = ppStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Reference SignUp
    public boolean checkCnicRepetition(String cnic) {
        String query = "SELECT * FROM Users where cnic = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1, cnic);
            ResultSet rs = ppStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Reference Login
    public int getId(String username, String password) {
        String query = "SELECT * FROM Users where username = ? and password = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1, username);
            ppStatement.setString(2, password);

            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //Reference Driver && LoginMenu
    public User loadUserInfoFromDataBase(int user_id) throws SQLException {
        //-----------------------------------------------user-MAIL is loaded--------------------------------------------------
        PreparedStatement ppStatement = connection.prepareStatement("SELECT * FROM Users where user_id=?");
        ppStatement.setInt(1, user_id);
        ResultSet rs = ppStatement.executeQuery();

        User user = new User();
        if (rs.next()) {
            user.setUser_id(user_id);
            user.setEmail(rs.getString(8));
            user.setPassword(rs.getString(4));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setAddress(rs.getString(7));
            user.setCnic(rs.getString(6));
            user.setMobileNumber(rs.getString(9));
            return user;
        } else {
            return null;
        }
    }

}
