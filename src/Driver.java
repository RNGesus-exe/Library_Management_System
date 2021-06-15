import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Driver {

    public static DatabaseManager dataAgent = null;        //This agent helps in managing database
    public static User currentUser = null;                 //This agent holds the logged in user data
    public static String[] levels = {"BRONZE","SILVER","GOLD","DIAMOND"};  //This is for accessing ranks with ease

    public static void main(String[] args) throws IOException, SQLException {

        Connection connectionAgent = ConnectionConfiguration.getConnection();  //Connects to MySql through Xampp
        if (connectionAgent != null) {
            dataAgent = new DatabaseManager(connectionAgent);
            dataAgent.createTables();
            if(new FileManager().readUserId() == -1){
                new LoginUI();
            }
            else{
                if(dataAgent.isBookTableEmpty()){
                    dataAgent.uploadBooksToDatabase();
                }
                currentUser = dataAgent.loadUserInfoFromDataBase(new FileManager().readUserId());
                new IssueBookUI();
            }
        } else {   //In case Connection is not established
            JOptionPane.showMessageDialog(null, "Connection was not established!",
                    "Database connection Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
