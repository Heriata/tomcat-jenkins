package listener;

import repository.JdbcUserRepository;
import repository.UserRepository;
import service.UserService;
import service.UserServiceImpl;
import sun.util.resources.cldr.ext.CurrencyNames_en_CX;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ContexListenerInitializator implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String dbDriver = "org.postgresql.Driver";
        final String username = "postgres";
        final String password = "postgres";
        final String url = "jdbc:postgresql://192.168.100.11:5432/user-app";

        try{
            Class.forName(dbDriver);

            final Connection connection = DriverManager.getConnection(url, username, password);
            UserRepository userRepository = new JdbcUserRepository(connection);
            UserService userService = new UserServiceImpl(userRepository);
            sce.getServletContext().setAttribute("userService", userService);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            final Connection connection = (Connection) sce.getServletContext().getAttribute("connection");
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
