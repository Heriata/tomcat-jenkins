package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcDataSource {

    public static Connection getConnection() {
        Connection connection = null;
        try{
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
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.100.11:5432/user_app", "postgres", "");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection == null) throw new RuntimeException("Connection to DB has not established");
        return connection;
    }
}
