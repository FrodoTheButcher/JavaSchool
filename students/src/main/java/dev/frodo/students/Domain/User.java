package dev.frodo.students.Domain;

import org.bson.types.ObjectId;

import dev.frodo.students.DataAbstraction.IPerson;
import dev.frodo.students.DataAbstraction.IUser;

public class User extends IPerson  implements IUser{

    private String password;

     public User(String id, String name, int age, String gender, String email) {
        super(id, name, age, gender, email);
    }
 
      public User(String name, int age, String gender, String email) {
        super(name, age, gender, email);
    }
 
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

 
}
