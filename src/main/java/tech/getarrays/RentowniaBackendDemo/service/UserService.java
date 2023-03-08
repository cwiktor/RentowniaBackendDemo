package tech.getarrays.RentowniaBackendDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.RentowniaBackendDemo.model.User;
import tech.getarrays.RentowniaBackendDemo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long userId){ //implement exception if record not exists
        return userRepository.getReferenceById(userId);
    }
    public List<User> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public void deleteUserById(Long userId){ //implement exception if record not exists
        userRepository.deleteById(userId);
    }

}
