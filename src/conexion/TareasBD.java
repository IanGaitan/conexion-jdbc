
package conexion;

/**
 *
 * @author ianga
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TareasBD extends ConexionBD  {
    private Statement sentencia;
    private ResultSet resultado;
    private PreparedStatement sentenciaps;
    
    //método para consultar todos los clientes
    public void consultar(){
        try{
            // Crear un objeto Statement para enviar instrucciones SQL
            sentencia=conexion.createStatement();
            // Construcción de sentencia SQL
            String query="SELECT * FROM cliente";
            // El método executeQuery ejecuta una sentencia SELECT y devuelve un objeto ResultSet
            resultado = sentencia.executeQuery(query);
            // Recorrer el objeto ResultSet obtenido
            while(resultado.next()){
                int id_cliente = resultado.getInt("id_cliente");
                String nombre = resultado.getString("nombre");
                int telefono = resultado.getInt("telefono");
                String direccion = resultado.getString("direccion");
                String correo = resultado.getString("correo");
                System.out.println("Cliente: "+ id_cliente + "\nNombre: " + nombre + "\nTelefono: "+ telefono +"\nDireccion: " + direccion + "\nCorreo Electronico: " + correo);
            }
            // Cerrar las conexiones abiertas
            resultado.close();
            sentencia.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //método para consultar por id del cliente
    public void consultar(int id){
        try{
            // Construcción de sentencia SQL con parámetros
            String query="SELECT * FROM cliente WHERE id_cliente=?";
            // Preparación de la consulta para pasar los parámetros
            sentenciaps = conexion.prepareStatement(query);
            sentenciaps.setInt(1, id);
            // El método executeQuery ejecuta una sentencia SELECT y devuelve un objeto ResultSet
            resultado = sentenciaps.executeQuery();
            // Recorrer el objeto ResultSet obtenido
            while(resultado.next()){
                int id_cliente = resultado.getInt("id_cliente");
                String nombre = resultado.getString("nombre");
                int telefono = resultado.getInt("telefono");
                String direccion = resultado.getString("direccion");
                String correo = resultado.getString("correo");
                System.out.println("Cliente: "+ id_cliente + "\nNombre: " + nombre + "\nTelefono: "+ telefono +"\nDireccion: " + direccion + "\nCorreo Electronico: " + correo);
            }
            // Cerrar las conexiones abiertas
            resultado.close();
            sentenciaps.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //método para insertar un cliente 
    public void insertar(int id, String nom, int tel, String dir, String cor){
        try{
            // Sentencia SQL con parámetros
            String query="INSERT INTO cliente VALUES (?,?,?,?,?)";
            // Preparación de la consulta para pasar los parámetros
            sentenciaps = conexion.prepareStatement(query);
            sentenciaps.setInt(1, id);
            sentenciaps.setString(2, nom);
            sentenciaps.setInt(3, tel);
            sentenciaps.setString(4, dir);
            sentenciaps.setString(5, cor);
            // El método executeUpdate, ejecuta sentencias INSERT, UPDATE, o DELETE, las cuales no retornan datos
            sentenciaps.executeUpdate();
            // Cerrar la conexión abierta
            sentenciaps.close();
            System.out.println("El cliente ha sido registrado satisfactoriamente \n");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //método para actualizar un cliente
    public void actualizar(int id, String nom, int tel, String dir, String cor){
        try{
            // Construcción de sentencia SQL con parámetros
            String query="UPDATE cliente SET nombre = ?, telefono = ?, direccion = ?, correo = ? WHERE id_cliente=?";
            // Preparación de la consulta para pasar los parámetros
            sentenciaps = conexion.prepareStatement(query);
            sentenciaps.setString(1, nom);
            sentenciaps.setInt(2, tel);
            sentenciaps.setString(3, dir);
            sentenciaps.setString(4, cor);
            sentenciaps.setInt(5, id);
            // El método executeUpdate, ejecuta sentencias INSERT, UPDATE, o DELETE, las cuales no retornan datos
            sentenciaps.executeUpdate();
            System.out.println("El cliente ha sido actualizado satisfactoriamente \n");
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //método para eliminar un cliente
    public void eliminar(int id){
        try{
            // Construcción de sentencia SQL con parámetros
            String query="DELETE FROM cliente WHERE id_cliente=?";
            // Preparación de la consulta para pasar los parámetros
            sentenciaps = conexion.prepareStatement(query);
            sentenciaps.setInt(1, id);
            // El método executeUpdate, ejecuta sentencias INSERT, UPDATE, o DELETE, las cuales no retornan datos
            sentenciaps.executeUpdate();
            System.out.println("El cliente ha sido eliminado satisfactoriamente \n");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
