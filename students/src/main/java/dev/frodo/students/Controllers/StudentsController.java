package dev.frodo.students.Controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.frodo.students.Domain.MasterStudent;
import dev.frodo.students.Domain.Student;
import dev.frodo.students.Repository.StudentRepository;

@RestController
@RequestMapping("api/v1/students/")
public class StudentsController {

    @Autowired
    private StudentRepository studentRepository;

     @GetMapping
     @RequestMapping("getAll")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<List<Student>> getAll() {
        
        try{
            List<Student> students =studentRepository.getAll().get();
             return ResponseEntity.ok(students);
        }
        catch(Exception e)
        {
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }       
    }

     @PostMapping
     @RequestMapping("insert")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student)  {
        
        try{
            Student studentresponse =studentRepository.createAsync(student).get();

            if(studentresponse == null)
            {
                return ResponseEntity.badRequest().build();
            }
            if(studentresponse != null)
            {
                return ResponseEntity.ok(student);
            }
        }
        catch(Exception e)
        {
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }

         @PutMapping("update/updateStudent/")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)  {
        
        try{
            Student studentresponse =studentRepository.updateAsync(student).get();

            if(studentresponse == null)
            {
                return ResponseEntity.badRequest().build();
            }
            if(studentresponse != null)
            {
                return ResponseEntity.ok(student);
            }
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }

     @GetMapping
     @RequestMapping("get/{id}")
     @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<Student> getById(@PathVariable String id)  {
        
        try{
            Student studentresponse =studentRepository.getById(id).get();

            if(studentresponse == null)
            {
                return ResponseEntity.badRequest().build();
            }
            if(studentresponse != null)
            {
                return ResponseEntity.ok(studentresponse);
            }
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }

     @DeleteMapping("{id}")
     @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id)  {
        
        try{
            Boolean studentresponse =studentRepository.deleteAsync(id).get();

            if(!studentresponse )
            {
                return ResponseEntity.badRequest().build();
            }
            if(studentresponse)
            {
                return ResponseEntity.ok(studentresponse);
            }
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }
    
}
