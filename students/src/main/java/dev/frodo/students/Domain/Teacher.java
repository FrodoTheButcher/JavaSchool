package dev.frodo.students.Domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.frodo.students.DataAbstraction.IPerson;


@Document(collection = "TeacherCollection")
public class Teacher extends IPerson {
  
    private String masterStudent_id;
    private boolean available;

      public Teacher(String id, String name, int age, String gender, String email) {
        super(id, name, age, gender, email);
        this.available = true;
    }

    public String getMasterStudent_id() {
        return masterStudent_id;
    }

    public void setMasterStudent_id(String masterStudent_id) {
        this.masterStudent_id = masterStudent_id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
