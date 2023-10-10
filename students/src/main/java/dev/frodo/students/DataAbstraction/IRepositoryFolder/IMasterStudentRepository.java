package dev.frodo.students.DataAbstraction.IRepositoryFolder;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import dev.frodo.students.DataAbstraction.IRepository;
import dev.frodo.students.Domain.MasterStudent;
import dev.frodo.students.Domain.Student;
import dev.frodo.students.Domain.Teacher;

public interface IMasterStudentRepository extends MongoRepository<MasterStudent, ObjectId> {
}
