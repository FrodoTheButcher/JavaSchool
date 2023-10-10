package dev.frodo.students.DataAbstraction.IRepositoryFolder;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import dev.frodo.students.DataAbstraction.IRepository;
import dev.frodo.students.Domain.Student;

public interface IStudentsRepository extends MongoRepository<Student,ObjectId> {
    
}
