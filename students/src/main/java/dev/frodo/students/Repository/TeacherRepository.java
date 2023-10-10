package dev.frodo.students.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.data.mongodb.core.query.Query;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import dev.frodo.students.DataAbstraction.IRepository;
import dev.frodo.students.DataAbstraction.IRepositoryFolder.IMasterStudentRepository;
import dev.frodo.students.DataAbstraction.IRepositoryFolder.IStudentsRepository;
import dev.frodo.students.DataAbstraction.IRepositoryFolder.ITeacherRepository;
import dev.frodo.students.Domain.MasterStudent;
import dev.frodo.students.Domain.Student;
import dev.frodo.students.Domain.Teacher;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TeacherRepository implements IRepository<Teacher>  {

    private final ITeacherRepository teacherRepository;
    private final IMasterStudentRepository masterStudentRepository;
      private final MongoTemplate mongoTemplate;

    @Autowired
    public TeacherRepository(ITeacherRepository teacherRepository, IMasterStudentRepository masterStudentRepository, MongoTemplate template)
    {
        this.teacherRepository = teacherRepository;
        this.masterStudentRepository = masterStudentRepository;
        this.mongoTemplate = template;
    }

    @Override
    public CompletableFuture<Teacher> createAsync(Teacher entity) {
        try {
            Teacher createdTeacher = this.teacherRepository.save(entity);
            log.info("Created Teacher with id: {}", createdTeacher.getId());
            return CompletableFuture.completedFuture(createdTeacher);
        } catch (DataAccessException e) {
            log.error("Error creating Teacher", e);
            return CompletableFuture.failedFuture(e);
        }
    }
    @Override
    public CompletableFuture<Boolean> deleteAsync(String id) {
        try {
            ObjectId objId = new ObjectId(id);
            teacherRepository.deleteById(objId);
            log.info("Deleted student with id: {}", id);
            return CompletableFuture.completedFuture(true);
        } catch (DataAccessException e) {
            log.error("Error deleting student with id: {}", id, e);
            return CompletableFuture.completedFuture(false);
        }
    }

    @Override
    public CompletableFuture<Teacher> getById(String id) {

        ObjectId objId = new ObjectId(id);
        Teacher Teacher = this.teacherRepository.findById(objId).get();
        return CompletableFuture.completedFuture(Teacher);

    }

    public List<Teacher> getAllAvailableTeachers() {
        Query query = new Query();
        query.addCriteria(Criteria.where("available").is(true));
        List<Teacher> teachers = mongoTemplate.find(query, Teacher.class);
        return teachers;  
    }

    

    public boolean updateRelation(String studentId, String teacherId) throws InterruptedException, ExecutionException {
        try {
            ObjectId studentIdObj = new ObjectId(studentId);
            MasterStudent student = masterStudentRepository.findById(studentIdObj).orElse(null);

            if (student == null) {
                return false;
            }

            CompletableFuture<Teacher> teacherFuture = getById(teacherId);
            if (teacherFuture.isCompletedExceptionally() || teacherFuture.get() == null) {
                return false;
            }

            Teacher teacher = teacherFuture.get();

            teacher.setAvailable(false);
            student.setTeacherSupervisorId(teacher.getId());

            masterStudentRepository.save(student);
            teacherRepository.save(teacher);

            return true;
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException("Error updating relationship", ex);
        }
    }

    @Override
    public CompletableFuture<List<Teacher>> getAll() {
        List<Teacher>Teachers = this.teacherRepository.findAll();
        return CompletableFuture.completedFuture(Teachers);
    }

    @Override
    public CompletableFuture<Teacher> updateAsync(Teacher entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAsync'");
    }

     
    
}
