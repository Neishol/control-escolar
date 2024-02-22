package src.modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Queries {
    final static private String db = "uni";
    final static private String clientTable = "carreras";
    final static private String user = "root";
    final static private String password = "123456";

    // public static void main(String[] args) throws Exception {
    //     Scanner scn = new Scanner(System.in);
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + db, user, password);
    //         System.out.println("Conexión correcta");
    //         getValues(conexion, clientTable);
    //         System.out.println("Insert id that u want to update");
    //         String id = scn.nextLine();
    //         System.out.println("Insert new name");
    //         String name = scn.nextLine();
    //         System.out.println("Insert new lastname");
    //         String lastname = scn.nextLine();
    //         System.out.println("Insert new email");
    //         String email = scn.nextLine();
    //         updateData(conexion, clientTable, id, name, lastname, email);
    //         System.out.println("UPDATE " + "clientes" + " SET name = '" + name + "', lastname = '" + lastname + "', email = '" + email + "' WHERE id = '" + id + "'");
    //         getValues(conexion, clientTable);
    //         // insertData(conexion, clientTable, "pepito", "sanchez", "pepuitosanchez@gmail.com");
    //         // deleteRecord(conexion, clientTable, "1");
    //         closeConnection(conexion);
    //         System.out.println("La conexión se ha cerrado");
    //     } catch (SQLException | ClassNotFoundException ex) {
    //         System.out.println("Error en la conexión de la base de datos");
    //     }
    // }
    public static void openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + db, user, password);
            System.out.println("Conexión correcta");
        } catch (SQLException ex) {
            System.out.println("Error en la conexión de la base de datos");
            }
    }
    public static void closeConnection(Connection conexion){
        try {
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");   
        } catch (SQLException ex) {
            Logger.getLogger("App").log(Level.SEVERE, null, ex);
        }
    }
    /*
    public static void getValues(Connection conexion, String table_name){
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getShort("id") + " "
                                + "Nombre: " + resultSet.getString("name") + " "
                                + "Apellido: " + resultSet.getString("lastname") + " "
                                + "Correo: " + resultSet.getString("email")
                );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
    public static void insertData(Connection conexion, String table_name, String name, String lastname, String email){
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
            + "" + "NULL" + ","
            + "'" +  name + "',"
            + "'" + lastname + "',"
            + "'" + email + "'"
+ ")";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
    public static void deleteRecord(Connection conexion, String table_name, String id){
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = '" + id + "'";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
    public static void updateData(Connection conexion, String table_name, String id, String name, String lastname, String email){
        try {
            String Query = "UPDATE " + table_name + " SET name = '" + name + "', lastname = '" + lastname + "', email = '" + email + "' WHERE id = '" + id + "'"; 
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error actualizando el registro especificado");
        }
    }
    */
}
