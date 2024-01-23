package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class Main {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ddbb_ayi_12012024";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            createTables(connection);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Menú de opciones:");
                System.out.println("1. Agregar usuario");
                System.out.println("2. Mostrar usuarios");
                System.out.println("3. Salir");

                System.out.print("Seleccione una opción: ");
                try {
                    String option = reader.readLine();

                    switch (option) {
                        case "1":
                            addUser(connection, reader);
                            break;
                        case "2":
                            showUsers(connection);
                            break;
                        case "3":
                            System.out.println("Saliendo del programa. Hasta luego.");
                            connection.close();
                            System.exit(0);
                        default:
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Personas (IdPersonas INT PRIMARY KEY, nombres VARCHAR(255), apellido VARCHAR(255), tipoDocumento VARCHAR(50), numeroDocumento VARCHAR(20))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Documentos (numeroDocumento VARCHAR(20) PRIMARY KEY, descripcion VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS TipoUsuarios (IdTipoUsuario INT PRIMARY KEY, descripcion VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Usuarios (IdUsuarios INT PRIMARY KEY, nombreUsuario VARCHAR(255), passwordUsuario VARCHAR(255), IdPersona INT, IdTipoUsuario INT, FOREIGN KEY (IdPersona) REFERENCES Personas(IdPersonas), FOREIGN KEY (IdTipoUsuario) REFERENCES TipoUsuarios(IdTipoUsuario))");
        }
    }

    private static void addUser(Connection connection, BufferedReader reader) throws SQLException, IOException {
        System.out.print("Ingrese el nombre de usuario: ");
        String userName = reader.readLine();

        System.out.print("Ingrese la contraseña: ");
        String password = reader.readLine();

        System.out.print("Ingrese el IdPersona: ");

        int idPersona = Integer.parseInt(reader.readLine());

        System.out.print("Ingrese el IdTipoUsuario: ");
        int idTipoUsuario = Integer.parseInt(reader.readLine());

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Usuarios (nombreUsuario, passwordUsuario, IdPersona, IdTipoUsuario) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.setInt(3, idPersona);
            statement.setInt(4, idTipoUsuario);
            statement.executeUpdate();
        }

        System.out.println("Usuario agregado correctamente.");
    }

    private static void showUsers(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Usuarios")) {
            System.out.println("Lista de usuarios:");
            while (resultSet.next()) {
                int userId = resultSet.getInt("IdUsuarios");
                String userName = resultSet.getString("nombreUsuario");
                String password = resultSet.getString("passwordUsuario");
                int idPersona = resultSet.getInt("IdPersona");
                int idTipoUsuario = resultSet.getInt("IdTipoUsuario");

                System.out.println("ID: " + userId + ", Usuario: " + userName + ", Contraseña: " + password + ", ID Persona: " + idPersona + ", ID Tipo Usuario: " + idTipoUsuario);
            }
        }
    }
}