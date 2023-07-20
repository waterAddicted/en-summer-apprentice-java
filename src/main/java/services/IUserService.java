package services;

import model.User;
import repository.UsersRepository;

import java.util.List;

public interface IUserService {
    UsersRepository getUserRepo();
    User createUser(User User);
    User fetchOneUser(Long UserID);
    List<User> fetchAllUsers();
    void deleteUser(Long UserID);
    User updateUser(User User, Long UserID);
}
