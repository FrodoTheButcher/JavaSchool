package dev.frodo.students.DataAbstraction;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
/**
 * @param id
 * @param name
 * @param age
 * @param gender
 * @param email
 */
public abstract class IPerson {
    @Id
    private String id;
    private String name="";
    private int age=0;
    private String gender="";
    private String email="";
    public IPerson()
    {
        
    }

    public IPerson(String id, String name, int age, String gender, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
    public IPerson(String name, int age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id=Id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

      public void setAge(int age) {
            this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
}

