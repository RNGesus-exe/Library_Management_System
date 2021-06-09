import javax.swing.*;
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
                                        first_name VARCHAR(255) NOT NULL
                                       ,last_name VARCHAR(255) NOT NULL
                                       ,password VARCHAR(255) NOT NULL
                                       ,dateTime TIMESTAMP
                                       ,cnic VARCHAR(255)\t  UNIQUE NOT NULL
                                       ,address VARCHAR(255)  NOT NULL
                                       ,username VARCHAR(255) UNIQUE NOT NULL
                                       ,phoneNumber VARCHAR(55) NOT NULL);""");
            //Books Table
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS Books (book_id INT PRIMARY KEY AUTO_INCREMENT,
                                        book_title VARCHAR(255) NOT NULL
                                       ,book_author VARCHAR(255) NOT NULL
                                       ,book_genre VARCHAR(255) NOT NULL
                                       ,book_copies_sold VARCHAR(255)
                                       ,book_rating FLOAT
                                       ,book_release_year INT);""");
         } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Reference SearchBook
    public ArrayList<Book> searchBooks(String keyword){
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

    //INSERT all books into mySQL Books Table
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

    // Reference SignUp
    public void addUser(User user) {
        String query = "INSERT INTO Users (username,password,first_name,last_name,address,phoneNumber,cnic) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1, user.getEmail());
            ppStatement.setString(2, user.getPassword());
            ppStatement.setString(3, user.getFirstName());
            ppStatement.setString(4, user.getLastName());
            ppStatement.setString(5, user.getAddress());
            ppStatement.setString(6, user.getMobileNumber());
            ppStatement.setString(7, user.getCnic());
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
