package modelo;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.JOptionPane;

public final class Queries {  

    final static private String db = getProperties().getProperty("db");
    final static private String clientTable = getProperties().getProperty("clientTable");
    final static private String user = getProperties().getProperty("user");
    final static private String password = getProperties().getProperty("password");

    public Queries(){
        // Properties properties = new Properties();
    }

private static Properties getProperties(){
    Properties properties = new Properties();
    try {
        properties.load(new FileInputStream("src/config/db.properties"));
    } catch (IOException e) {
        System.err.printf("Error load 'db.properties' %s \n", e.getMessage());
        return null;
    }
    return properties;
}
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
    public static Connection createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + db, user, password);
            System.out.println("Conexión correcta");
            return conexion;
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos");
        }
        return null;
    }
    public static void closeConnection(Connection conexion){
        try {
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");   
        } catch (SQLException ex) {
            Logger.getLogger("App").log(Level.SEVERE, null, ex);
        }

    }
    public static void getCarreras(Connection conexion, String table_name){
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            while(resultSet.next()){
                System.out.println(resultSet.getShort("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
    public static void insertData(Connection conexion, String table_name, String name){
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
            + "" + "NULL" + ","
            + "'" + name + "'"
+ ")";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
    public static void deleteRecord(Connection conexion, String table_name, String name){
        try {
            String Query = "DELETE FROM " + table_name + " WHERE name = '" + name + "'";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
    public static void updateData(Connection conexion, String table_name, String id, String name){
        try {
            String Query = "UPDATE " + table_name + " SET name = '" + name + "' WHERE id = '" + id + "'"; 
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error actualizando el registro especificado");
        }
    }
}
