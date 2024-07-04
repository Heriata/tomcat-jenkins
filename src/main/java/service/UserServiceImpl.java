package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(String name, String surname, Integer age) {
        userRepository.addUser(name, surname,age);
    }

    @Override
    public void updateUser(Integer id, String name, String surname, Integer age) {
        userRepository.updateUser(id, name, surname, age);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }
}
