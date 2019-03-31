import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class DbConnection{
    
    static Connection con;
    PreparedStatement p_statement = null;
    ResultSet res = null;
    
    public Connection getDbConnection()
    {         
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalcare","localhost","");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }  
};

