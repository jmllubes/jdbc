package org.example;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Your name
 */
public class Main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bomberos";
    static final String USER = "root";
    static final String PASS = "";
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Conectado");
        Statement stmt = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix la opció que vulguis: ");
        System.out.println("a. Afegir un nou bomber"); // INSERT
        System.out.println("b. Mostrar tots els bombers"); // SELECT
        System.out.println("c. Eliminar un bomber"); // DELETE
        System.out.println("d. Modificar un bomber"); // UPDATE
        System.out.println("e. Sortir");
        String lletra = sc.nextLine();

        while(!lletra.equals("e")){
            if(lletra.equals("a")){
                System.out.println("Introdueix el parque_id del bomber 1 o 2: ");
                int parque_id = sc.nextInt();//1
                sc.nextLine();// salt de linia
                System.out.println("Introdueix els apellidos del bomber: ");
                String apellidos = sc.nextLine(); // hola + enter
                System.out.println("Introdueix el nom del bomber: ");
                String nombre = sc.nextLine();
                System.out.println("Introdueix el dni del bomber: ");
                String dni = sc.nextLine();
                System.out.println("Introdueix la data de naixement del bomber: ");
                String fecha_nacimiento = sc.nextLine();
                System.out.println("Introdueix la direcció del bomber: ");
                String direccion = sc.nextLine();
                System.out.println("Introdueix el telèfon del bomber: ");
                String telefono = sc.nextLine();
                String sql = "INSERT INTO `bombero`(`parque_id`, `apellidos`, `nombre`, `dni`, `fecha_nacimiento`, `direccion`, `telefono`) VALUES ("+parque_id+",'"+apellidos+"','"+nombre+"','"+dni+"','"+fecha_nacimiento+"','"+direccion+"','"+telefono+"')";
                int rows = stmt.executeUpdate(sql);
                System.out.println("Numero de files afectades: " + rows);
            }
            else if(lletra.equals("b")) {
                String sql = "SELECT `id`, `parque_id`, `apellidos`, `nombre`, `dni`, `fecha_nacimiento`, `direccion`, `telefono` FROM `bombero`";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int parque_id = rs.getInt("parque_id");
                    String apellidos = rs.getString("apellidos");
                    String nombre = rs.getString("nombre");
                    String dni = rs.getString("dni");
                    String fecha_nacimiento = rs.getString("fecha_nacimiento");
                    String direccion = rs.getString("direccion");
                    String telefono = rs.getString("telefono");
                    System.out.println("ID: " + id);
                    System.out.println("Parque ID: " + parque_id);
                    System.out.println("Apellidos: " + apellidos);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("DNI: " + dni);
                    System.out.println("Fecha de nacimiento: " + fecha_nacimiento);
                    System.out.println("Dirección: " + direccion);
                    System.out.println("Teléfono: " + telefono);
                    System.out.println("--------------------------------------------------");

                }
            }

                else if(lletra.equals("c")){

                }
                else if(lletra.equals("d")){

                }
                else if(lletra.equals("e")){
                System.out.println("Adéu");
                }
                else{
                    System.out.println("Introdueix una lletra vàlida");
                }
            System.out.println("Introdueix la opció que vulguis: ");
            System.out.println("a. Afegir un nou bomber");
            System.out.println("b. Mostrar tots els bombers");
            System.out.println("c. Eliminar un bomber");
            System.out.println("d. Modificar un bomber");
            System.out.println("e. Sortir");
            lletra = sc.nextLine();
            }

        }


    }
