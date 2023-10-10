package dev.frodo.students.Application.User;

import dev.frodo.students.Domain.User;

public class UserRequest extends User  {
 
 

public UserRequest(String name, int age, String gender, String email) {
    super(name, age, gender, email);
  }

private String password2;
  
  public void setPassword2(String password2)
  {
    this.password2 = password2;
  }

  public String getPassword2()
  {
    return this.password2;
  }
}
