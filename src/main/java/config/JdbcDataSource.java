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
            Properties prop = new Properties();
            InputStream inputStream = JdbcDataSource.class.getClassLoader().getResourceAsStream("./config.properties");
            prop.load(inputStream);

            String driver = prop.getProperty("db.driver");
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
