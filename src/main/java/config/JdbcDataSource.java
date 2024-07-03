package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcDataSource {

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
//            Properties prop = new Properties();
//            InputStream inputStream = JdbcDataSource.class.getClassLoader().getResourceAsStream("./config.properties");
//            prop.load(inputStream);

//            String driver = prop.getProperty("db.driver");
//            String user = prop.getProperty("db.username");
//            String password = prop.getProperty("db.password");
//            String url = prop.getProperty("db.url");

//            Class.forName(driver);
//            connection = DriverManager.getConnection(url, user, password);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql:/192.168.100.14:5432/usersapp","postgres", "postgres");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
