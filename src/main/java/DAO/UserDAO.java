package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static Connection getConnetction() {
        Connection connection = null;

        try {
            Class.forName("");
            connection = DriverManager.getConnection(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void saveUser(User user) {
        try (Connection connection = UserDAO.getConnetction()) {

            PreparedStatement ps = connection.prepareStatement("insert into users(name, surname,age) values(?,?,?)");

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getAge());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateUser(User user) {
        try (Connection connection = UserDAO.getConnetction()) {

            PreparedStatement ps = connection.prepareStatement("update users set name=?, surname=?,age=? where id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getAge());
            ps.setInt(5, user.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(Integer id) {
        try (Connection connection = UserDAO.getConnetction()) {
            PreparedStatement ps = connection.prepareStatement("delete from users where id=?");
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = UserDAO.getConnetction()) {
            PreparedStatement ps = connection.prepareStatement("select * from users");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setAge(rs.getInt(4));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static User getUserById(Integer id) {
        User user = new User();

        try (Connection connection = UserDAO.getConnetction()) {
            PreparedStatement ps = connection.prepareStatement("select * from users where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setAge(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
