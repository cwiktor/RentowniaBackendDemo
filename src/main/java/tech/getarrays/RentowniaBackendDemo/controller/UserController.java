package tech.getarrays.RentowniaBackendDemo.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.RentowniaBackendDemo.model.Address;
import tech.getarrays.RentowniaBackendDemo.model.User;
import tech.getarrays.RentowniaBackendDemo.service.AddressService;
import tech.getarrays.RentowniaBackendDemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AddressService addressService;

    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{user_id}/address/{address_id}")
    public ResponseEntity<User> addAddressToUser(@PathVariable Long user_id, @PathVariable Long address_id){
        User user = userService.getUserById(user_id);
        Address address = addressService.getAddressById(address_id);
        user.setAddress(address);
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
