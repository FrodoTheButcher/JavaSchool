package dev.frodo.students.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import dev.frodo.students.DataAbstraction.IRepository;
import dev.frodo.students.DataAbstraction.IRepositoryFolder.IStudentsRepository;
import dev.frodo.students.Domain.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentRepository implements IRepository<Student>  {

    private final IStudentsRepository studentRepository;

    @Autowired
    public StudentRepository(IStudentsRepository studentsRepository)
    {
        this.studentRepository = studentsRepository;
    }

    @Override
    public CompletableFuture<Student> createAsync(Student entity) {
        try {
            if(entity.getEmail().length()<4 || entity.getEmail().contains("@")==false)
                return null;
            Student createdStudent = this.studentRepository.save(entity);
            log.info("Created student with id: {}", createdStudent.getId());
            return CompletableFuture.completedFuture(createdStudent);
        } catch (DataAccessException e) {
            log.error("Error creating student", e);
            return CompletableFuture.failedFuture(e);
        }
    }

    @Override
    public CompletableFuture<Student> getById(String id) {

        ObjectId objId = new ObjectId(id);
        Student student = this.studentRepository.findById(objId).get();
        return CompletableFuture.completedFuture(student);

    }

    @Override
    public CompletableFuture<List<Student>> getAll() {
        List<Student>students = this.studentRepository.findAll();
        return CompletableFuture.completedFuture(students);
    }

    @Override
    public CompletableFuture<Student> updateAsync(Student entity) {
        try {
            if(entity.getEmail().length()<4 || entity.getEmail().contains("@")==false)
                return null;
            ObjectId objId = new ObjectId(entity.getId());
            Student existingStudent = this.studentRepository.findById(objId).orElse(null);
            
            if (existingStudent != null) {
                existingStudent.setName(entity.getName());
                existingStudent.setEmail(entity.getEmail());
    
                Student updatedStudent = this.studentRepository.save(existingStudent);
                log.info("Updated student with id: {}", updatedStudent.getId());
                return CompletableFuture.completedFuture(updatedStudent);
            } else {
                log.error("Student with ID {} not found for update", entity.getId());
                return CompletableFuture.failedFuture(new RuntimeException("Student not found"));
            }
        } catch (DataAccessException e) {
            log.error("Error updating student", e);
            return CompletableFuture.failedFuture(e);
        }
    }
    
    

    @Override
public CompletableFuture<Boolean> deleteAsync(String id) {
    try {
        ObjectId objId = new ObjectId(id);
        studentRepository.deleteById(objId);
        log.info("Deleted student with id: {}", id);
        return CompletableFuture.completedFuture(true);
    } catch (DataAccessException e) {
        log.error("Error deleting student with id: {}", id, e);
        return CompletableFuture.completedFuture(false);
    }
}    
}
