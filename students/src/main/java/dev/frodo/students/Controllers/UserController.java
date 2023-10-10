package dev.frodo.students.Controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.frodo.students.Application.User.UserRequest;
import dev.frodo.students.Domain.Student;
import dev.frodo.students.Domain.Teacher;
import dev.frodo.students.Domain.User;
import dev.frodo.students.Repository.StudentRepository;
import dev.frodo.students.Repository.TeacherRepository;
import dev.frodo.students.Repository.UserRepository;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

     @GetMapping
     @RequestMapping("getAll")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<List<User>> getAll() {
        
        try{
            List<User> users =userRepository.getAll().get();
             return ResponseEntity.ok(users);
        }
        catch(Exception e)
        {
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }       
    }
    
     @RequestMapping("get/{id}")
     @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<User> getById(@PathVariable String id)  {
        
        try{
            User response =userRepository.getById(id).get();
            
            if(response == null)
            {
                return ResponseEntity.badRequest().build();
            }
            if(response != null)
            {
                return ResponseEntity.ok(response);
            }
        }
        catch(Exception e)
        {
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }
    
}
