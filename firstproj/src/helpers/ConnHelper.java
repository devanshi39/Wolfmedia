package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnHelper {

    public Connection getConnection() throws Exception{
        Connection conn = null;

        String url = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/ibanerj";
        String user = "ibanerj";
        String pswd = "200472217";
        
        try{
            conn = DriverManager.getConnection(url, user, pswd);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
            
        return conn;
    }

    public void close(Connection connection) {
            
        if(connection != null) {
            try {
            connection.close();
            } catch(Throwable whatever) {}
        }
    }
}
