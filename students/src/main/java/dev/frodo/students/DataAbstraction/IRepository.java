package dev.frodo.students.DataAbstraction;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.bson.types.ObjectId;


public interface IRepository<T> {
    CompletableFuture<T> getById(String id);
    CompletableFuture<List<T>> getAll();
    CompletableFuture<T> createAsync(T entity);
    CompletableFuture<T> updateAsync(T entity);
    CompletableFuture<Boolean> deleteAsync(String id);

}