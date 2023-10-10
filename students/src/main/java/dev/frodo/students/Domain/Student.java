package dev.frodo.students.Domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.frodo.students.DataAbstraction.IPerson;


@Document(collection = "StudentsCollection")
public class Student extends IPerson {

    public Student()
    {
        
    }
    public Student(String id, String name, int age, String gender, String email) {
        super(id, name, age, gender, email);
    }
}

