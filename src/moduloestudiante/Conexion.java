
package moduloestudiante;
import java.sql.*;
import javax.swing.JOptionPane;
import org.sqlite.SQLiteConnection;
/**
 *
 * @author LENOVO
 */
public class Conexion 
{
   Connection conectar= null;
   public static Connection ConectarBD() throws ClassNotFoundException 
   {

      try
      {
       Class.forName("org.sqlite.JDBC");
       Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\jcnun\\Documents\\ESTRUCTURA DE DATOS\\moduloestudiante\\Estudiantes.db");
       
       System.out.println("CONECTADO A:"+con);
       
       JOptionPane.showMessageDialog(null, "Conexion Establecida");
       
       
        return con;
      }catch(SQLException e)
      {
          JOptionPane.showMessageDialog(null, e);
          return null;
      }
       
      
   }
    /*public static void main(String[] args) {
        Conexion conec= new Conexion();
        ConectarBD();
    }*/
}