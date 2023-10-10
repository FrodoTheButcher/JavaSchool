package dev.frodo.students.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.mongodb.core.query.Query;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import dev.frodo.students.DataAbstraction.IRepository;
import dev.frodo.students.DataAbstraction.IRepositoryFolder.IMasterStudentRepository;
import dev.frodo.students.Domain.MasterStudent;
import dev.frodo.students.Domain.Student;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MasterStudentRepository  implements IRepository<MasterStudent>  {

      private final IMasterStudentRepository studentRepository;
      private final MongoTemplate mongoTemplate;

    @Autowired
    public MasterStudentRepository(IMasterStudentRepository studentRepository, MongoTemplate template) {
        this.studentRepository = studentRepository;
        this.mongoTemplate = template;
    }

    public List<MasterStudent> getUngraduatedMasterStudentsAsync() {
        Query query = new Query();
        query.addCriteria(Criteria.where("GraduationNote").lt(5.0));
        List<MasterStudent> students = mongoTemplate.find(query, MasterStudent.class);
        return students;
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
    

    @Override
    public CompletableFuture<MasterStudent> createAsync(MasterStudent entity) {
        try {
            if(entity.getEmail().length()<4 || entity.getEmail().contains("@")==false)
                return null;

            MasterStudent createdStudent = this.studentRepository.save(entity);
            log.info("Created student with id: {}", createdStudent.getId());
            return CompletableFuture.completedFuture(createdStudent);
        } catch (DataAccessException e) {
            log.error("Error creating student", e);
            return null;
        }
    }

    public boolean deleteMasterStudentsWithGradeLessThan5() {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("GraduationNote").lt(5.0));
            mongoTemplate.remove(query, MasterStudent.class);
            return true; // Deletion was successful
        } catch (DataAccessException e) {
            log.error("Error deleting master students with grade less than 5", e);
            return false; // Deletion failed
        }
    }
    
    public List<MasterStudent> getMasterStudentsByTeacherSupervisorId(String teacherSupervisorId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("teacherSupervisorId").is(""));
        List<MasterStudent> students = mongoTemplate.find(query, MasterStudent.class);
        return students;  
      }
    

    public CompletableFuture<MasterStudent> getById(String id) {

        ObjectId objid = new ObjectId(id);
        MasterStudent student = this.studentRepository.findById(objid).get();
        return CompletableFuture.completedFuture(student);

    }

    @Override
    public CompletableFuture<List<MasterStudent>> getAll() {
        List<MasterStudent>students = this.studentRepository.findAll();
        return CompletableFuture.completedFuture(students);
    }

    @Override
    public CompletableFuture<MasterStudent> updateAsync(MasterStudent entity) {
        try {
            if(entity.getEmail().length()<4 || entity.getEmail().contains("@")==false)
            return null;
            ObjectId objId = new ObjectId(entity.getId());
            MasterStudent existingStudent = this.studentRepository.findById(objId).orElse(null);
    
            if (existingStudent != null) {
                existingStudent.setName(entity.getName());
                existingStudent.setEmail(entity.getEmail());
    
                MasterStudent updatedStudent = this.studentRepository.save(existingStudent);
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
    
     
    
}
