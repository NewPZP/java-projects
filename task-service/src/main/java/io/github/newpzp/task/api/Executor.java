package io.github.newpzp.task.api;

public interface Executor<T> {
    
   T execute(Command<T> command);
   
}
