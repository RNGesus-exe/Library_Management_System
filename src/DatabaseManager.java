import java.sql.*;

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
            statement.execute("CREATE TABLE IF NOT EXISTS Users (user_id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "                    first_name VARCHAR(255) NOT NULL\n" +
                    "                   ,last_name VARCHAR(255) NOT NULL\n" +
                    "                   ,password VARCHAR(255) NOT NULL\n" +
                    "                   ,dateTime TIMESTAMP\n" +
                    "                   ,cnic VARCHAR(255)\t  UNIQUE NOT NULL\n" +
                    "                   ,address VARCHAR(255)  NOT NULL\n" +
                    "                   ,username VARCHAR(255) UNIQUE NOT NULL\n" +
                    "                   ,phoneNumber VARCHAR(55) NOT NULL);");
         } catch (SQLException e) {
            e.printStackTrace();
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
