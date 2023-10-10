package dev.frodo.students.Controllers;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.frodo.students.Domain.MasterStudent;
import dev.frodo.students.Domain.Student;
import dev.frodo.students.Repository.MasterStudentRepository;
import dev.frodo.students.Repository.StudentRepository;

    @RestController
@RequestMapping("api/v1/masterStudents/")
public class MasterStudentsController {
    @Autowired
    private MasterStudentRepository studentRepository;

     @GetMapping
     @RequestMapping("getAll")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<List<MasterStudent>> getAll() {
        
        try{
            List<MasterStudent> students =studentRepository.getAll().get();
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
    public ResponseEntity<MasterStudent> insertStudent( @RequestBody MasterStudent student)  {
        
        try{
            MasterStudent studentresponse =studentRepository.createAsync(student).get();

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

      
     @PutMapping("update/updateMaster")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<MasterStudent> updateMasterStudent(@RequestBody MasterStudent student)  {
        
        try{        
            MasterStudent studentresponse =studentRepository.updateAsync(student).get();

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

    /*
     * @GetMapping("details/{id}")
     * public String read(@PathVariable int employeeId, Model model)
     * {
     */
     @GetMapping
     @RequestMapping("get/{id}")
     @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<MasterStudent> getById(String id)  {
        
        try{
            MasterStudent studentresponse =studentRepository.getById(id).get();

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
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }

    @DeleteMapping("deleteUngraduated/")
     @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<Boolean> deleteUngraduatedMasterStudents()  {
       Boolean response =  this.studentRepository.deleteMasterStudentsWithGradeLessThan5();
       if(response)
       {
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
       }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("delete/{id}")
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
    
    @GetMapping("getUngraduated/")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<List<MasterStudent>> getUngraduatedMasterStudents()  {
        
        try{
            List<MasterStudent> studentresponse =studentRepository.getUngraduatedMasterStudentsAsync();

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
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }
    

     @RequestMapping("getAvailable/")
     @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<List<MasterStudent>> getAvailableMasterStudents()  {
        
        try{
            List<MasterStudent> studentresponse =studentRepository.getMasterStudentsByTeacherSupervisorId("");

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
            //logger da n-am
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();       
    }
    
}


