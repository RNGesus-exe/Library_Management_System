import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration{
    public static Connection getConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","");
            if(connection!=null){
                System.out.println("Connection Established!");
            }
            else{
                System.out.println("Connection Not Established!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}