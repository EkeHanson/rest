package com.hanson.app.rest.Controller;
import com.hanson.app.rest.Model.User;
import com.hanson.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AppController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return  "Welcome Abraham, Ekene-onwon Hanson";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
      userRepo.save(user);
      return  "Entry saved successfully...";
    }
    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return  "Entry updated successfully...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return  "Entry with userID: " +id+ " deleted successfully...";
    }
}

