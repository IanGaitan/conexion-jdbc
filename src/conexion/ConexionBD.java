
package conexion;

/**
 *
 * @author ianga
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    // atributos de la clase
    private String url="jdbc:mysql://localhost:3306/";
    private String bd="menu_master_db";
    private String user="root";
    private String password="";
    private String driver="com.mysql.cj.jdbc.Driver";
    protected Connection conexion;
    
    public ConexionBD() {
        try{
            // llamada para cargar el driver para poder conectarse a una base de datos
            Class.forName(driver);
            // Driver manager es una clase que conecta una aplicacion a una fuente de datos
            conexion = DriverManager.getConnection(url+bd,user,password);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
