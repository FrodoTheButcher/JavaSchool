package dev.frodo.students.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import dev.frodo.students.Application.User.UserRequest;
import dev.frodo.students.DataAbstraction.IRepository;
import dev.frodo.students.DataAbstraction.IRepositoryFolder.IUserRepository;
import dev.frodo.students.Domain.User;

@Service
public class UserRepository implements IRepository<User> {

    private final IUserRepository userRepository;

    @Autowired
    public UserRepository(IUserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    private Boolean validatePassword(String password1,String password2)
    {
        return password1.equals(password2) && password1.length()>5;
    }

    private Boolean validateEmail(String Email)
    {
        return Email.contains("@yahoo.com") || Email.contains("@gmail.com");
    }
     @Override
public CompletableFuture<Boolean> deleteAsync(String id) {
    try {
        ObjectId objId = new ObjectId(id);
        userRepository.deleteById(objId);
        return CompletableFuture.completedFuture(true);
    } catch (DataAccessException e) {
        return CompletableFuture.completedFuture(false);
    }
}
    
    private Boolean validateUserCredentials(UserRequest user)
    {
        return this.validateEmail(user.getEmail()) && this.validatePassword(user.getPassword(),user.getPassword2());
    }

    @Override
    public CompletableFuture<User> getById(String id) {
        User user = this.userRepository.findById(new ObjectId(id)).get();
        return CompletableFuture.completedFuture(user);
    }

    @Override
    public CompletableFuture<List<User>> getAll() {
        List<User> users = this.userRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }

    @Override
    public CompletableFuture<User> updateAsync(User entity) {
        ObjectId userId = new ObjectId(entity.getId());
        
        User user = this.userRepository.findById(userId).get();
        if( user == null)
        {
            return null;
        }

        user.setAge(entity.getAge());
        user.setEmail(entity.getEmail());
        user.setName(entity.getName());
        this.userRepository.save(user);
        return CompletableFuture.completedFuture(user);
    }

    @Override
    public CompletableFuture<User> createAsync(User entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAsync'");
    }

   
    
}
