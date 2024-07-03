package config;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void createUser(User user) {
        String query = "INSERT INTO usersapp (name, surname, age) VALUES (?,?,?)";

        try (Connection connection = JdbcDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            if (user.getAge().compareTo(0) > 0) {
                statement.setString(1, user.getName());
                statement.setString(2, user.getSurname());
                statement.setInt(3, user.getAge());
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new IllegalArgumentException();
        }
    }

    public List<User> getAll() {
        String query = "SELECT * FROM usersapp";
        List<User> userList = new ArrayList<>();

        try (Connection connection = JdbcDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));

                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return userList;
    }

    public User getById(int id){
        String query = "SELECT * FORM usersapp WHERE id=?";
        User user = null;
        try (Connection connection = JdbcDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    public void update(User user){
        String query = "UPDATE usersapp SET name = ?, surname = ?, age = ?";

        try (Connection connection = JdbcDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            if(user.getAge().compareTo(0) > 0){
                statement.setString(2, user.getName());
                statement.setString(3, user.getSurname());
                statement.setInt(1,user.getId());
                statement.setInt(4,user.getAge());

                statement.executeQuery();
            }else {
                throw new IllegalArgumentException();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM usersapp WHERE id=?";

        try (Connection connection = JdbcDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}