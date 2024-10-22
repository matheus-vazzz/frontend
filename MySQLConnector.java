import java.sql.*;

public class MySQLConnector {
    public static Connection conectar() {
        String mysqllHost = "127.0.0.1";
        String mysqlDb = "db_senac";
        String mysqlUser = "root";
        String mysqlPassword = "senac@02";
        String mysqlPort = "3306";
        String mysqlUrl = "jdbc:mysql://" + mysqllHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(mysqlUrl);
            // System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
            System.err.println("ops! Algo de arrado não esta certo com a conexão com o banco de dados MySQL! Mensagem do servidor: " + e);
        }
        return conn;
    }
}