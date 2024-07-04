package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    void addUser(String name, String surname, Integer age);
    void updateUser(Integer id, String name, String surname, Integer age);
    void deleteUser(Integer id);

    List<User> getAllUsers();

    User getUserById(Integer id);
}
