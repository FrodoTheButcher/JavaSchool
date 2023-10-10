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

import dev.frodo.students.Domain.Student;
import dev.frodo.students.Domain.Teacher;
import dev.frodo.students.Repository.StudentRepository;
import dev.frodo.students.Repository.TeacherRepository;

@RestController
@RequestMapping("api/v1/teachers/")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

     @GetMapping
     @RequestMapping("getAll")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<List<Teacher>> getAll() {
        
        try{
            List<Teacher> teachers =teacherRepository.getAll().get();
             return ResponseEntity.ok(teachers);
        }
        catch(Exception e)
        {
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }       
    }

    
     @RequestMapping("getAllAvailableTeachers")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<List<Teacher>> getAllAvailableTeachers() {
        
        try{
            List<Teacher> teachers =teacherRepository.getAllAvailableTeachers();
             return ResponseEntity.ok(teachers);
        }
        catch(Exception e)
        {
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }       
    }

     @PutMapping("updateRelation/{StudentId}/{TeacherId}/")
    @CrossOrigin(origins = "http://localhost:3000/")
    
    public ResponseEntity<Boolean> updateRelation(@PathVariable String StudentId,@PathVariable String TeacherId) {
        
        try{
            boolean teachers =teacherRepository.updateRelation(StudentId,TeacherId);
             return ResponseEntity.ok(teachers);
        }
        catch(Exception e)
        {
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }       
    }

     @PostMapping("insert")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<Teacher> insertStudent(@RequestBody Teacher teacher)  {
        
        try{
            Teacher response =teacherRepository.createAsync(teacher).get();

            if(response == null)
            {
                return ResponseEntity.badRequest().build();
            }
            if(response != null)
            {
                return ResponseEntity.ok(teacher);
            }
        }
        catch(Exception e)
        {
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }

    /*
     * @GetMapping("details/{id}")
     * public String read(@PathVariable int employeeId, Model model)
     * {
     */
     @GetMapping
     @RequestMapping("get/{id}")
     @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<Teacher> getById(@PathVariable String id)  {
        
        try{
            Teacher response =teacherRepository.getById(id).get();

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
