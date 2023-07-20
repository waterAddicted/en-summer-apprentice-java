package com.endava.demo.services;

import com.endava.demo.model.User;
import org.springframework.stereotype.Service;
import com.endava.demo.repository.UsersRepository;

import java.util.List;

@Service
public class UserService implements IUserService{
    private UsersRepository UserRepo;

    public UserService(UsersRepository UserRepo){
        this.UserRepo = UserRepo;
    }

    @Override
    public UsersRepository getUserRepo(){
        return this.UserRepo;
    }

    @Override
    public User createUser(User User) {
        return this.UserRepo.save(User);
    }

    @Override
    public User fetchOneUser(Long UserID) {
        return this.UserRepo.findById(UserID).get();
    }

    @Override
    public List<User> fetchAllUsers() {
        return (List<User>) this.UserRepo.findAll();
    }

    @Override
    public void deleteUser(Long UserID) {
        this.UserRepo.deleteById(UserID);
    }

    @Override
    public User updateUser(User User, Long UserID) {
        User updateUser = this.UserRepo.findById(UserID).get();
        updateUser.setUserName(User.getUserName());
        updateUser.setUserName(User.getUserName());
        updateUser.setEmail(User.getEmail());
        return this.UserRepo.save(updateUser);
    }
}
