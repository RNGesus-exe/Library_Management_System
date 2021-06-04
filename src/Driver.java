import javax.swing.*;
import java.sql.Connection;

public class Driver {

    public static DatabaseManager dataAgent = null;        //This agent helps in managing database

    public static void main(String[] args) {

        Connection connectionAgent = ConnectionConfiguration.getConnection();  //Connects to MySql through Xampp
        if (connectionAgent != null) {
            dataAgent = new DatabaseManager(connectionAgent);
            dataAgent.createTables();
            //Login GUI
        } else {   //In case Connection is not established
            JOptionPane.showMessageDialog(null, "Connection was not established!",
                    "Database connection Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
