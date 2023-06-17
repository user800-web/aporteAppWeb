package logicbusiness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    static String login = "postgres";
    static String password = "facil2020";
    static String url = "jdbc:postgresql://localhost/aporte";

    private Statement statement;
    private Connection conexion;

    public Conexion() throws Exception {
        conexion = null;
        statement = null;

        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(url, login, password);

        if (conexion != null) {
            statement = conexion.createStatement();
            System.out.println("Conexión a base de datos " + url + " ... Ok");
        }

    }

    public long insertar(String sentence) throws Exception {
        return statement.executeUpdate(sentence);
    }
    
    public long borrar(String sentence) throws Exception {
        return statement.executeUpdate(sentence);
    }
    
    public long actualizar(String sentence) throws Exception {
        return statement.executeUpdate(sentence);
    }
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
    public ResultSet select(String sentence) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sentence);

        return resultSet;
    }
}