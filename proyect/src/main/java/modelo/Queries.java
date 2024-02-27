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

    final public static String db = getProperties().getProperty("db");
    final public static String clientTable = getProperties().getProperty("clientTable");
    final static String user = getProperties().getProperty("user");
    final static String password = getProperties().getProperty("password");

    public Queries(){
        // Properties properties = new Properties();
    }

private static Properties getProperties(){
    Properties properties = new Properties();
    try {
        properties.load(new FileInputStream("proyect\\config\\db.properties"));
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
            System.out.println("Se ha finalizado la conexión con el servidor"); 
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
                System.out.println(resultSet.getInt("id") + "-" + resultSet.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos");
        }
    }
    public static void getCarrera(Connection conexion, String table_name, String carrera){
        try {
            String Query = "SELECT * FROM " + table_name + " WHERE nombre LIKE " + "'" + carrera + "'";
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            if(!resultSet.next()){
                System.out.println("The career introduced doesn't exists");
            }else{
                System.out.println("The career introdced exists");
                System.out.println(resultSet.getInt("id") + "-" + resultSet.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos");
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
            // JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
            System.out.println("Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
    public static void deleteRecord(Connection conexion, String table_name, String name){
        try {
            String Query = "DELETE FROM " + table_name + " WHERE nombre = '" + name + "'";
            Statement st = conexion.createStatement();
            if(st.executeUpdate(Query) == 0){
                System.out.println("The value provided doesn't exist");
            }else{
                st.executeUpdate(Query);
                System.out.println("The changes were made succesfully");
            }
        } catch (SQLException ex) {
            // System.out.println(ex.getMessage());
            // JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
            System.out.println("The career can't be deleted because there are still students coursing it");
        }
    }
    public static void updateData(Connection conexion, String table_name, String id, String name){
        try {
            String Query = "UPDATE " + table_name + " SET nombre = '" + name + "' WHERE id = '" + id + "'"; 
            Statement st = conexion.createStatement();
            if(name == "" || st.executeUpdate(Query) == 0){
                System.out.println("The query was interrupted and the changes were not made");
            }else{
                st.executeUpdate(Query);
                System.out.println("The update was made succesfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error actualizando el registro especificado");
        }
    }
}
