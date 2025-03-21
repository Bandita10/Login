package login.Tools;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Managerdb 
{
    //Libreria de Mysql
    String driver = "com.mysql.cj.jdbc.Driver";
    
    //Nombre de la base de datos
    String database= "Login";
    
    //host la ip del servidor
    String hostname = "localhost";
    
    //Puerto 
    String port = "3306";
    
    //la URL es la ruta para la conexion de nuestra base de datos
    String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?userSSL=false";

    //Nombre del usuario
    String usuario = "root";
    
    //Contraseña
    String password = "Tuculitoesmio";
    
    private Connection getmysqlConnection()
    {
        Connection conn = null;
        try 
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            
        } catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace(); 
        }
        return conn; 
    }
    
    public boolean textConnection()
    {
        boolean openCon = false;
        Connection con = getmysqlConnection();
        if (con!=null) 
        {
            try
            {
                Statement sentencia = con.createStatement(); 
                String consult = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + database + "'";
                ResultSet result = sentencia.executeQuery(consult);
                while(result.next())
                {
                    openCon = true;
                }   
            }
            catch (SQLException e){
                //throw new ClassCastException(e.getMessage());
                e.printStackTrace();
            }
                        
        }
        return openCon;
    }
    
    public ResultSet ExecuteQuery (String query)
    {
        Connection db = getmysqlConnection();
        try
        {
            Statement triste = db.createStatement();
            ResultSet resultado = triste.executeQuery(query);
            return resultado;
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
}
