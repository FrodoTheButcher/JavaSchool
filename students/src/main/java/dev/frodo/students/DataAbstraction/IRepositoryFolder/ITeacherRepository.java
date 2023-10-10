package dev.frodo.students.DataAbstraction.IRepositoryFolder;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import dev.frodo.students.DataAbstraction.IRepository;
import dev.frodo.students.Domain.Student;
import dev.frodo.students.Domain.Teacher;

public interface ITeacherRepository extends MongoRepository<Teacher,ObjectId> {
    
}
